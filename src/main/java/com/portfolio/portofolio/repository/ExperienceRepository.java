package com.portfolio.portofolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portofolio.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{
    
}
