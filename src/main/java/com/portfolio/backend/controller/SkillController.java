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

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.service.ISkillService;

public class SkillController {
    @Autowired
    private ISkillService skillService;

    @GetMapping ("/skills")
    public List<Skill> getSkills(){
        return skillService.getSkills();
    }

    @PostMapping("/skills/create")
    public String saveSkill(@RequestBody Skill skill){
        skillService.saveSkill(skill);
        return "Se ha registrado correctamente.";
    }

    @DeleteMapping("/skills/delete/{id}")
    public String deleteSkill(@PathVariable Long id){
        skillService.deleteSkill(id);
        return "Se ha eliminado correctamente";
    }

    @PutMapping("/skills/edit/{id}")
    public Skill editSkill(@PathVariable Long id,
    @RequestParam String name,
    @RequestParam int percentage){
        Skill skill = skillService.findSkill(id);

        skill.setName(name);
        skill.setPercentage(percentage);

        skillService.saveSkill(skill);

        return skill;
    }
}