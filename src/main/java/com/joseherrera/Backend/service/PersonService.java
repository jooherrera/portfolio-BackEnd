package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonModel;

import com.joseherrera.Backend.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IService<PersonModel> {

    @Autowired
    PersonRepository personRepo;

    @Override
    public PersonModel getByPrincipalKey(int dni) {
        return personRepo.findByDni(dni).orElse(null);
    }

    @Override
    public void update(PersonModel person) {
        personRepo.save(person);
    }

    @Override
    public List<PersonModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PersonModel getOneByForeignKeyId(int fkId) {
        return personRepo.findByAuthId(fkId).orElse(null);
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
