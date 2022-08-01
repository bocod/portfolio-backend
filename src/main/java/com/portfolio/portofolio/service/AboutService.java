package com.portfolio.portofolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.model.About;
import com.portfolio.portofolio.repository.AboutRepository;

@Service
public class AboutService implements IAboutService{

    @Autowired
    public AboutRepository aboutRepo;

    @Override
    public void createAbout(About about) {
        aboutRepo.save(about);
    }

    @Override
    public void deleteAbout(Long id) {
        aboutRepo.deleteById(id);
    }

    @Override
    public List<About> listAbouts() {
        return aboutRepo.findAll();
    }

    @Override
    public About saveAbout(About about) {
        return aboutRepo.save(about);
    }

    @Override
    public About searchAbout(Long id) {
        return aboutRepo.findById(id).orElse(null);
    }


    
}
