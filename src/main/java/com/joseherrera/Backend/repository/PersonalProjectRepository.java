package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.interfaces.IQuerys;
import com.joseherrera.Backend.model.PersonalProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalProjectRepository extends JpaRepository<PersonalProjectModel, Integer>, IQuerys<PersonalProjectModel> {
}
