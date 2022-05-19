package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.AuthModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthModel, Integer>{
    Optional<AuthModel> findByEmail(String email);
    
  
    boolean existsByEmail(String email);
}

