package com.joseherrera.Backend.dto;

import lombok.Getter;

@Getter
public class ChangePasswordRequestDto {

    private String newPassword;
    private String passSecret;
}
