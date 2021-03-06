package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.dto.ChangePasswordRequestDto;
import com.joseherrera.Backend.dto.LoginRequestDto;

import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.interfaces.IAuthService;
import com.joseherrera.Backend.model.Auth;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.Person;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt.secret.key}")
    String secret;

    @Value("${pass.secret}")
    String passSecret;

    @Value("${registered.email}")
    String email;

    @Autowired
    IAuthService authService;

    @Autowired
    IService<Person> personService;

    @Autowired
    Response response;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginDto) {
        IJwToken jwToken = new JwToken(secret);
        try {
            Auth found = authService.findAuth(loginDto);

            jwToken.addClaim("id", found.getId());
            jwToken.addClaim("email", found.getEmail());

            Person personFound = personService.getOne();

            jwToken.addClaim("dni", personFound.getDni());
            jwToken.addClaim("isAdmin", true);

            String token = jwToken.generateToken();

            return new ResponseEntity<>(response.successWithToken("Autenticado con exito", token), HttpStatus.CREATED);

        } catch (LoginException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Object> resetPassword(@RequestBody ChangePasswordRequestDto request) {

        try {

            if (!request.getPassSecret().equals(this.passSecret)) {
                throw new Exception("No podes modificar la contrase??a");
            }

            authService.changePassword(email, request.getNewPassword());

            return new ResponseEntity<>(response.success("Contrase??a actualizada"), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(response.error("No podes modificar la contrase??a"), HttpStatus.UNAUTHORIZED);
        }
    }
}
