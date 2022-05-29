package com.joseherrera.Backend.service;

import com.joseherrera.Backend.dto.LoginRequestDto;
import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.interfaces.IAuthService;
import com.joseherrera.Backend.model.Auth;
import com.joseherrera.Backend.repository.AuthRepository;
import com.joseherrera.Backend.utils.Encrypt;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthRepository authRepo;

    @Autowired
    private Encrypt encrypter;

    @Override
    public void changePassword(String email, String newPassword) {

        Auth found = authRepo.findByEmail(email).orElse(null);

        found.setPassword(encrypter.encryptPassword(newPassword));

        authRepo.save(found);
    }

    @Override
    public Auth findAuth(LoginRequestDto loginRequest) throws LoginException {

        try {
            String email = loginRequest.getEmail();
            String password = loginRequest.getPassword();

            Auth authFound = authRepo.findByEmail(email).orElse(null);

            if (Objects.isNull(authFound)) {
                throw new LoginException("Email o contraseña incorrecto");
            }

            if (password.equals(authFound.getPassword())) {
                return authFound;
            }

            encrypter.verifyPassword(password, authFound.getPassword());

            return authFound;
        } catch (IllegalArgumentException e) {
            throw new LoginException("Email o contraseña incorrecto");

        } catch (LoginException e) {
            throw new LoginException(e.getMessage());
        }
    }
}
