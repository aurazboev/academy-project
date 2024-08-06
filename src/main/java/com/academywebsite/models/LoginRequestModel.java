package com.academywebsite.models;

import lombok.Data;

@Data
public class LoginRequestModel {
    private String username;
    private String password;
}
