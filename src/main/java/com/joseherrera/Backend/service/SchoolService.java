package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.SchoolModel;
import com.joseherrera.Backend.repository.SchoolRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SchoolService extends BaseService<SchoolModel, SchoolRepository> {

    @Override
    public List<SchoolModel> getAllByForeignKeyId(int fkId) {
        return repo.findByCursoId(fkId).orElse(null);
    }

    @Override
    public void add(int foreignKeyId) {
        SchoolModel newModel = new SchoolModel();
        newModel.setCursoId(foreignKeyId);
        repo.save(newModel);
    }
}
