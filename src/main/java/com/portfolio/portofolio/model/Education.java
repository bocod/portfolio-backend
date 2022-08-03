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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String degree;
    private String institute;
    private String end;
    private String logoURL;
    private String certificateURL;
    private Boolean studying;
    private String description;

    @ManyToOne
    private Profile profile;

    public Education(){}
    
    public Education(   Long id,
                        String degree,
                        String institute,
                        String end,
                        String logoURL,
                        String certificateURL,
                        Boolean studying,
                        String description,
                        Profile profile ) {
        
        this.id = id;
        this.degree = degree;
        this.institute = institute;
        this.end = end;
        this.logoURL = logoURL;
        this.certificateURL = certificateURL;
        this.studying = studying;
        this.description = description;
        this.profile = profile;
    }
}
