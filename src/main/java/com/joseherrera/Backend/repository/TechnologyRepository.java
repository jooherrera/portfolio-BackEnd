package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.Technology;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Technology SET logo = :value WHERE id = :id", nativeQuery = true)
    void updateLogo(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Technology SET name = :value WHERE id = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);

}
