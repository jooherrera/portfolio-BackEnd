package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.PersonModel;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Integer> {
    Optional<PersonModel> findByAuthId(int id);
    
}
