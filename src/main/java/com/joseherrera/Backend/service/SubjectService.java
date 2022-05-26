package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SubjectModel;
import com.joseherrera.Backend.repository.SubjectRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService implements IService<SubjectModel> {

    @Autowired
    SubjectRepository repo;

    @Override
    public SubjectModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SubjectModel add() {
        return repo.save(new SubjectModel());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
         for (String key : field.keySet()) {
            switch (key) {
                case "title" -> repo.updateTitle(id, field.get(key).toString());
                case "date" -> repo.updateDate(id, field.get(key).toString());
                case "certificate" -> repo.updateCertificate(id, field.get(key).toString());
                default -> throw new AssertionError();
            }
        }
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<SubjectModel> getAll() {
        return repo.findAll();
    }
    
    public List<SubjectModel> getAllBySchoolId(int schoolId){
        return repo.findBySchoolId(schoolId);
    }

    
}
