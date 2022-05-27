package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ProjectModel;
import com.joseherrera.Backend.repository.ProjectRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IService<ProjectModel> {

    @Autowired
    ProjectRepository repo;

    @Override
    public ProjectModel getOneById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProjectModel getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProjectModel add() {
        return repo.save(new ProjectModel());
    }

    @Override
    public void update(int id, Map<String, Object> field) {
        for (String key : field.keySet()) {
            switch (key) {
                case "name" ->
                    repo.updateName(id, field.get(key).toString());
                case "description" ->
                    repo.updateDescription(id, field.get(key).toString());
                case "webLink" ->
                    repo.updateWebLink(id, field.get(key).toString());
                case "githubLink" ->
                    repo.updateGithubLink(id, field.get(key).toString());
                default ->
                    throw new AssertionError();
            }
        }
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<ProjectModel> getAll() {
        return repo.findAll();
    }

}
