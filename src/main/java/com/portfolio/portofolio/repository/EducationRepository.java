package com.portfolio.portofolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portofolio.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
    
}
