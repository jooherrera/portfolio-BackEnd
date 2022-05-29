package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.dto.SubjectItemDto;
import com.joseherrera.Backend.model.Subject;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    List<Subject> findBySchoolId(int schoolId);

    @Transactional
    @Modifying
    @Query(value = "SELECT new com.joseherrera.Backend.dto.SubjectItemDto(s.id,s.title,s.date,s.certificate) FROM SubjectModel s WHERE schoolId = :id ")
    List<SubjectItemDto> getAllBySchoolId(@Param("id") int id);
    
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Subject SET title = :value WHERE id = :id", nativeQuery = true)
    void updateTitle(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Subject SET date = :value WHERE id = :id", nativeQuery = true)
    void updateDate(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Subject SET certificate = :value WHERE id = :id", nativeQuery = true)
    void updateCertificate(@Param("id") int id, @Param("value") String value);

}
