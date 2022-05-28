package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SectionTitleModel;
import com.joseherrera.Backend.repository.SectionRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService implements IService<SectionTitleModel> {

    @Autowired
    SectionRepository repo;
    
    public SectionTitleModel getOneById(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public SectionTitleModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SectionTitleModel add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Map<String, Object> field) {
         for (String key : field.keySet()) {
            switch (key) {
                case "sectionTitle" -> repo.updateSectionTitle(id, field.get(key).toString());
                case "visible" -> repo.updateVisible(id, Boolean.parseBoolean(field.get(key).toString()));
                default -> throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public SectionTitleModel addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SectionTitleModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
