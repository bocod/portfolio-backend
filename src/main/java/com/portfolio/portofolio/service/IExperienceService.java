package com.portfolio.portofolio.service;

import java.util.List;

import com.portfolio.portofolio.model.Experience;

public interface IExperienceService {
    
    public List<Experience> listExperiences();

    public void createExperience(Experience exp);

    public void deleteExperience(Long id);

    public Experience searchExperience(Long id);

    public Experience saveExperience(Experience exp);
}
