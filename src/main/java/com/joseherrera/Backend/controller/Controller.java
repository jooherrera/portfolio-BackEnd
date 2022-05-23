package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${environment.name}")
    private String envName;

    @Autowired
    IService<PersonModel> personService;

    @Autowired
    Response response;

    @GetMapping("/")
    public String home() {

        return "Home API - V1 -- " + envName;
    }

    @GetMapping("/profile")
    public ResponseEntity<Object> getProfile(@RequestParam int id) {
        PersonModel person = personService.get(id);
        return new ResponseEntity<>(response.successWithObject("Info", person), HttpStatus.ACCEPTED);
    }

}
