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

import com.portfolio.backend.model.Experience;
import com.portfolio.backend.service.ExperienceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExperienceController {
    
    @Autowired
    ExperienceService experienceService;

    @GetMapping ("experience")
    public List<Experience> getExperience(){
        return experienceService.getExperiences();
    }

    @PostMapping ("experience/save")
    public Experience saveExperience(@RequestBody Experience experience){
        experienceService.saveExperience(experience);
        return experience;
    }

    @PutMapping("experience/edit/{id}")
    public Experience editExperience(@PathVariable Long id,
    @RequestBody Experience exp
    ){
        Experience experience = experienceService.findExperience(id);
        experience.setTitle(exp.getTitle());
        experience.setDescription(exp.getDescription());
        experience.setEmployer(exp.getEmployer());
        experience.setDate(exp.getDate());
        experience.setImage(exp.getImage());

        experienceService.saveExperience(experience);
        return experience;
    }

    @DeleteMapping ("experience/delete/{id}")
    public String deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
        return "Eliminado correctamente";
    }

}
