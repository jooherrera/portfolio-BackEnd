
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.SubjectModel;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends BaseRepository<SubjectModel>{
    Optional<List<SubjectModel>> findBySchoolId(int schoolId);
    
}