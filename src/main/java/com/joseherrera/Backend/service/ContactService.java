package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends BaseService<ContactModel, ContactRepository> {

    @Override
    public ContactModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }

}
