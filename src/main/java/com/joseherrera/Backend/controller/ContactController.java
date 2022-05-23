package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.ContactModel;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    @Autowired
    IService<ContactModel> contactService;

    @Autowired
    PatchService<ContactModel> patchService;

    @Autowired
    Response response;

    @GetMapping("/")
    public ResponseEntity<Object> getContact(@RequestParam int dni) {
        ContactModel contact = contactService.get(dni);
        return new ResponseEntity<>(response.successWithObject("Info", contact), HttpStatus.ACCEPTED);

    }

    @PatchMapping("/")
    public ResponseEntity<Object> contact(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        //header - field - service - personModel
        return patchService.start(authHeader, field, contactService, false);
    }

}
