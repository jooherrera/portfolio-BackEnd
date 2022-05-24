package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements IService<ContactModel> {

    @Autowired
    ContactRepository contactRepo;

    @Override
    public ContactModel getByPrincipalKey(int id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public void update(ContactModel contact) {
        contactRepo.save(contact);
    }

    @Override
    public List<ContactModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ContactModel getOneByForeignKeyId(int fkId) {
        return contactRepo.findByPersonDni(fkId).orElse(null);
    }

    @Override
    public void add(int personDni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
