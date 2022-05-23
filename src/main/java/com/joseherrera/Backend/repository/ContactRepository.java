
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.interfaces.IQuerys;
import com.joseherrera.Backend.model.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Integer>, IQuerys<ContactModel> {}
