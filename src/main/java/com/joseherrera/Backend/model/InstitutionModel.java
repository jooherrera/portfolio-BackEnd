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
@Table(name = "Institution")
public class InstitutionModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date = "date";
    private String extra = "";
    private String title = "title";
    @Lob
    private String logo = "i.ibb.co/WHDLsLN/default-Logo.png";
    private String name = "name";
    private int studyId;

    public InstitutionModel() {
    }

    public InstitutionModel(int id, String date, String extra, String title, String logo, String name, int studyId) {
        this.id = id;
        this.date = date;
        this.extra = extra;
        this.title = title;
        this.logo = logo;
        this.name = name;
        this.studyId = studyId;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "date":
                this.date = value.toString();
                break;
            case "extra":
                this.extra = value.toString();
                break;
            case "title":
                this.title = value.toString();
                break;
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
