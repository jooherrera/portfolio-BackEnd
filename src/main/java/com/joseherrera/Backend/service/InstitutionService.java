
package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.InstitutionModel;
import com.joseherrera.Backend.repository.InstitutionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService implements IService<InstitutionModel>{
    @Autowired
    InstitutionRepository institutionRepo;

    @Override
    public InstitutionModel getByPrincipalKey(int id) {
        return institutionRepo.findById(id).orElse(null);
    }

    @Override
    public void update(InstitutionModel model) {
        institutionRepo.save(model);
    }

    @Override
    public InstitutionModel getOneByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<InstitutionModel> getAllByForeignKeyId(int fkId) {
       return institutionRepo.findByStudyId(fkId).orElse(null);
    }

    @Override
    public void add(int studyId) {
        InstitutionModel newInstitution = new InstitutionModel();
        newInstitution.setStudyId(studyId);
        institutionRepo.save(newInstitution);
    }

    @Override
    public void delete(int id) {
        institutionRepo.deleteById(id);
    }
    
    
}
