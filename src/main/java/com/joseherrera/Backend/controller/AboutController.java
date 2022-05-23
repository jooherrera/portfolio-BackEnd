package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.AboutModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/about")
public class AboutController extends RestControllerBase<AboutModel> {

}
