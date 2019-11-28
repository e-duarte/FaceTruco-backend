package com.utfpr.facetruco.pojo;

public class React{
    private Long id;
    private Long postId;
    private String reacao;
    private String username;

    public React(){}

    public React(Long id, Long postId, String reacao, String username) {
        this.id = id;
        this.postId = postId;
        this.reacao = reacao;
        this.username = username;
    }

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getReacao() {
        return this.reacao;
    }

    public void setReacao(String reacao) {
        this.reacao = reacao;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}