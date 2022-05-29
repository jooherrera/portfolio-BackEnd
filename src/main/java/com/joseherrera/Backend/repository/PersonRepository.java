package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.Person;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET fullName = :value WHERE dni = :id", nativeQuery = true)
    void updateFullName(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET title = :value WHERE dni = :id", nativeQuery = true)
    void updateTitle(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET profileImg = :value WHERE dni = :id", nativeQuery = true)
    void updateProfileImg(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Person SET bannerImg = :value WHERE dni = :id", nativeQuery = true)
    void updateBannerImg(@Param("id") int id, @Param("value") String value);

}
