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
@Table(name = "Subject")
public class SubjectModel implements Serializable{

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


}
