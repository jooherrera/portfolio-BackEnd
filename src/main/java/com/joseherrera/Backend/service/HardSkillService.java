package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.HardSkillModel;
import com.joseherrera.Backend.repository.HardSkillRepository;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService extends BaseService<HardSkillModel, HardSkillRepository> {

    @Override
    public HardSkillModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);

    }

}
