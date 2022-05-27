package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.InstitutionModel;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<InstitutionModel, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Institution SET date = :value WHERE id = :id", nativeQuery = true)
    void updateDate(@Param("id") int id, @Param("value") String value);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Institution SET extra = :value WHERE id = :id", nativeQuery = true)
    void updateExtra(@Param("id") int id, @Param("value") String value);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Institution SET title = :value WHERE id = :id", nativeQuery = true)
    void updateTitle(@Param("id") int id, @Param("value") String value);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Institution SET logo = :value WHERE id = :id", nativeQuery = true)
    void updateLogo(@Param("id") int id, @Param("value") String value);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Institution SET name = :value WHERE id = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);
}
