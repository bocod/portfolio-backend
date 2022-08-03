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

import com.portfolio.portofolio.model.Profile;
import com.portfolio.portofolio.service.IProfileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profile")
public class profileController {

    @Autowired
    private IProfileService profileServ;

    @PostMapping("/new")
    public void addProfile( @RequestBody Profile prof ) {
        profileServ.createProfile(prof);
    }

    @GetMapping("/view")
    @ResponseBody
    public List<Profile> viewProfiles() {
        return profileServ.listProfiles();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Profile searchProfile( @PathVariable Long id) {
        return profileServ.searchProfile(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfile( @PathVariable Long id ) {
        profileServ.deleteProfile(id);
    }

    @PutMapping("/put")
    public ResponseEntity<Profile> putProfile( @RequestBody Profile prof ) {
        
        Profile patchProfile = profileServ.saveProfile(prof);

        return new ResponseEntity<>(patchProfile, HttpStatus.OK);
    }
}
