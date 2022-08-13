package com.portfolio.portofolio.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.portofolio.security.entity.Role;
import com.portfolio.portofolio.security.enums.RoleName;
import com.portfolio.portofolio.security.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
    
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role){
        roleRepository.save(role);
    }
}
