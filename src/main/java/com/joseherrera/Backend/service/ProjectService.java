package com.joseherrera.Backend.service;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.Project;
import com.joseherrera.Backend.repository.ProjectRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IService<Project> {

    @Autowired
    ProjectRepository repo;

    @Override
    public Project getOneById(int id) {
         return repo.findById(id).orElse(null);
    }

    @Override
    public Project getOne() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Project add() {
        return repo.save(new Project());
    }

    @Override
    public Project addWithId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public List<Project> getAll() {
        return repo.findAll();
    }

}
