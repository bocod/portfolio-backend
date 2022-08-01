package com.portfolio.portofolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portofolio.model.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
    
}
