package com.joseherrera.Backend.service;

import com.joseherrera.Backend.model.ProjectModel;
import com.joseherrera.Backend.repository.ProjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectService extends BaseService<ProjectModel, ProjectRepository> {

    @Override
    public List<ProjectModel> getAllByForeignKeyId(int fkId) {
        return repo.findByPersonalProjectId(fkId).orElse(null);
    }

    @Override
    public void add(int personalProjectId) {
        ProjectModel newProject = new ProjectModel();
        newProject.setPersonalProjectId(personalProjectId);
        repo.save(newProject);
    }

}
