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

import com.portfolio.portofolio.model.Skills;
import com.portfolio.portofolio.service.SkillsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skills")
public class skillsController {
    
    @Autowired
    SkillsService skillsService;

    @PostMapping("/new")
    public ResponseEntity<Skills> addSkill( @RequestBody Skills skill ) {
        Skills newSkill = skillsService.saveSkill(skill);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @GetMapping("/view")
    @ResponseBody
    public List<Skills> viewSkills() {
        return skillsService.listSkills();
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public Skills searchSkill( @PathVariable Long id) {
        return skillsService.searchSkill(id);
    }

    @PutMapping("/put")
    public ResponseEntity<Skills> putProject(@RequestBody Skills skill) {
        Skills patchSkill = skillsService.saveSkill(skill);
        return new ResponseEntity<>(patchSkill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkill(@PathVariable Long id){
        skillsService.deleteSkill(id);
    }
}
