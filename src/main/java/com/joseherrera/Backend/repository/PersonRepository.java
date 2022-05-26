package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Integer> {

    //@Transactional
    @Modifying
    @Query(value = "UPDATE Person SET name = :value WHERE dni = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);

    //@Transactional
    @Modifying
    @Query(value = "UPDATE Person SET lastName = :lastName WHERE dni = :id", nativeQuery = true)
    void updateLastName(@Param("id") int id, @Param("lastName") String lastName);

    @Modifying
    @Query(value = "UPDATE Person SET title = :value WHERE dni = :id", nativeQuery = true)
    void updateTitle(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Person SET profileImg = :value WHERE dni = :id", nativeQuery = true)
    void updateProfileImg(@Param("id") int id, @Param("value") String value);

    @Modifying
    @Query(value = "UPDATE Person SET bannerImg = :value WHERE dni = :id", nativeQuery = true)
    void updateBannerImg(@Param("id") int id, @Param("value") String value);

}
