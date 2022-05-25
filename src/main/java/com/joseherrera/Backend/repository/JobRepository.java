
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.JobModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends BaseRepository<JobModel>{
    Optional<List<JobModel>> findByExperienceId(int experienceId);
}
