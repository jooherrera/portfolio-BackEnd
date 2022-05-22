
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.model.ContactModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Integer> {
    Optional<ContactModel> findByPersonDni(int dni);
}
