
package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.AboutModel;
import com.joseherrera.Backend.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements IService<AboutModel>{
    @Autowired
    AboutRepository aboutRepo;

    @Override
    public AboutModel get(int dni) {
        return aboutRepo.findByPersonDni(dni);
    }

    @Override
    public void update(AboutModel model) {
        aboutRepo.save(model);
    }
    
    
}
