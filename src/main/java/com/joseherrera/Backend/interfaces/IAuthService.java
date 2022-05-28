package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.dto.LoginRequestDto;
import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.model.AuthModel;

public interface IAuthService {

    public void changePassword(int id, String newPassword);

    public AuthModel findAuth(LoginRequestDto loginRequest) throws LoginException;
}
