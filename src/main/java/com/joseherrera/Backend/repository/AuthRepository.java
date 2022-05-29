package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.Auth;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {

    Optional<Auth> findByEmail(String email);

}
