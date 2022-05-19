package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.dto.LoginRequestDto;
import com.joseherrera.Backend.exception.EmailExistsException;
import com.joseherrera.Backend.exception.LoginException;
import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IAuthService;
import com.joseherrera.Backend.interfaces.IResponse;
import com.joseherrera.Backend.model.AuthModel;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.utils.Token;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${jwt.secret.key}")
    String secret;
    @Value("${jwt.expTime}")
    Long expTime;

    @Autowired
    IAuthService authService;

    @Autowired
    Response response;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody AuthModel newAuth) {
        try {
            authService.createNewAuth(newAuth);
            return new ResponseEntity<>(response.success("Usuario creado"), HttpStatus.CREATED);
        } catch (EmailExistsException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.FORBIDDEN);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginDto) {
        IJwToken jwToken = new JwToken(secret, expTime);
        try {
            AuthModel found = authService.findAuth(loginDto);
           
            jwToken.addClaim("id", found.getId());
            jwToken.addClaim("email", found.getEmail());

            String token = jwToken.generateToken();

            return new ResponseEntity<>(response.successWithToken("Autenticado con exito", token), HttpStatus.CREATED);

        } catch (LoginException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping("/dash")
    public ResponseEntity<Object> dash(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        IJwToken jwToken = new JwToken(secret);
        
        try {
            if (Objects.isNull(authHeader)) {
            return new ResponseEntity<>(response.error("Header sin token"), HttpStatus.UNAUTHORIZED);
        }

            Token token = jwToken.getTokenPayload(authHeader);
                 
        return new ResponseEntity<>(response.successWithObject("Info", token), HttpStatus.ACCEPTED);
            
        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
     
        
        

    }
}
