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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic
    private String name;
    private String description;

    @ManyToOne
    private Profile profile;

    public Projects( Long id, String name, String description, Profile profile) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.profile = profile;
    }
    
}
