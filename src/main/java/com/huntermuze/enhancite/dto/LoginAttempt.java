package com.huntermuze.enhancite.dto;

public class LoginAttempt {
    private final String email;
    private final String passwordProvided;

    public LoginAttempt(String email, String passwordProvided) {
        this.email = email;
        this.passwordProvided = passwordProvided;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordProvided() {
        return passwordProvided;
    }
}
