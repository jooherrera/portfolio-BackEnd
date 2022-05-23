package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.HardSkillModel;
import com.joseherrera.Backend.repository.HardSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService implements IService<HardSkillModel> {

    @Autowired
    HardSkillRepository hardSkillRepo;

    @Override
    public HardSkillModel get(int dni) {
        return hardSkillRepo.findByPersonDni(dni);
    }

    @Override
    public void update(HardSkillModel model) {
        hardSkillRepo.save(model);
    }
}
