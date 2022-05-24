package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonalProjectModel;
import com.joseherrera.Backend.repository.PersonalProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalProjectService implements IService<PersonalProjectModel> {

    @Autowired
    PersonalProjectRepository ppRepo;

    @Override
    public PersonalProjectModel getByPrincipalKey(int id) {
        return ppRepo.findById(id).orElse(null);
    }

    @Override
    public void update(PersonalProjectModel model) {
        ppRepo.save(model);
    }

    @Override
    public PersonalProjectModel getOneByForeignKeyId(int fkId) {
        return ppRepo.findByPersonDni(fkId).orElse(null);
    }

    @Override
    public List<PersonalProjectModel> getAllByForeignKeyId(int fkId) {
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
