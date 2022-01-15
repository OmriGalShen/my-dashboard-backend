package com.omrigal.mydashboardbackend.model;

import lombok.Data;

@Data
public class ClientLoginRequest {
    private String email;
    private String password;
}
