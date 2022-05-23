
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
@Table(name = "Address")
public class AddressModel implements Serializable, IModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String address;
    private int personDni;

    public AddressModel() {
    }

    public AddressModel(int id, String address, int personDni) {
        this.id = id;
        this.address = address;
        this.personDni = personDni;
    }

    @Override
    public void updateAttribute(String key, Object value) {
        switch (key) {
            case "address":
                this.address = value.toString();
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
}
