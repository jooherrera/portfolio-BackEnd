package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.StudyModel;
import com.joseherrera.Backend.repository.StudyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService implements IService<StudyModel> {

    @Autowired
    StudyRepository studyRepo;

    @Override
    public StudyModel getByPrincipalKey(int id) {
        return studyRepo.findById(id).orElse(null);
    }

    @Override
    public void update(StudyModel model) {
        studyRepo.save(model);
    }

    @Override
    public StudyModel getOneByForeignKeyId(int fkId) {
        return studyRepo.findByPersonDni(fkId).orElse(null);

    }

    @Override
    public List<StudyModel> getAllByForeignKeyId(int fkId) {
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
