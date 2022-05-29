package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.dto.ChangePasswordRequestDto;
import com.joseherrera.Backend.dto.LoginRequestDto;

import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.interfaces.IAuthService;
import com.joseherrera.Backend.model.AuthModel;
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
import com.joseherrera.Backend.model.PersonModel;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
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
    IService<PersonModel> personService;

    @Autowired
    Response response;

    @CrossOrigin("*")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginDto) {
        IJwToken jwToken = new JwToken(secret);
        try {
            AuthModel found = authService.findAuth(loginDto);

            jwToken.addClaim("id", found.getId());
            jwToken.addClaim("email", found.getEmail());

            PersonModel personFound = personService.getOne();

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
            
            if(!request.getPassSecret().equals(this.passSecret)){
                throw new Exception("No podes modificar la contraseña");
            }
            
            authService.changePassword(email, request.getNewPassword());
            

            return new ResponseEntity<>(response.success("Contraseña actualizada"), HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>(response.error("No podes modificar la contraseña"), HttpStatus.UNAUTHORIZED);
        }
    }
}
