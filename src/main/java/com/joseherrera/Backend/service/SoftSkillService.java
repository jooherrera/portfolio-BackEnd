package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.SoftSkillModel;
import com.joseherrera.Backend.repository.SoftSkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService extends BaseService<SoftSkillModel, SoftSkillRepository> {

    @Override
    public SoftSkillModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }

}
