package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.CursoModel;
import com.joseherrera.Backend.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService extends BaseService<CursoModel, CursoRepository> {

    @Override
    public CursoModel getOneByForeignKeyId(int fkId) {
        return repo.findByPersonDni(fkId).orElse(null);
    }
}
