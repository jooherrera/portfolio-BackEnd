package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.Skill;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Skill SET name = :value WHERE id = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Skill SET porcent = :value WHERE id = :id", nativeQuery = true)
    void updatePorcent(@Param("id") int id, @Param("value") String value);

}
