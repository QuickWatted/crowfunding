package com.example.crowdfunding.passswordreset;



public class ResetPasswordRequest {
    private String token;
    private String newPassword;

    public ResetPasswordRequest() {
        // default constructor for Jackson
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
