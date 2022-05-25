
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.InstitutionModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends BaseRepository<InstitutionModel> {
    Optional<List<InstitutionModel>> findByStudyId(int studyId);
}
