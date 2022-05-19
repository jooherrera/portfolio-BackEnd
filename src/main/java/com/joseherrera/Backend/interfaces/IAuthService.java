package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.dto.LoginRequestDto;
import com.joseherrera.Backend.exception.EmailExistsException;
import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.model.AuthModel;

public interface IAuthService {
    public void createNewAuth(AuthModel newAuth) throws EmailExistsException;
    public AuthModel findAuth(LoginRequestDto loginRequest) throws LoginException;
    public Boolean isValidAuthentication(String authHeaderValue);
}
