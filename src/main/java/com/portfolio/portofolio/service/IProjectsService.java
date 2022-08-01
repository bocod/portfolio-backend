package com.portfolio.portofolio.service;

import java.util.List;

import com.portfolio.portofolio.model.Projects;

public interface IProjectsService {
    
    public List<Projects> listProject();

    public void createProject(Projects pro);

    public void deleteProject(Long id);

    public Projects searchProject(Long id);

    public Projects saveProject(Projects pro);
}
