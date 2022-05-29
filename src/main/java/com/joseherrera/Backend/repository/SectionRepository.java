package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.Section;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Section SET sectionTitle = :value WHERE id = :id", nativeQuery = true)
    void updateSectionTitle(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Section SET visible = :value WHERE id = :id", nativeQuery = true)
    void updateVisible(@Param("id") int id, @Param("value") boolean value);
}
