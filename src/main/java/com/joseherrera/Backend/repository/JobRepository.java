
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.JobModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Integer> {
    Optional<List<JobModel>> findByExperienceId(int experienceId);
}
