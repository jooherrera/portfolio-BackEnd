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
@Table(name = "School")
public class SchoolModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company = "Company";
    @Lob
    private String logo = "i.ibb.co/WHDLsLN/default-Logo.png";
    private int cursoId;

    public SchoolModel() {
    }

    public SchoolModel(int id, String company, String logo, int cursoId) {
        this.id = id;
        this.company = company;
        this.logo = logo;
        this.cursoId = cursoId;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "company":
                this.company = value.toString();
                break;
            case "logo":
                this.logo = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

}
