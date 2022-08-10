package com.portfolio.portofolio.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.portofolio.security.entity.MainUser;
import com.portfolio.portofolio.security.entity.User;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userService.getByEmail(email).get();
        return MainUser.build(user);
    }
    
}
