package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.ExperienceModel;
import com.joseherrera.Backend.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService extends BaseService<ExperienceModel, ExperienceRepository> {

    @Override
    public ExperienceModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }

}
