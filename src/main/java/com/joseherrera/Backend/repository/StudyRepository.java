package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.StudyModel;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends BaseRepository<StudyModel> {

    Optional<StudyModel> findByPersonDni(int dni);

}
