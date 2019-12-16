package com.utfpr.facetruco.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Reacao extends Model{
    private static final long serialVersionUID = -4317924078052165686L;
    
    private String reacao;

    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Postagem postagem;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Comentario comentario;
    
    /* Getters and Setters */
    public String getReacao() { return this.reacao; }
    public Usuario getUsuario() { return this.usuario; }
    public Postagem getPostagem() { return this.postagem; }
    public Album getAlbum() { return this.album; }
    public Comentario getComentario() { return this.comentario; }

    public void setReacao(String reacao) { this.reacao = reacao; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setPostagem(Postagem postagem) { this.postagem = postagem; }
    public void setAlbum(Album album) { this.album = album; }
    public void setComentario(Comentario comentario) { this.comentario = comentario; }
}