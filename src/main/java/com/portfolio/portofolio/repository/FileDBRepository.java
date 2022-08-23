package com.portfolio.portofolio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portfolio.portofolio.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
}