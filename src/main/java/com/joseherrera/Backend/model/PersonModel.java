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
    private String name;
    private String lastName;
    private String title;
    @Lob
    private String profileImg;
    @Lob
    private String bannerImg;
    private int authId;

    public PersonModel() {
    }

    public PersonModel(int dni, String name, String lastName, String title, String profileImg, String bannerImg, int authId) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.title = title;
        this.profileImg = profileImg;
        this.bannerImg = bannerImg;
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "PersonModel{" + "dni=" + dni + ", name=" + name + ", lastName=" + lastName + ", title=" + title + ", profileImg=" + profileImg + ", bannerImg=" + bannerImg + ", authId=" + authId + '}';
    }

    public void updateAttribute(String key, Object value) {

        switch (key) {
            case "name":
                this.name = value.toString();
                break;
            case "lastName":
                this.lastName = value.toString();
                break;
            case "title":
                this.title = value.toString();
                break;
            case "profileImg":
                this.profileImg = value.toString();
                break;
            case "bannerImg":
                this.bannerImg = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

}
