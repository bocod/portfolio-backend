package com.portfolio.portofolio.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class About {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Basic
    private String about;

    //Alternative one with detail to get id from profile
    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id")
    // private Profile profile;

    //Alt 2 but it doesn't get any value
    // @OneToOne
    // private Profile profile;

    // public About(Long id, String about, Profile profile) {
    //     this.id = id;
    //     this.about = about;
    //     this.profile = profile;
    // }
    public About() {}

    public About(Long id, String about) {
        this.id = id;
        this.about = about;
    }
}
