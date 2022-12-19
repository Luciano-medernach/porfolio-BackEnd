package com.portfolio.backend.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.portfolio.backend.model.Image;
import com.portfolio.backend.service.ImageService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @PostMapping("/image/save")
    public Image saveImage(@RequestParam("image") MultipartFile image) throws IOException {
        Image img = new Image(image.getOriginalFilename(), image.getContentType(),
				compressBytes(image.getBytes()));
		imageService.saveImage(img);
        return img;
    }

    @GetMapping("/image/get/{id}")
    public Image getImage(@PathVariable Long id) throws IOException{
        final Image image = imageService.getImage(id);
        Image img = new Image(image.getName(), image.getType(),
				decompressBytes(image.getContent()));

        return img;
    }

	@DeleteMapping("/image/delete/{id}")
	public String deleteImage(@PathVariable Long id) {
		this.imageService.deleteImage(id);
		return "Eliminado correctamente.";
	}

	@PutMapping("/image/edit/{id}")
	public Image editImage(@PathVariable Long id, @RequestParam("image") MultipartFile image) throws IOException {
		Image img = this.imageService.getImage(id);

		img.setName(image.getOriginalFilename());
		img.setContent(compressBytes(image.getBytes()));
		img.setType(image.getContentType());

		imageService.saveImage(img);
		return img;
	}

    // compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
}
