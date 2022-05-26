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
@Table(name = "Contact")
public class ContactModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String phone;
    private String linkedin;
    private String address;

    public ContactModel() {
    }

    public ContactModel(int id, String email, String phone, String linkedin, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.linkedin = linkedin;
        this.address = address;
    }

}
