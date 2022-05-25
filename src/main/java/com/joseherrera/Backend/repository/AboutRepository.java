package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.AboutModel;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends BaseRepository<AboutModel> {

    Optional<AboutModel> findByPersonDni(int dni);

}
