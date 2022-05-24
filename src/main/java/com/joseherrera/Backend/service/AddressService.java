package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.AddressModel;
import com.joseherrera.Backend.repository.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IService<AddressModel> {

    @Autowired
    AddressRepository repository;

    @Override
    public AddressModel getByPrincipalKey(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(AddressModel model) {
        repository.save(model);
    }

    @Override
    public List<AddressModel> getAllByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AddressModel getOneByForeignKeyId(int fkId) {
        return repository.findByPersonDni(fkId).orElse(null);
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
