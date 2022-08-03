package com.portfolio.portofolio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class mainController {


    @PostMapping("/auth/login")
    public void login() {
        
    }


}
