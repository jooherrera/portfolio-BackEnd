
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
@Table(name = "Skill")
public class SkillModel implements Serializable, IModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name; 
    private int porcent;
    private int softSkillId;

    public SkillModel() {
    }

    public SkillModel(int id, String name, int porcent, int softSkillId) {
        this.id = id;
        this.name = name;
        this.porcent = porcent;
        this.softSkillId = softSkillId;
    }

    @Override
    public void updateAttribute(String key, Object value) {
         switch (key) {
            case "name":
                this.name = value.toString();
                break;
            case "porcent":
                this.porcent = Integer.parseInt(value.toString());
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }
    
    
    
    
}
