
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.interfaces.IQuerys;
import com.joseherrera.Backend.model.SoftSkillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillRepository extends JpaRepository<SoftSkillModel, Integer>, IQuerys<SoftSkillModel> {}