package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.CursoModel;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends BaseRepository<CursoModel> {

    Optional<CursoModel> findByPersonDni(int dni);
}
