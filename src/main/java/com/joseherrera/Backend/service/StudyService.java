package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.StudyModel;
import com.joseherrera.Backend.repository.StudyRepository;
import org.springframework.stereotype.Service;

@Service
public class StudyService extends BaseService<StudyModel, StudyRepository> {

    @Override
    public StudyModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);

    }

}
