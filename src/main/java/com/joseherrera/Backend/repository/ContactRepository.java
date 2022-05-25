package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.ContactModel;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ContactRepository extends BaseRepository<ContactModel> {

    Optional<ContactModel> findByPersonDni(int dni);
}
