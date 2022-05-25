package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.AddressModel;
import com.joseherrera.Backend.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressModel, AddressRepository> {

    @Override
    public AddressModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }

}
