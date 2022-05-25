package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.ExperienceModel;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends BaseRepository<ExperienceModel> {

    Optional<ExperienceModel> findByPersonDni(int dni);

}
