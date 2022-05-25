package com.joseherrera.Backend.interfaces;

import java.util.Optional;

public interface IFindByPersonDni<T> {
    Optional<T> findByPersonDni(int dni);
}
