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
@Table(name = "Skill")
public class SkillModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name = "New skill";
    private int porcent = 0;

    public SkillModel() {
    }

    public SkillModel(int id, String name, int porcent) {
        this.id = id;
        this.name = name;
        this.porcent = porcent;
    }
}
