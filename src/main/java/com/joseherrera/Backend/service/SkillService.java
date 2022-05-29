package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.Skill;
import com.joseherrera.Backend.repository.SkillRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements IService<Skill> {

    @Autowired
    SkillRepository repo;

    @Override
    public Skill getOneById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Skill getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Skill add() {
        return repo.save(new Skill());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "name" ->
                    repo.updateName(id, field.get(key).toString());
                case "porcent" ->
                    repo.updatePorcent(id, field.get(key).toString());
                default ->
                    throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public Skill addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Skill> getAll() {
        return repo.findAll();
    }

}
