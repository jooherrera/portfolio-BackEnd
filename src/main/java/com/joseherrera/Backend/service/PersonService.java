package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IPersonService;
import com.joseherrera.Backend.model.PersonModel;

import com.joseherrera.Backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {

    @Autowired
    PersonRepository personRepo;

    @Override
    public PersonModel getPerson(int authId) {
        return personRepo.findByAuthId(authId).orElse(null);
    }

    @Override
    public void updatePerson(PersonModel person) {
        personRepo.save(person);
    }

}
