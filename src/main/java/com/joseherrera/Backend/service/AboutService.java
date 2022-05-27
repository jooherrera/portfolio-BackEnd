package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.AboutModel;
import com.joseherrera.Backend.repository.AboutRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements IService<AboutModel> {

    @Autowired
    AboutRepository repo;

    @Override
    public AboutModel getOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public AboutModel getOne() {
        return repo.findAll().get(0);
    }

    @Override
    public void update(int id, Map<String, Object> field) {

        for (String key : field.keySet()) {
            switch (key) {
                case "paragraph" -> repo.updateParagraph(id, field.get(key).toString());
                default -> throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public AboutModel add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AboutModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
