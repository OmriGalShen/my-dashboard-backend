package com.omrigal.mydashboardbackend.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String userinfo) {
        super("Could not find user " + userinfo);
    }
}
