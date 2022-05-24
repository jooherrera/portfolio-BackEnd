package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ExperienceModel;
import com.joseherrera.Backend.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IService<ExperienceModel> {

    @Autowired
    ExperienceRepository experienceRepo;

    @Override
    public ExperienceModel getByPrincipalKey(int id) {
        return experienceRepo.findById(id).orElse(null);
    }

    @Override
    public void update(ExperienceModel model) {
        experienceRepo.save(model);
    }

    @Override
    public List<ExperienceModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ExperienceModel getOneByForeignKeyId(int fkId) {
        return experienceRepo.findByPersonDni(fkId).orElse(null);
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
