package com.omrigal.mydashboardbackend.model;

import lombok.Data;

import java.util.Date;

@Data
public class ClientDetails {
    private String username;
    private Date registerTime;
    private Long loginCount;

    public ClientDetails(Client client) {
        this.username = client.getUsername();
        this.registerTime = client.getRegisterTime();
        this.loginCount = client.getLoginCount();
    }
}
