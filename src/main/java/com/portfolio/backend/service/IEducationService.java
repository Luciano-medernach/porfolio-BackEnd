package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.model.Education;

public interface IEducationService {
    public List<Education> getEducation();

    public void saveEducation(Education education);
    public void deleteEducation(Long id);

    public Education findEducation(Long id);
}
