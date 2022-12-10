package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.model.Experience;
import com.portfolio.backend.repository.ExperienceRepository;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getExperiences() {
        List<Experience> experienceList = experienceRepository.findAll();
        return experienceList;
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
        
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }
    
}
