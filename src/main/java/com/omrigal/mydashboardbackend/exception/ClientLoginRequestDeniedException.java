package com.omrigal.mydashboardbackend.exception;

public class ClientLoginRequestDeniedException extends RuntimeException{
    public ClientLoginRequestDeniedException(String message) {
        super(message);
    }
}
