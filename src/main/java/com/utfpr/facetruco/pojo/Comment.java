package com.utfpr.facetruco.pojo;


public class Comment{
    private Long postId;
    private String comentario;
    private String username;


    public Comment(Long postId, String comentario, String username) {
        this.postId = postId;
        this.comentario = comentario;
        this.username = username;
    }


    public Long getCommentId() {
        return this.postId;
    }

    public void setCommentId(Long id) {
        this.postId = id;
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