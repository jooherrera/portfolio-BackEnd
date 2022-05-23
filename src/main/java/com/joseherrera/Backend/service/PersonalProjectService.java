package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonalProjectModel;
import com.joseherrera.Backend.repository.PersonalProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalProjectService implements IService<PersonalProjectModel> {

    @Autowired
    PersonalProjectRepository ppRepo;

    @Override
    public PersonalProjectModel get(int dni) {
        return ppRepo.findByPersonDni(dni);
    }

    @Override
    public void update(PersonalProjectModel model) {
        ppRepo.save(model);
    }
}
