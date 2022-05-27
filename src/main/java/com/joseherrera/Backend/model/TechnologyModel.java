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
@Table(name = "Technology")
public class TechnologyModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String logo = "";
    private String name = "name";

    public TechnologyModel() {
    }

    public TechnologyModel(int id, String logo, String name) {
        this.id = id;
        this.logo = logo;
        this.name = name;
    }

}
