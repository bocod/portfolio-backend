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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portofolio.model.Experience;
import com.portfolio.portofolio.model.Profile;
import com.portfolio.portofolio.service.IExperienceService;
import com.portfolio.portofolio.service.IProfileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class mainController {


    @PostMapping("/auth/login")
    public void login() {
        
    }

    @Autowired
    private IProfileService profileServ;

    @PostMapping("/profile/new")
    public void addProfile( @RequestBody Profile prof ) {
        profileServ.createProfile(prof);
    }

    @GetMapping("/profile/view")
    @ResponseBody
    public List<Profile> viewProfiles() {
        return profileServ.listProfiles();
    }

    @DeleteMapping("/profile/delete/{id}")
    public void deleteProfile( @PathVariable Long id ) {
        profileServ.deleteProfile(id);
    }

    @PutMapping("/profile/put")
    public ResponseEntity<Profile> putProfile( @RequestBody Profile prof ) {
        
        Profile patchProfile = profileServ.saveProfile(prof);

        return new ResponseEntity<>(patchProfile, HttpStatus.OK);
    }

    @Autowired
    private IExperienceService expServ;

    @PostMapping("/experience/new")
    public void addExperience( @RequestBody Experience prof ) {
        expServ.createExperience(prof);
    }

    @GetMapping("/experience/view")
    @ResponseBody
    public List<Experience> viewExperiences() {
        return expServ.listExperiences();
    }

    @DeleteMapping("/experience/delete/{id}")
    public void deleteExperience( @PathVariable Long id ) {
        expServ.deleteExperience(id);
    }

    @PutMapping("/experience/put")
    public ResponseEntity<Experience> putExperience( @RequestBody Experience exp ) {
        
        Experience patchExperience = expServ.saveExperience(exp);

        return new ResponseEntity<>(patchExperience, HttpStatus.OK);
    }
}
