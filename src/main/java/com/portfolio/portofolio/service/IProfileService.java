package com.portfolio.portofolio.service;

import java.util.List;

import com.portfolio.portofolio.model.Profile;

public interface IProfileService {
    
    public List<Profile> listProfiles();

    public void createProfile( Profile prof );

    public void deleteProfile( Long id );

    public Profile searchProfile( Long id );

    public Profile saveProfile( Profile prof );
    
}
