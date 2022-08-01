package com.portfolio.portofolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.model.Education;
import com.portfolio.portofolio.repository.EducationRepository;

@Service
public class EducationService implements IEducationService {

    @Autowired
    public EducationRepository eduRepo;

    @Override
    public void createEducation(Education edu) {
        eduRepo.save(edu);
        
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public List<Education> listEducation() {
        return eduRepo.findAll();
    }

    @Override
    public Education saveEducation(Education edu) {
        return eduRepo.save(edu);
    }

    @Override
    public Education searchEducation(Long id) {
        return eduRepo.findById(id).orElse(null);
    }

    
}
