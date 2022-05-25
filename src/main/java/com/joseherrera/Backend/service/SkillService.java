package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.SkillModel;
import com.joseherrera.Backend.repository.SkillRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SkillService extends BaseService<SkillModel, SkillRepository> {

    @Override
    public List<SkillModel> getAllByForeignKeyId(int fkId) {
        return repo.findBySoftSkillId(fkId).orElse(null);
    }

        @Override
    public void add(int foreignKeyId) {
        SkillModel newModel = new SkillModel();
        newModel.setSoftSkillId(foreignKeyId);
        repo.save(newModel);
    }
}
