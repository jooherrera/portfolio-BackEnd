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
@Table(name = "Subject")
public class SubjectModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title = "Nombre del curso";
    private String date = "Fecha de finalización";
    private String certificate = "Link del certificado";
    private int schoolId;

    public SubjectModel() {
    }

    public SubjectModel(int id, String title, String date, String certificate, int schoolId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.certificate = certificate;
        this.schoolId = schoolId;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "title":
                this.title = value.toString();
                break;
            case "date":
                this.date = value.toString();
                break;
            case "certificate":
                this.certificate = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

}
