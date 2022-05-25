package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.AddressModel;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AddressRepository extends BaseRepository<AddressModel> {

    Optional<AddressModel> findByPersonDni(int dni);
}
