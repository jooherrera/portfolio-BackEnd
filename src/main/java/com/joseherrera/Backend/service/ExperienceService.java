package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ExperienceModel;
import com.joseherrera.Backend.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IService<ExperienceModel> {

    @Autowired
    ExperienceRepository experienceRepo;

    @Override
    public ExperienceModel get(int dni) {
        return experienceRepo.findByPersonDni(dni);
    }

    @Override
    public void update(ExperienceModel model) {
       experienceRepo.save(model);
    }

}
