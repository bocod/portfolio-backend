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

import com.portfolio.portofolio.model.Experience;
import com.portfolio.portofolio.service.IExperienceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experience")
public class experienceController {
    
    @Autowired
    private IExperienceService expServ;

    @PostMapping("/new")
    public void addExperience( @RequestBody Experience prof ) {
        expServ.createExperience(prof);
    }

    @GetMapping("/view")
    @ResponseBody
    public List<Experience> viewExperiences() {
        return expServ.listExperiences();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Experience searchProfile( @PathVariable Long id) {
        return expServ.searchExperience(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExperience( @PathVariable Long id ) {
        expServ.deleteExperience(id);
    }

    @PutMapping("/put")
    public ResponseEntity<Experience> putExperience( @RequestBody Experience exp ) {
        
        Experience patchExperience = expServ.saveExperience(exp);

        return new ResponseEntity<>(patchExperience, HttpStatus.OK);
    }
}
