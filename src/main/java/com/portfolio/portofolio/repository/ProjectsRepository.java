package com.portfolio.portofolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portofolio.model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {
    
}
