package com.utfpr.facetruco.models;


public class UsuarioLogado{
    private String username;
    private String token;

    /* Getters and Setters */
    public String getUsername() { return this.username; }
    public String getToken() { return this.token; }

    public void setUsername(String username) { this.username = username; }
    public void setToken(String token) { this.token = token; }
}