package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.HardSkillModel;
import com.joseherrera.Backend.repository.HardSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HardSkillService implements IService<HardSkillModel> {

    @Autowired
    HardSkillRepository hardSkillRepo;

    @Override
    public HardSkillModel getByPrincipalKey(int id) {
        return hardSkillRepo.findById(id).orElse(null);
    }

    @Override
    public void update(HardSkillModel model) {
        hardSkillRepo.save(model);
    }

    @Override
    public List<HardSkillModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HardSkillModel getOneByForeignKeyId(int fkId) {
        return hardSkillRepo.findByPersonDni(fkId).orElse(null);

    }

    @Override
    public void add(int personDni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
