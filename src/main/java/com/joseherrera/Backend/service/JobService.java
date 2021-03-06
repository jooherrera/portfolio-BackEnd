package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.Job;
import com.joseherrera.Backend.repository.JobRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements IService<Job> {

    @Autowired
    JobRepository repo;
    
    @Override
    public Job getOneById(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public Job addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Job getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Job add() {
        return repo.save(new Job());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "logo" -> repo.updateLogo(id, field.get(key).toString());
                case "name" -> repo.updateName(id, field.get(key).toString());
                case "company" -> repo.updateCompany(id, field.get(key).toString());
                case "date" -> repo.updateDate(id, field.get(key).toString());
                case "extra" -> repo.updateExtra(id, field.get(key).toString());
                default -> throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Job> getAll() {
        return repo.findAll();
    }

}
