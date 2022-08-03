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

import com.portfolio.portofolio.model.Education;
import com.portfolio.portofolio.service.IEducationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/education")
public class educationController {

    @Autowired
    private IEducationService eduServ;

    @GetMapping("/view")
    @ResponseBody
    public List<Education> viewEducation() {
        return eduServ.listEducation();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Education searchProfile( @PathVariable Long id) {
        return eduServ.searchEducation(id);
    }

    @PostMapping("/new")
    public void addEducation(@RequestBody Education edu) {
        eduServ.createEducation(edu);
    }

    @PutMapping("/put")
    public ResponseEntity<Education> putEducation(@RequestBody Education edu) {
        
        Education patchEducation = eduServ.saveEducation(edu);

        return new ResponseEntity<>(patchEducation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEducation(@PathVariable Long id) {
        eduServ.deleteEducation(id);
    }

}
