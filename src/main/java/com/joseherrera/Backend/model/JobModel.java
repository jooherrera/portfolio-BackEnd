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
@Table(name = "Job")
public class JobModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    private String logo = "i.ibb.co/WHDLsLN/default-Logo.png";
    private String title = "title";
    private String company = "company name";
    private String date = "date";
    private String extra;
    private int experienceId;

    public JobModel() {
    }

    public JobModel(int id, String logo, String title, String company, String date, String extra, int experienceId) {
        this.id = id;
        this.logo = logo;
        this.title = title;
        this.company = company;
        this.date = date;
        this.extra = extra;
        this.experienceId = experienceId;
    }

    @Override
    public String toString() {
        return "JobModel{" + "id=" + id + ", logo=" + logo + ", title=" + title + ", company=" + company + ", date=" + date + ", extra=" + extra + ", experienceId=" + experienceId + '}';
    }

    
    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "logo":
                this.logo = value.toString();
                break;
            case "title":
                this.title = value.toString();
                break;
            case "company":
                this.company = value.toString();
                break;
            case "date":
                this.date = value.toString();
                break;
            case "extra":
                this.extra = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

    
    
}
