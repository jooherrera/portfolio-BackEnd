package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.Institution;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/education/institution")
public class InstitutionController extends CrudBase<Institution> {

}
