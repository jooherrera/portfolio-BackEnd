package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonModel;

import com.joseherrera.Backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IService<PersonModel> {

    @Autowired
    PersonRepository personRepo;

    @Override
    public PersonModel get(int authId) {
        return personRepo.findByAuthId(authId).orElse(null);
    }

    @Override
    public void update(PersonModel person) {
        personRepo.save(person);
    }

}
