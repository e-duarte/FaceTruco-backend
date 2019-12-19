package com.utfpr.facetruco.pojo;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;

public class Comment{
    private Long id;
    private Long postId;
    private Long albumId;
    private String comentario;
    private String recurso;
    private String username;
    @JsonbDateFormat(value = "dd-MM-yyyy")
    private LocalDate timestamp;

    public Comment(){ }


    public Comment(Long id, Long postId, Long albumId, String comentario, String recurso, String username, LocalDate timestamp) {
        this.id = id;
        this.postId = postId;
        this.albumId = albumId;
        this.comentario = comentario;
        this.recurso = recurso;
        this.username = username;
        this.timestamp = timestamp;
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

    public Long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getRecurso() {
        return this.recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public LocalDate getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }


}