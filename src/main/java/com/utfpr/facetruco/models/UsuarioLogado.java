package com.utfpr.facetruco.models;


public class UsuarioLogado{
    private String email;
    private String token;


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}