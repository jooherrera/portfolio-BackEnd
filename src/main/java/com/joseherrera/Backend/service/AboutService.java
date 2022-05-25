package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.AboutModel;
import com.joseherrera.Backend.repository.AboutRepository;
import org.springframework.stereotype.Service;

@Service
public class AboutService extends BaseService<AboutModel, AboutRepository> {

    @Override
    public AboutModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }

}
