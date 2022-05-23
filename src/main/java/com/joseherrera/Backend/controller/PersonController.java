package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.service.PatchService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    IService<PersonModel> personService;

    @Autowired
    PatchService<PersonModel> patchService;

    @PatchMapping("/person")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        //header - field - service - personModel
        return patchService.start(authHeader, field, personService, true);
    }

}
