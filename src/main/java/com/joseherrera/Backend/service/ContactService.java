package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IContactService;
import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService  implements IContactService{

    @Autowired
    ContactRepository contactRepo;
    
    @Override
    public ContactModel getContact(int dni) {
        return contactRepo.findByPersonDni(dni).orElse(null);
    }

    @Override
    public void updateContact(ContactModel contact) {
        contactRepo.save(contact);
    }
}
