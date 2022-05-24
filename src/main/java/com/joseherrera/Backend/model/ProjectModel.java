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
    private String githubLink = "Github Link";
    private String webLink = "Web link";
    private int personalProjectId;

    public ProjectModel() {
    }

    public ProjectModel(int id,String name, String description, String githubLink,String webLink, int personalProjectId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.githubLink = githubLink;
        this.webLink = webLink;
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
            case "githubLink":
               this.githubLink = value.toString();
                break;
            case "webLink":
                this.webLink = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

}
