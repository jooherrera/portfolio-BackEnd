package com.joseherrera.Backend.service;

import com.joseherrera.Backend.dto.LoginRequestDto;
import com.joseherrera.Backend.exception.EmailExistsException;
import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.interfaces.IAuthService;
import com.joseherrera.Backend.model.AuthModel;
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
    public void createNewAuth(AuthModel newAuth) throws EmailExistsException{
        String email = newAuth.getEmail();
        String password = newAuth.getPassword();
        
        if (authRepo.existsByEmail(email)) {
            throw new EmailExistsException("El email ya esta registrado.");
        }
               
        newAuth.setPassword(encrypter.encryptPassword(password));

        authRepo.save(newAuth);
    }

    @Override
    public AuthModel findAuth(LoginRequestDto loginRequest) throws LoginException{
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        AuthModel authFound = authRepo.findByEmail(email).orElse(null);

        if (Objects.isNull(authFound)) {
           throw new LoginException("Email o contraseña incorrecto");
        }

        boolean isAuth = encrypter.verifyPassword(password, authFound.getPassword());

        if (!isAuth) {
             throw new LoginException("Email o contraseña incorrecto");
        }

        return authFound;
    }

    @Override
    public Boolean isValidAuthentication(String authHeaderValue) {
        return false;
    }

}
