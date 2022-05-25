package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.PersonalProjectModel;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonalProjectRepository extends BaseRepository<PersonalProjectModel> {

    Optional<PersonalProjectModel> findByPersonDni(int dni);
}
