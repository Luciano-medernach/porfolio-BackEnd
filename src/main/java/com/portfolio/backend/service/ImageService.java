package com.portfolio.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.model.Image;
import com.portfolio.backend.repository.ImageRepository;

@Service
public class ImageService implements IImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image getImage(Long id) {
        return this.imageRepository.findById(id).orElse(null);
    }

    @Override
    public void saveImage(Image image) {
        this.imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        this.imageRepository.deleteById(id);
    }

}
