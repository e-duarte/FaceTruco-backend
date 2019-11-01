package com.utfpr.facetruco.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentario{
    @Id @GeneratedValue
    private Long id;
    private String comentario;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", nullable = false,
    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date timestamp;

    @ManyToOne
    // @JoinColumn(name="pat_codtipo")
    private Usuario usuario;

    /* Getters and Setters */
    public Long getId() { return this.id; }
    public Date getTimestamp() { return this.timestamp; }
    public String getComentario() { return this.comentario; }
    public Usuario getUsuario() { return this.usuario; }

    public void setId(Long id) { this.id = id; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }


}