package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.ProjectModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends BaseRepository<ProjectModel>{
        Optional<List<ProjectModel>> findByPersonalProjectId(int personalProjectId);

}
