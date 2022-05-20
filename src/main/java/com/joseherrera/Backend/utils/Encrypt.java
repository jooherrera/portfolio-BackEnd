package com.joseherrera.Backend.utils;

import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.interfaces.IEncrypt;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Encrypt implements IEncrypt {

    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public void verifyPassword(String password, String hashPassword) throws LoginException {
        
        boolean isEquals = BCrypt.checkpw(password, hashPassword);
        if (!isEquals) {
            throw new LoginException("Usuario o contraseña incorrecta");
        }

    }

}
