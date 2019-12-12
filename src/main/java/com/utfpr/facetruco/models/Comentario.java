package com.utfpr.facetruco.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comentario extends Model{
    private static final long serialVersionUID = 3180051993517093044L;

    private String comentario;
    
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Postagem postagem;

    @ManyToOne
    private Album album;


    /* Getters and Setters */
    public String getComentario() { return this.comentario; }
    public Usuario getUsuario() { return this.usuario; }
    public Postagem getPostagem() { return  this.postagem; }
    public Album getAlbum() { return this.album; }

    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setPostagem(Postagem postagem) { this.postagem = postagem; }
    public void setAlbum(Album album) { this.album = album; }
}