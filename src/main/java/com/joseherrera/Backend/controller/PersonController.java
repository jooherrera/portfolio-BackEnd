package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/person")
public class PersonController {
    
    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    IService<PersonModel> service;

    @Autowired
    Response response;

    @GetMapping("/")
    @ResponseBody
    public PersonModel get() {
        return service.getOne();
    }
    
    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) throws Exception {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.validate(authHeader);

            if (!token.getIsAdmin()) {
                throw new WrongTokenException("No estas autorizado a modificar");
            }
            
            service.update(token.getPersonPK(), field);
            
            PersonModel updatedModel = service.getOne();

            return new ResponseEntity<>(updatedModel, HttpStatus.ACCEPTED);
        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (SignatureException e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
