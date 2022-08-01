package com.portfolio.portofolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.model.Projects;
import com.portfolio.portofolio.repository.ProjectsRepository;

@Service
public class ProjectsService implements IProjectsService {

    @Autowired
    public ProjectsRepository proRepo;

    @Override
    public void createProject(Projects pro) {
        proRepo.save(pro);
    }

    @Override
    public void deleteProject(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public List<Projects> listProject() {
        return proRepo.findAll();
    }

    @Override
    public Projects saveProject(Projects pro) {
        return proRepo.save(pro);
    }

    @Override
    public Projects searchProject(Long id) {
        return proRepo.findById(id).orElse(null);
    }


}
