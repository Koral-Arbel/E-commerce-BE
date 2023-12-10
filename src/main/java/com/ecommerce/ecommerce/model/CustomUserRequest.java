package com.ecommerce.ecommerce.model;

public class CustomUserRequest {
    private String username;
    private String password;
    public CustomUserRequest(){}

    public CustomUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public CustomUser toCustomUser(){
        return new CustomUser(
                null,
                "",
                "",
                "",
                "",
                toCustomUser().getFullAddress(),
                this.username,
                this.password,
                null,
                null
        );
    }
}
