package com.example.crowdfunding.passswordreset;

public class ForgotPasswordRequest {
    private String email;

    public ForgotPasswordRequest() {
        // default constructor for Jackson
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}