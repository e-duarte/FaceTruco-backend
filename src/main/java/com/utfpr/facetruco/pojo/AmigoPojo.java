package com.utfpr.facetruco.pojo;

import java.util.List;

public class AmigoPojo{
    private String username;
    private List<String> amigos;


    public AmigoPojo() { }


    public AmigoPojo(String username, List<String> amigos) {
        this.username = username;
        this.amigos = amigos;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAmigos() {
        return this.amigos;
    }

    public void setAmigos(List<String> amigo) {
        this.amigos = amigo;
    }

}