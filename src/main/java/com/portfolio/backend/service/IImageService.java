package com.portfolio.backend.service;

import com.portfolio.backend.model.Image;

public interface IImageService {
    public Image getImage(Long id);

    public void saveImage(Image image);

    public void deleteImage(Long id);
}
