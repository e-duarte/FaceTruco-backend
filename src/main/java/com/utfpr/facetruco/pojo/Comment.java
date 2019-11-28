package com.utfpr.facetruco.pojo;


public class Comment{
    private Long id;
    private Long postId;
    private String comentario;
    private String username;

    public Comment(){ }


    public Comment(Long id, Long postId, String comentario, String username) {
        this.id = id;
        this.postId = postId;
        this.comentario = comentario;
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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