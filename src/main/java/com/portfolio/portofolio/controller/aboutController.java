package com.portfolio.portofolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.portofolio.model.About;
import com.portfolio.portofolio.service.AboutService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "https://portfolio-24c0e.web.app")
@RequestMapping("/about")
public class aboutController {

    @Autowired
    AboutService aboutService;

    @PostMapping("/new")
    public ResponseEntity<About> createAbout(@RequestBody About about) {
        About newAbout = aboutService.saveAbout(about);
        return new ResponseEntity<>(newAbout, HttpStatus.CREATED);
    }

    @GetMapping("/view")
    @ResponseBody
    public List<About> viewAbouts() {
        return aboutService.listAbouts();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<About> searchAbout(@PathVariable("id") Long id){
        About about = aboutService.searchAbout(id);
        return new ResponseEntity<>(about, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<About> putAbout(@RequestBody About about){
        About patchAbout = aboutService.saveAbout(about);
        return new ResponseEntity<>(patchAbout, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAbout(@PathVariable("id") Long id) {
        aboutService.deleteAbout(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
