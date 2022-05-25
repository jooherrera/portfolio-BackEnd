package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.SubjectModel;
import com.joseherrera.Backend.repository.SubjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends BaseService<SubjectModel, SubjectRepository> {

    @Override
    public List<SubjectModel> getAllByForeignKeyId(int fkId) {
        return repo.findBySchoolId(fkId).orElse(null);
    }

    @Override
    public void add(int foreignKeyId) {
        SubjectModel newModel = new SubjectModel();
        newModel.setSchoolId(foreignKeyId);
        repo.save(newModel);
    }
}
