package com.joseherrera.Backend.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Person")
public class PersonModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dni;
    private String fullName;
    private String title;
    @Lob
    private String profileImg;
    @Lob
    private String bannerImg;

    public PersonModel() {
    }

    public PersonModel(int dni, String fullName, String title, String profileImg, String bannerImg) {
        this.dni = dni;
        this.fullName = fullName;
        this.title = title;
        this.profileImg = profileImg;
        this.bannerImg = bannerImg;
    }

}
