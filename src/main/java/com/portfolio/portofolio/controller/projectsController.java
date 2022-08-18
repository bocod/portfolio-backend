package com.portfolio.portofolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portofolio.model.Projects;
import com.portfolio.portofolio.service.ProjectsService;

@RestController
@CrossOrigin(origins = "https://portfolio-24c0e.web.app")
@RequestMapping("/projects")
public class projectsController {

    @Autowired
    ProjectsService projectsService;

    @GetMapping("/view")
    @ResponseBody
    public List<Projects> viewSkills() {
        return projectsService.listProject();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Projects searchProjects( @PathVariable Long id) {
        return projectsService.searchProject(id);
    }
    
    @PostMapping("/new")
    public void addProject(@RequestBody Projects proj) {
        projectsService.createProject(proj);
    }

    @PutMapping("/put")
    public ResponseEntity<Projects> putProject(@RequestBody Projects proj) {
        Projects patchProject = projectsService.saveProject(proj);
        return new ResponseEntity<>(patchProject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id){
        projectsService.deleteProject(id);
    }
}
