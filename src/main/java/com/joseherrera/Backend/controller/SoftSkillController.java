package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.SoftSkillModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/soft-skill")
public class SoftSkillController extends RestControllerBase<SoftSkillModel> {

}
