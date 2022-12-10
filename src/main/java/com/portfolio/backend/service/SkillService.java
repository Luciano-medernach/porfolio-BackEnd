package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.model.Skill;
import com.portfolio.backend.repository.SkillRepository;

@Service
public class SkillService implements ISkillService {
    
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getSkills() {
        List<Skill> skillsList = skillRepository.findAll();
        return skillsList;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }
}
