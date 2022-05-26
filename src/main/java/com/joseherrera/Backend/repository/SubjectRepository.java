package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.SubjectModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Integer> {

    List<SubjectModel> findBySchoolId(int schoolId);

    @Modifying
    @Query(value = "UPDATE Subject SET title = :value WHERE id = :id", nativeQuery = true)
    void updateTitle(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Subject SET date = :value WHERE id = :id", nativeQuery = true)
    void updateDate(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Subject SET certificate = :value WHERE id = :id", nativeQuery = true)
    void updateCertificate(@Param("id") int id, @Param("value") String value);

}
