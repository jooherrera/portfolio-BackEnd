package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.model.JobModel;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Token;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/experience/job")
public class JobController extends RestControllerBase<JobModel> {

    @PostMapping("/")
    public ResponseEntity<Object> add(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Integer> field) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);
            
            controllerService.add(field.get("experienceId"));
            return new ResponseEntity<>(response.success("Agregado con exito"), HttpStatus.CREATED);

        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }
    
    


}
