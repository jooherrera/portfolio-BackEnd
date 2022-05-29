package com.joseherrera.Backend.service;

import com.joseherrera.Backend.dto.SubjectItemDto;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.Subject;
import com.joseherrera.Backend.repository.SubjectRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService implements IService<Subject> {

    @Autowired
    SubjectRepository repo;

    @Override
    public Subject addWithId(int schoolId) {
        Subject newModel = new Subject();
        newModel.setSchoolId(schoolId);
        return repo.save(newModel);
        
    }

    @Override
    public Subject getOneById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Subject getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subject add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "title" ->
                    repo.updateTitle(id, field.get(key).toString());
                case "date" ->
                    repo.updateDate(id, field.get(key).toString());
                case "certificate" ->
                    repo.updateCertificate(id, field.get(key).toString());
                default ->
                    throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Subject> getAll() {
        return repo.findAll();
    }

    public List<SubjectItemDto> getAllBySchoolId(int schoolId) {
        return repo.getAllBySchoolId(schoolId);

    }

}
