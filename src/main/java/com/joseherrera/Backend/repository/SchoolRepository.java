package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.SchoolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolModel, Integer> {

    @Modifying
    @Query(value = "UPDATE School SET company = :value WHERE id = :id", nativeQuery = true)
    void updateCompany(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE School SET logo = :value WHERE id = :id", nativeQuery = true)
    void updateLogo(@Param("id") int id, @Param("value") String value);

}
