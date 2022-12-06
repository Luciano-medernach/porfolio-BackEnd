package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.backend.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long>{
    
}
