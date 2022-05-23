package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.ContactModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController extends RestControllerBase<ContactModel> {

}
