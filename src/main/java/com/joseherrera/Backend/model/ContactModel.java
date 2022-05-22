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
@Table(name = "Contact")
public class ContactModel implements Serializable, IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String phone;
    private String linkedin;
    private int personDni;

    public ContactModel() {
    }

    public ContactModel(int id, String email, String phone, String linkedin, int personDni) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.linkedin = linkedin;
        this.personDni = personDni;
    }

    @Override
    public String toString() {
        return "ContactModel{" + "id=" + id + ", email=" + email + ", phone=" + phone + ", linkedin=" + linkedin + ", personDni=" + personDni + '}';
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "email":
                this.email = value.toString();
                break;
            case "phone":
                this.phone = value.toString();
                break;
            case "linkedin":
                this.linkedin = value.toString();
                break;
            default:
                throw new AssertionError("No existe esa key en el modelo");
        }
    }

}
