package com.portfolio.portofolio.service;

import java.util.List;

import com.portfolio.portofolio.model.Education;

public interface IEducationService {
    
    public List<Education> listEducation();

    public void createEducation(Education exp);

    public void deleteEducation(Long id);

    public Education searchEducation(Long id);

    public Education saveEducation(Education exp);
}
