
package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.StudyModel;
import com.joseherrera.Backend.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyService implements IService<StudyModel>{
    @Autowired
    StudyRepository studyRepo;

    @Override
    public StudyModel get(int id) {
        return studyRepo.findByPersonDni(id);
    }

    @Override
    public void update(StudyModel model) {
        studyRepo.save(model);
    }
    
}
