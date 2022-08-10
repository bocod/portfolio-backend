package com.portfolio.portofolio.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.portofolio.security.entity.Role;
import com.portfolio.portofolio.security.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
