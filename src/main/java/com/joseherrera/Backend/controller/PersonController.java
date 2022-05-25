package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.PersonModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController extends RestControllerBase<PersonModel> {

}
