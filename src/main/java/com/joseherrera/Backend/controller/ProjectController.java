package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.ProjectModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/personal-project/project")
public class ProjectController extends RestControllerBase<ProjectModel> {

}
