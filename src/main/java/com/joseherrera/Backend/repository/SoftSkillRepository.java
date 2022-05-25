package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.SoftSkillModel;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends BaseRepository<SoftSkillModel> {

    Optional<SoftSkillModel> findByPersonDni(int dni);

}
