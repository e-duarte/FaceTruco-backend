package com.utfpr.facetruco.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.json.bind.annotation.JsonbDateFormat;

public class Post{
    private Long id;
    private Long albumId;
    private String legenda;
    private String sentimento;
    private String username;
    @JsonbDateFormat(value = "dd-MM-yyyy")
    private LocalDate timestamp;
    private List<String> marcados;

    public Post() {}

    public Post(Long id, Long albumId, String legenda, String sentimento, String username, LocalDate timestamp) {
        this.id = id;
        this.albumId = albumId;
        this.legenda = legenda;
        this.sentimento = sentimento;
        this.username = username;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegenda() {
        return this.legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getSentimento() {
        return this.sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
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

    public LocalDate getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getMarcados() {
        return this.marcados;
    }

    public void setMarcados(List<String> marcados) {
        this.marcados = marcados;
    }

}