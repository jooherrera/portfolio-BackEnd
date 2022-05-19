package com.joseherrera.Backend.interfaces;

public interface IEncrypt {

    String encryptPassword(String password);

    boolean verifyPassword(String password, String hashPassword);
}
