package com.utfpr.facetruco.pojo;

public class Resource{
    private Long id;
    private Long postId;
    private Long albumId;
    private String username;

    private String url;
    private String tipo;


    public Resource() { }

    public Resource(Long id, Long postId, Long albumId, String username, String url, String tipo) {
        this.id = id;
        this.postId = postId;
        this.albumId = albumId;
        this.username = username;
        this.url = url;
        this.tipo = tipo;
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

    public void setPostId(Long postid) {
        this.postId = postid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

}