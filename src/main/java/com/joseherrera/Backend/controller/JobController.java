package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.JobModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/experience/job")
public class JobController extends RestControllerBase<JobModel> {

}