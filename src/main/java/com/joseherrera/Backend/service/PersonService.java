package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<PersonModel, PersonRepository> {

    @Override
    public PersonModel getByPrincipalKey(int dni) {
        return repo.findByDni(dni).orElse(null);
    }

    @Override
    public PersonModel getOneByForeignKeyId(int fkId) {
        return repo.findByAuthId(fkId).orElse(null);
    }

}
