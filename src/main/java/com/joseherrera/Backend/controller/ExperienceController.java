package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.ExperienceModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/experience")
public class ExperienceController extends RestControllerBase<ExperienceModel>{

}
