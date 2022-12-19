package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.backend.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    
}
