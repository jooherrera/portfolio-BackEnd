package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.PersonModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<PersonModel>{

    Optional<PersonModel> findByAuthId(int id);
    Optional<PersonModel> findByDni(int dni);

    //@Transactional
    @Modifying
    @Query(value = "UPDATE Person SET name = :value WHERE authId = :id", nativeQuery = true)
    void updateName(@Param("id") int id, @Param("value") String value);

    //@Transactional
    @Modifying
    @Query(value = "UPDATE Person SET lastName = :lastName WHERE authId = :id", nativeQuery = true)
    void updateLastName(@Param("id") int id, @Param("lastName") String lastName);

}
