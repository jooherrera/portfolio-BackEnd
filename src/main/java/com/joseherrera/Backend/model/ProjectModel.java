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
@Table(name = "Project")
public class ProjectModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name = "Project name";
    private String description = "Description";
    private String githubLink = "Github Link";
    private String webLink = "Web link";
    private int sectionId;

    public ProjectModel() {
    }

    public ProjectModel(int id, String name, String description, String githubLink, String webLink, int sectionId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.githubLink = githubLink;
        this.webLink = webLink;
        this.sectionId = sectionId;
    }

}
