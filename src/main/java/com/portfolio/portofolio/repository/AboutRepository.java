package com.portfolio.portofolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.portofolio.model.About;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {
    
}
