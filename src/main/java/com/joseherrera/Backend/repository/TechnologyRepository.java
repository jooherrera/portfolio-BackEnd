package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.TechnologyModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends BaseRepository<TechnologyModel>{
    Optional<List<TechnologyModel>> findByHardSkillId(int hardSkillId);
    
}
