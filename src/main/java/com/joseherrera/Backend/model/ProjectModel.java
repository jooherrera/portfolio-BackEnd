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
@Table(name = "Project")
public class ProjectModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name = "Project name";
    private String description = "Description";
    private String github = "Github Link";
    private String link = "Web link";
    private int personalProjectId;

    public ProjectModel() {
    }

    public ProjectModel(int id, String name, String description, String github, String link, int personalProjectId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.github = github;
        this.link = link;
        this.personalProjectId = personalProjectId;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "name":
                this.name = value.toString();
                break;
            case "description":
                this.description = value.toString();
                break;
            case "github":
                this.github = value.toString();
                break;
            case "link":
                this.link = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

}
