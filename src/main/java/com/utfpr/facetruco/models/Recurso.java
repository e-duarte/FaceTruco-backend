package com.utfpr.facetruco.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Recurso extends Model{
    private static final long serialVersionUID = -2120085968170803672L;
    
    private String url;
    private String tipo;

    @ManyToOne 
    private Postagem postagem;

    @ManyToOne 
    private Album album;

    @ManyToOne 
    private Usuario usuario;

    /* Getters and Setters */
    public String getUrl() { return this.url; }
    public String geTipo() { return this.tipo; }
    public Postagem getPostagem() { return this.postagem; }
    public Usuario getUsuario() { return this.usuario; }
    public Album getAlbum() { return this.album; }

    public void setUrl(String url) { this.url = url; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPostagem(Postagem postagem) { this.postagem = postagem; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setAlbum(Album album) { this.album = album; }
}