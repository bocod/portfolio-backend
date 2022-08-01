package com.portfolio.portofolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.model.Profile;
import com.portfolio.portofolio.repository.ProfileRepository;

@Service
public class ProfileService implements IProfileService {

    @Autowired
    public ProfileRepository profileRepo;

    @Override
    public List<Profile> listProfiles() {
        
        return profileRepo.findAll();
    }

    @Override
    public void createProfile(Profile prof) {
        
        profileRepo.save(prof);
    }

    @Override
    public void deleteProfile(Long id) {
        
        profileRepo.deleteById(id);
        
    }

    @Override
    public Profile searchProfile(Long id) {
        
        return profileRepo.findById(id).orElse(null);
    }

    @Override
    public Profile saveProfile(Profile prof)  {
        return profileRepo.save(prof);
    }

}
