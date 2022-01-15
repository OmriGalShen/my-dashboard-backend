package com.omrigal.mydashboardbackend.model;

import lombok.Data;

import java.util.Date;

@Data
public class OnlineClient {
    private String username;
    private Date loginTime;
    private Date lastUpdated;
    private String ip;

    public OnlineClient(Client client) {
        this.username = client.getUsername();
        this.loginTime = client.getLoginTime();
        this.lastUpdated = client.getLastUpdated();
        this.ip = client.getIp();
    }
}
