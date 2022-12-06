package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.backend.model.Education;
import com.portfolio.backend.repository.EducationRepository;

public class EducationService implements IEducationService{
    @Autowired
    EducationRepository educationRepository;

    @Override
    public List<Education> getEducation() {
        List<Education> educationList = educationRepository.findAll();
        return educationList;
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
        
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
        
    }

    @Override
    public Education findEducation(Long id) {
        Education education = educationRepository.findById(id).orElse(null);
        return education;
    }
    
}
