
package com.joseherrera.Backend.interfaces;

import java.util.List;
import java.util.Optional;

public interface IQuerys<T>{
     Optional<T> findByPersonDni(int dni);
}

