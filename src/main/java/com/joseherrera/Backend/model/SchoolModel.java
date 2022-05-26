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
@Table(name = "School")
public class SchoolModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company = "Company";
    @Lob
    private String logo = "i.ibb.co/WHDLsLN/default-Logo.png";

    public SchoolModel() {
    }

    public SchoolModel(int id, String company, String logo) {
        this.id = id;
        this.company = company;
        this.logo = logo;
    }

}
