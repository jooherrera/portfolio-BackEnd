package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Integer> {

    //@Transactional
    @Modifying
    @Query(value = "UPDATE Job SET logo = :value WHERE id = :id", nativeQuery = true)
    void updateLogo(@Param("id") int id, @Param("value") String value);
    //@Transactional

    @Modifying
    @Query(value = "UPDATE Job SET name = :value WHERE id = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);
    //@Transactional

    @Modifying
    @Query(value = "UPDATE Job SET company = :value WHERE id = :id", nativeQuery = true)
    void updateCompany(@Param("id") int id, @Param("value") String value);
    //@Transactional

    @Modifying
    @Query(value = "UPDATE Job SET date = :value WHERE id = :id", nativeQuery = true)
    void updateDate(@Param("id") int id, @Param("value") String value);
}
