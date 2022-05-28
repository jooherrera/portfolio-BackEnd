package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.AboutModel;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutModel, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE About SET paragraph = :value WHERE id = :id", nativeQuery = true)
    void updateParagraph(@Param("id") int id, @Param("value") String value);
}

