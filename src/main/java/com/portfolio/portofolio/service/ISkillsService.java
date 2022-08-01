package com.portfolio.portofolio.service;

import java.util.List;

import com.portfolio.portofolio.model.Skills;

public interface ISkillsService {
    
    public List<Skills> listSkills();

    public void createSkill(Skills skill);

    public void deleteSkill(Long id);

    public Skills searchSkill(Long id);

    public Skills saveSkill(Skills skill);
}
