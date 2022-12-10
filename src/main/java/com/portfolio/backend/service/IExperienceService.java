package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.model.Experience;

public interface IExperienceService {
    public List<Experience> getExperiences();

    public void saveExperience(Experience experience);
    public void deleteExperience(Long id);

    public Experience findExperience(Long id);
}
