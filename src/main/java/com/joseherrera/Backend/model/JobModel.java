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
@Table(name = "Job")
public class JobModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String logo = "i.ibb.co/WHDLsLN/default-Logo.png";
    private String name = "name";
    private String company = "company name";
    private String date = "date";

    public JobModel() {
    }

    public JobModel(int id, String logo, String name, String company, String date ) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.company = company;
        this.date = date;
    }

    
}
