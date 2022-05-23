package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService  implements IService<ContactModel>{

    @Autowired
    ContactRepository contactRepo;
    
    @Override
    public ContactModel get(int dni) {
        return contactRepo.findByPersonDni(dni);
    }

    @Override
    public void update(ContactModel contact) {
        contactRepo.save(contact);
    }
}
