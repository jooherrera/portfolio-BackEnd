package com.joseherrera.Backend.model;

import com.joseherrera.Backend.interfaces.IModel;
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
public class TechnologyModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String logo = "i.ibb.co/WHDLsLN/default-Logo.png";
    private String name = "name";
    private int hardSkillId;

    public TechnologyModel() {
    }

    public TechnologyModel(int id, String logo, String name, int hardSkillId) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.hardSkillId = hardSkillId;
    }

    @Override
    public void updateAttribute(String key, Object value) {
       switch (key) {
            case "logo":
                this.logo = value.toString();
                break;
            case "name":
                this.name = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }


    
    

}
