package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Integer> {

    @Modifying
    @Query(value = "UPDATE Project SET name = :value WHERE id = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Project SET description = :value WHERE id = :id", nativeQuery = true)
    void updateDescription(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Project SET webLink = :value WHERE id = :id", nativeQuery = true)
    void updateWebLink(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Project SET githubLink = :value WHERE id = :id", nativeQuery = true)
    void updateGithubLink(@Param("id") int id, @Param("value") String value);

}
