package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.AddressModel;
import com.joseherrera.Backend.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IService<AddressModel>{

    @Autowired
    AddressRepository repository;
    
    
    @Override
    public AddressModel get(int dni) {
       return repository.findByPersonDni(dni);
    }

    @Override
    public void update(AddressModel model) {
        repository.save(model);
    }

}
