
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.interfaces.IQuerys;
import com.joseherrera.Backend.model.HardSkillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardSkillRepository extends JpaRepository<HardSkillModel, Integer>, IQuerys<HardSkillModel> {}