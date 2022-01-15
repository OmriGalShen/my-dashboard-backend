package com.omrigal.mydashboardbackend.model;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDetailsResponse {
    private String username;
    private Date registerTime;
    private Long loginCount;

    public ClientDetailsResponse(Client client) {
        this.username = client.getUsername();
        this.registerTime = client.getRegisterTime();
        this.loginCount = client.getLoginCount();
    }
}
