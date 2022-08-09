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
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String skill;
    private Integer level;

    @ManyToOne
    private Profile profile;

    public Skills(){}

    public Skills(Long id, String skill, Integer level, Profile profile) {
        this.id = id;
        this.skill = skill;
        this.level = level;
        this.profile = profile;
    }

    
}
