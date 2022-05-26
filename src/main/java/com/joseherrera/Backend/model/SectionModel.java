package com.joseherrera.Backend.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Section")
public class SectionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sectionTitle;
    private boolean visible;


    public SectionModel() {
    }

    public SectionModel(int id, String sectionTitle, boolean visible) {
        this.id = id;
        this.sectionTitle = sectionTitle;
        this.visible = visible;
    }


   

}
