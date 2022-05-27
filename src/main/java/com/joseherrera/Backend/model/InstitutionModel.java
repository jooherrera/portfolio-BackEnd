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
@Table(name = "Institution")
public class InstitutionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date = "date";
    private String extra = "";
    private String title = "title";
    @Lob
    private String logo = "";
    private String name = "name";

    public InstitutionModel() {
    }

    public InstitutionModel(int id, String date, String extra, String title, String logo, String name) {
        this.id = id;
        this.date = date;
        this.extra = extra;
        this.title = title;
        this.logo = logo;
        this.name = name;
    }

}
