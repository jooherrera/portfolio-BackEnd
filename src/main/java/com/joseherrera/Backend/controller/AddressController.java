package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.model.AddressModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController extends RestControllerBase<AddressModel> {

}
