package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.Job;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/experience/job")
public class JobController extends CrudBase<Job> {

}
