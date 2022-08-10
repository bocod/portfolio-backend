package com.portfolio.portofolio.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portofolio.security.entity.User;
import com.portfolio.portofolio.security.repository.UserRepository;

@Service
@Transactional
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean existByEmail(String email){
        return userRepository.existByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
