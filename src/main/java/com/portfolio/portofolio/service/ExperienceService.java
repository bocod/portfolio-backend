package com.portfolio.portofolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.model.Experience;
import com.portfolio.portofolio.repository.ExperienceRepository;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    public ExperienceRepository expRepo;

    @Override
    public void createExperience(Experience exp) {
        
        expRepo.save(exp);
    }

    @Override
    public void deleteExperience(Long id) {
        
        expRepo.deleteById(id);;
    }

    @Override
    public List<Experience> listExperiences() {
        
        return expRepo.findAll();
    }

    @Override
    public Experience saveExperience(Experience exp) {

        return expRepo.save(exp);
    }

    @Override
    public Experience searchExperience(Long id) {

        return expRepo.findById(id).orElse(null);
    }
    

}
