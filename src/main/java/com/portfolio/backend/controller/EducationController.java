package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.model.Education;
import com.portfolio.backend.service.EducationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EducationController {
    
    @Autowired
    EducationService educationService;

    @GetMapping("/education")
    public List<Education> getEducation(){
        return educationService.getEducation();
    }

    @PostMapping ("/education/save")
    public Education saveEducation(@RequestBody Education education){
        educationService.saveEducation(education);
        return education;
    }

    @PutMapping ("/education/edit/{id}")
    public Education editEducation(@PathVariable Long id,
    @RequestBody Education educ){
        Education education = educationService.findEducation(id);

        education.setDate(educ.getDate());
        education.setDescription(educ.getDescription());
        education.setTitle(educ.getTitle());
        education.setInstitution(educ.getInstitution());
        education.setImage(educ.getImage());

        educationService.saveEducation(education);
        return education;
    }

    @DeleteMapping("/education/delete/{id}")
    public String deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
        return "Eliminado correctamente.";
    }
}
