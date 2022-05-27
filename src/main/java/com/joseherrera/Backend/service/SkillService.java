package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SkillModel;
import com.joseherrera.Backend.repository.SkillRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements IService<SkillModel> {

    @Autowired
    SkillRepository repo;

    @Override
    public SkillModel getOneById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public SkillModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SkillModel add() {
        return repo.save(new SkillModel());
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
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<SkillModel> getAll() {
        return repo.findAll();
    }

}
