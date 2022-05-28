package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.repository.PersonRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IService<PersonModel> {

    @Autowired
    PersonRepository repo;

    @Override
    public PersonModel getOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PersonModel addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PersonModel getOne() {
        return repo.findAll().get(0);
    }

    @Override
    public PersonModel add() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "fullName" -> repo.updateFullName(id, field.get(key).toString());
                case "title" -> repo.updateTitle(id, field.get(key).toString());
                case "profileImg" -> repo.updateProfileImg(id, field.get(key).toString());
                case "bannerImg" -> repo.updateBannerImg(id, field.get(key).toString());
                default -> throw new AssertionError("No existe la key en el modelo");
            }
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PersonModel> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
