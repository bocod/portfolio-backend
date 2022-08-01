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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Basic
    private String skill;
    private Integer level;
    private String levelName ;

    @ManyToOne
    private Profile profile;

    public Skills(Long id, String skill, Integer level, String levelName, Profile profile) {
        this.id = id;
        this.skill = skill;
        this.level = level;
        this.levelName = levelName;
        this.profile = profile;
    }

    
}
