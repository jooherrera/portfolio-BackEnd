package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.SkillModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends BaseRepository<SkillModel> {

    Optional<List<SkillModel>> findBySoftSkillId(int softSkillId);
}
