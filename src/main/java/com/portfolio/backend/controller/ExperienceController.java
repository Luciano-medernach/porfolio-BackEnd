package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.model.Experience;
import com.portfolio.backend.service.ExperienceService;

@RestController
public class ExperienceController {
    
    @Autowired
    ExperienceService experienceService;

    @GetMapping ("experience")
    public List<Experience> getExperience(){
        return experienceService.getExperiences();
    }

    @PostMapping ("experience/save")
    public String saveExperience(@RequestBody Experience experience){
        experienceService.saveExperience(experience);
        return "Guardado correctamente.";
    }

    @PutMapping("experience/edit/{id}")
    public Experience editExperience(@PathVariable Long id,
    @RequestParam String title,
    @RequestParam String description,
    @RequestParam String employer,
    @RequestParam String date,
    @RequestParam String image
    ){
        Experience experience = experienceService.findExperience(id);
        experience.setTitle(title);
        experience.setDescription(description);
        experience.setEmployer(employer);
        experience.setDate(date);
        experience.setImage(image);

        experienceService.saveExperience(experience);
        return experience;
    }

    @DeleteMapping ("experience/delete/{id}")
    public String deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
        return "Eliminado correctamente";
    }

}
