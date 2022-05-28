package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.InstitutionModel;
import com.joseherrera.Backend.repository.InstitutionRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService implements IService<InstitutionModel> {

    @Autowired
    InstitutionRepository repo;

    @Override
    public InstitutionModel getOneById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public InstitutionModel addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    @Override
    public InstitutionModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public InstitutionModel add() {
        return repo.save(new InstitutionModel());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "date" ->
                    repo.updateDate(id, field.get(key).toString());
                case "extra" ->
                    repo.updateExtra(id, field.get(key).toString());
                case "title" ->
                    repo.updateTitle(id, field.get(key).toString());
                case "logo" ->
                    repo.updateLogo(id, field.get(key).toString());
                case "name" ->
                    repo.updateName(id, field.get(key).toString());
                default ->
                    throw new AssertionError("No existe la key en el modelo");
            }
        }
        ;
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<InstitutionModel> getAll() {
        return repo.findAll();
    }

}
