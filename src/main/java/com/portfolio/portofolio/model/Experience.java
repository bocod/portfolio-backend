package com.portfolio.portofolio.model;

import java.sql.Date;

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
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Basic
    private String role;
    private String company;
    private Date start;
    private Date end;
    private String location;
    private String description;
    private Boolean currentJob;
    
    @ManyToOne
    private Profile profile;

    public Experience(  Long id,
                        String role,
                        String company,
                        Date start,
                        Date end,
                        String location,
                        String description,
                        Boolean currentJob,
                        Profile profile ) {

        this.id = id;
        this.role = role;
        this.company = company;
        this.start = start;
        this.end = end;
        this.location = location;
        this.description = description;
        this.currentJob = currentJob;
        this.profile = profile;
        
    }

}
