package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.TechnologyModel;
import com.joseherrera.Backend.repository.TechnologyRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService implements IService<TechnologyModel> {

    @Autowired
    TechnologyRepository repo;

     public TechnologyModel getOneById(int id) {
        return repo.findById(id).orElse(null);
    }
    
    @Override
    public TechnologyModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TechnologyModel add() {
       return repo.save(new TechnologyModel());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "logo" -> repo.updateLogo(id, field.get(key).toString());
                case "name" -> repo.updateName(id, field.get(key).toString());
                default -> throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<TechnologyModel> getAll() {
        return repo.findAll();
    }



}
