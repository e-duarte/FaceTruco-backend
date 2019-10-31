package com.utfpr.facetruco.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Comentario{
    @Id @GeneratedValue
    private Long id;
    private String comentario;
    
    @Temporal(TemporalType.DATE)
    private Date data;

    /* Getters and Setters */
    public Long getId() { return this.id; }
    public Date getData() { return this.data; }
    public String getComentario() { return this.comentario; }

    public void setId(Long id) { this.id = id; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public void setData(Date data) { this.data = data; }

}