package com.utfpr.facetruco.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comentario extends Model{
    private static final long serialVersionUID = 3180051993517093044L;

    private String comentario;
    @ManyToOne
    private Usuario usuario;

    /* Getters and Setters */
    public String getComentario() { return this.comentario; }
    public Usuario getUsuario() { return this.usuario; }

    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

}