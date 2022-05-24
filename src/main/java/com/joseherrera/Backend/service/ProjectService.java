
package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ProjectModel;
import com.joseherrera.Backend.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProjectService implements IService<ProjectModel>{
    @Autowired
    ProjectRepository projectRepo;

    @Override
    public ProjectModel getByPrincipalKey(int id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public void update(ProjectModel model) {
        projectRepo.save(model);
    }

    @Override
    public ProjectModel getOneByForeignKeyId(int fkId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProjectModel> getAllByForeignKeyId(int fkId) {
        return projectRepo.findByPersonalProjectId(fkId).orElse(null);
    }

    @Override
    public void add(int personalProjectId) {
        ProjectModel newProject = new ProjectModel();
        newProject.setPersonalProjectId(personalProjectId);
        projectRepo.save(newProject);
    }

    @Override
    public void delete(int id) {
        projectRepo.deleteById(id);
    }
    
    
}
