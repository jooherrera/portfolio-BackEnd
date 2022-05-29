package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.School;
import com.joseherrera.Backend.repository.SchoolRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService implements IService<School> {

    @Autowired
    SchoolRepository repo;

    @Override
    public School getOneById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public School getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public School add() {
        return repo.save(new School());
    }

    @Override
    public School addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "company" ->
                    repo.updateCompany(id, field.get(key).toString());
                case "logo" ->
                    repo.updateLogo(id, field.get(key).toString());
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
    public List<School> getAll() {
        return repo.findAll();
    }

}
