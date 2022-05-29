package com.joseherrera.Backend.interfaces;

import com.joseherrera.Backend.dto.LoginRequestDto;
import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.model.Auth;

public interface IAuthService {

    public void changePassword(String email, String newPassword);

    public Auth findAuth(LoginRequestDto loginRequest) throws LoginException;
}
