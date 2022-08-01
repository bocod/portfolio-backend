package com.portfolio.portofolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.model.Skills;
import com.portfolio.portofolio.repository.SkillsRepository;

@Service
public class SkillsService implements ISkillsService {

    @Autowired
    public SkillsRepository skillRepo;

    @Override
    public List<Skills> listSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void createSkill(Skills skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skills searchSkill(Long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public Skills saveSkill(Skills skill) {
        return skillRepo.save(skill);
    }
    
}
