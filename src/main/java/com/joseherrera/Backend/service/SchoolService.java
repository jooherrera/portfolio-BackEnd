package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SchoolModel;
import com.joseherrera.Backend.repository.SchoolRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService  implements IService<SchoolModel> {

    @Autowired
    SchoolRepository repo;

    @Override
    public SchoolModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SchoolModel add() {
        return repo.save(new SchoolModel());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
         for (String key : field.keySet()) {
            switch (key) {
                case "company" -> repo.updateCompany(id, field.get(key).toString());
                case "logo" -> repo.updateLogo(id, field.get(key).toString());    
                default -> throw new AssertionError();
            }
        }
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<SchoolModel> getAll() {
        return repo.findAll();
    }


}
