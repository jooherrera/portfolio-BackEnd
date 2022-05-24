package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SoftSkillModel;
import com.joseherrera.Backend.repository.SoftSkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftSkillService implements IService<SoftSkillModel> {

    @Autowired
    SoftSkillRepository softRepo;

    @Override
    public SoftSkillModel getByPrincipalKey(int id) {
        return softRepo.findById(id).orElse(null);
    }

    @Override
    public void update(SoftSkillModel model) {
        softRepo.save(model);
    }

    @Override
    public SoftSkillModel getOneByForeignKeyId(int fkId) {
        return softRepo.findByPersonDni(fkId).orElse(null);
    }

    @Override
    public List<SoftSkillModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
