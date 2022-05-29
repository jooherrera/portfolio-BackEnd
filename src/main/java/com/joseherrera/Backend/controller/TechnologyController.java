package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.Technology;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/hard-skill/technology")
public class TechnologyController extends CrudBase<Technology> {

}
