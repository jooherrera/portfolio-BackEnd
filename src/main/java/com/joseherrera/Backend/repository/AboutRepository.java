
package com.joseherrera.Backend.repository;

import com.joseherrera.Backend.interfaces.IQuerys;
import com.joseherrera.Backend.model.AboutModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<AboutModel, Integer>, IQuerys<AboutModel> {}    
