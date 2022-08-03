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
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic
    private String role;
    private String company;
    private String start;
    private String end;
    private String location;
    private String description;
    private Boolean currentJob;
    private String contract;
    private String logoURL;
    
    @ManyToOne
    private Profile profile;

    public Experience(){}

    public Experience(  Long id,
                        String role,
                        String company,
                        String start,
                        String end,
                        String location,
                        String description,
                        Boolean currentJob,
                        String contract,
                        String logoURL,
                        Profile profile ) {

        this.id = id;
        this.role = role;
        this.company = company;
        this.start = start;
        this.end = end;
        this.location = location;
        this.description = description;
        this.currentJob = currentJob;
        this.contract = contract;
        this.logoURL = logoURL;
        this.profile = profile;
        
    }

}
