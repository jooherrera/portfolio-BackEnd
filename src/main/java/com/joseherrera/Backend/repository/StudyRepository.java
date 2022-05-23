package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.interfaces.IQuerys;
import com.joseherrera.Backend.model.StudyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<StudyModel, Integer>, IQuerys<StudyModel> {

}
