package com.utfpr.facetruco.pojo;


public class Comment{
    private Long id;
    private String comentario;
    private String username;


    public Comment(Long id, String comentario, String username) {
        this.id = id;
        this.comentario = comentario;
        this.username = username;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}