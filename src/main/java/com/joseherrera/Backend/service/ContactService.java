package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.repository.ContactRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements IService<ContactModel> {

    @Autowired
    ContactRepository repo;

    @Override
    public ContactModel getOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ContactModel addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    public ContactModel getOne() {
        return repo.findAll().get(0);
    }

    @Override
    public ContactModel add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Map<String, Object> field) {

        for (String key : field.keySet()) {
            switch (key) {
                case "email" -> repo.updateEmail(id, field.get(key).toString());
                case "phone" -> repo.updatePhone(id, field.get(key).toString());
                case "linkedin" -> repo.updateLinkedin(id, field.get(key).toString());
                case "address" -> repo.updateAddress(id, field.get(key).toString());
                default -> throw new AssertionError("No existe la key en el modelo");
            }
        }

    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ContactModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
