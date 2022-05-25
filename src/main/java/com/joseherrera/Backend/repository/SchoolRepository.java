package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.SchoolModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends BaseRepository<SchoolModel> {

    Optional<List<SchoolModel>> findByCursoId(int cursoId);

}
