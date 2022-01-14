package com.omrigal.mydashboardbackend.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
