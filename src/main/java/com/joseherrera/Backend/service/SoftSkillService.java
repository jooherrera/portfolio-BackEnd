package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SoftSkillModel;
import com.joseherrera.Backend.repository.SoftSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService implements IService<SoftSkillModel> {

    @Autowired
    SoftSkillRepository softRepo;

    @Override
    public SoftSkillModel get(int dni) {
        return softRepo.findByPersonDni(dni);
    }

    @Override
    public void update(SoftSkillModel model) {
        softRepo.save(model);
    }
}
