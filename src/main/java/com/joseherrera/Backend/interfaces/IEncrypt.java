package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.exception.LoginException;

public interface IEncrypt {

    String encryptPassword(String password);

    void verifyPassword(String password, String hashPassword) throws LoginException;
}
