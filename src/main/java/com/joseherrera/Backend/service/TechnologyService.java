package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.TechnologyModel;
import com.joseherrera.Backend.repository.TechnologyRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService extends BaseService<TechnologyModel, TechnologyRepository> {

    @Override
    public List<TechnologyModel> getAllByForeignKeyId(int fkId) {
        return repo.findByHardSkillId(fkId).orElse(null);
    }

    @Override
    public void add(int foreignKeyId) {
        TechnologyModel newModel = new TechnologyModel();
        newModel.setHardSkillId(foreignKeyId);
        repo.save(newModel);
    }

}
