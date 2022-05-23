package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.interfaces.IModel;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.service.PatchService;
import com.joseherrera.Backend.utils.Response;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public class RestControllerBase<T extends IModel> {

    @Autowired
    IService<T> controllerService;

    @Autowired
    PatchService<T> patchService;

    @Autowired
    Response response;

    @GetMapping("/")
    public ResponseEntity<Object> get(@RequestParam int dni) {
        T model = controllerService.get(dni);
        return new ResponseEntity<>(response.successWithObject("Info", model), HttpStatus.ACCEPTED);

    }

    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        //header - field - service - personModel
        return patchService.start(authHeader, field, controllerService, false);
    }
}
