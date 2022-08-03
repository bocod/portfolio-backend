package com.portfolio.portofolio.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String firstname;
    private String surname;
    private String subtitle;
    private String location;
    private String contact;
    private String avatar;

    public Profile(){}

    public Profile( Long id, 
                    String firstname, 
                    String surname, 
                    String subtitle, 
                    String location , 
                    String contact,
                    String avatar
                ) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.subtitle = subtitle;
        this.location = location;
        this.contact = contact;
        this.avatar = avatar;
    }

    // @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private About about;

}
