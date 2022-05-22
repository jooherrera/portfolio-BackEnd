package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.utils.Token;

public interface IJwToken {

    public void addClaim(String key, Object value);

    public String generateToken();

    public Token getTokenPayload(String headerToken) throws WrongTokenException;

}
