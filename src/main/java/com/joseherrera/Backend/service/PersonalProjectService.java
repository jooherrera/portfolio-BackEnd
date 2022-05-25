package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.PersonalProjectModel;
import com.joseherrera.Backend.repository.PersonalProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonalProjectService extends BaseService<PersonalProjectModel, PersonalProjectRepository> {

    @Override
    public PersonalProjectModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }

}
