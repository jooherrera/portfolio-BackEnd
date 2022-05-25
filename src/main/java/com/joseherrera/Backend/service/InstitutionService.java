package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.InstitutionModel;
import com.joseherrera.Backend.repository.InstitutionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService extends BaseService<InstitutionModel, InstitutionRepository> {

    @Override
    public List<InstitutionModel> getAllByForeignKeyId(int fkId) {
        return repo.findByStudyId(fkId).orElse(null);
    }

    @Override
    public void add(int studyId) {
        InstitutionModel newInstitution = new InstitutionModel();
        newInstitution.setStudyId(studyId);
        repo.save(newInstitution);
    }

}
