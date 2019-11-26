package com.utfpr.facetruco.pojo;


public class Post{
    private Long id;
    private String legenda;
    private String sentimento;
    private String username;

    public Post() {}


    public Post(Long id, String legenda, String sentimento, String username) {
        this.id = id;
        this.legenda = legenda;
        this.sentimento = sentimento;
        this.username = username;
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


}