package com.omrigal.mydashboardbackend.model;

import lombok.Data;

@Data
public class ClientLoginResponse {
    private String email;
    private String username;
    private String password;

    public ClientLoginResponse(Client client) {
        this.email = client.getEmail();
        this.username = client.getUsername();
        this.password = client.getPassword();
    }

}
