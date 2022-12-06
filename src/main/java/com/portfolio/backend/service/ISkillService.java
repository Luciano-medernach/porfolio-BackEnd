package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.model.Skill;

public interface ISkillService {
    public List<Skill> getSkills();

    public void saveSkill(Skill skill);
    public void deleteSkill(Long id);
    public Skill findSkill(Long id);
}
