package com.portfolio.portofolio.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;
    private String description;
    private String projectURL;

    @ManyToOne
    private Profile profile;

    public Projects(){}

    public Projects( Long id, String name, String description, String projectURL, Profile profile) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projectURL  = projectURL;
        this.profile = profile;
    }
    
}
