package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.PersonModel;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController extends RestControllerBase<PersonModel> {

    @Override
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        return patchService.start(authHeader, field, controllerService, true);
    }

}
