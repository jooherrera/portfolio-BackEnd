package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.HardSkillModel;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HardSkillRepository extends BaseRepository<HardSkillModel> {

    Optional<HardSkillModel> findByPersonDni(int dni);

}
