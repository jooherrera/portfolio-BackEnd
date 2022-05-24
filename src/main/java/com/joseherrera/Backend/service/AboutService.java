package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.AboutModel;
import com.joseherrera.Backend.repository.AboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements IService<AboutModel> {

    @Autowired
    AboutRepository aboutRepo;

    @Override
    public AboutModel getByPrincipalKey(int id) {
        return aboutRepo.findById(id).orElse(null);
    }

    @Override
    public void update(AboutModel model) {
        aboutRepo.save(model);
    }

    @Override
    public List<AboutModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AboutModel getOneByForeignKeyId(int fkId) {
        return aboutRepo.findByPersonDni(fkId).orElse(null);
    }

    @Override
    public void add(int personDni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
