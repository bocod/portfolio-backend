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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic
    private String degree;
    private String institute;
    private Date end;
    private String logoURL;
    private String certificatefURL;
    private Boolean studying;
    private String description;

    @ManyToOne
    private Profile profile;

    public Education(   Long id,
                        String degree,
                        String institute,
                        Date end,
                        String logoURL,
                        String certificatefURL,
                        Boolean studying,
                        String description,
                        Profile profile ) {
        
        this.id = id;
        this.degree = degree;
        this.institute = institute;
        this.end = end;
        this.logoURL = logoURL;
        this.certificatefURL = certificatefURL;
        this.studying = studying;
        this.description = description;
        this.profile = profile;
    }
}
