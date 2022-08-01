package com.portfolio.portofolio.service;

import java.util.List;

import com.portfolio.portofolio.model.About;

public interface IAboutService {
    
    public List<About> listAbouts();

    public void createAbout(About about);

    public void deleteAbout(Long id);

    public About searchAbout(Long id);

    public About saveAbout(About about);
}
