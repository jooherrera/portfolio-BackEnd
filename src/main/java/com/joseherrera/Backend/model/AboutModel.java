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
@Table(name = "About")
public class AboutModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sectionTitle;
    private String about;
    private int personDni;

    public AboutModel() {
    }

    public AboutModel(int id, String sectionTitle, String about, int personDni) {
        this.id = id;
        this.sectionTitle = sectionTitle;
        this.about = about;
        this.personDni = personDni;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "sectionTitle":
                this.sectionTitle = value.toString();
                break;
            case "about":
                this.about = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }
    
    
    
            
}
