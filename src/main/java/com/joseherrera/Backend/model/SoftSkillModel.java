package com.joseherrera.Backend.model;

import com.joseherrera.Backend.interfaces.IModel;
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
@Table(name = "Hard_Skill")
public class SoftSkillModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sectionTitle;
    private int personDni;

    public SoftSkillModel() {
    }

    public SoftSkillModel(int id, String sectionTitle, int personDni) {
        this.id = id;
        this.sectionTitle = sectionTitle;
        this.personDni = personDni;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "sectionTitle":
                this.sectionTitle = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

    
    
}
