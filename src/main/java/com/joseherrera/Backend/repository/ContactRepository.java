package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.Contact;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Contact SET email = :value WHERE id = :id", nativeQuery = true)
    void updateEmail(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Contact SET phone = :value WHERE id = :id", nativeQuery = true)
    void updatePhone(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Contact SET linkedin = :value WHERE id = :id", nativeQuery = true)
    void updateLinkedin(@Param("id") int id, @Param("value") String value);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Contact SET address = :value WHERE id = :id", nativeQuery = true)
    void updateAddress(@Param("id") int id, @Param("value") String value);
}
