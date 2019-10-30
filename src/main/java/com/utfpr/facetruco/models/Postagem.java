package com.utfpr.facetruco.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Postagem{
    @Id @GeneratedValue
    private Long id;
    private String legenda;
    private String sentimento;
    
    //@Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    // @JoinColumn(name="pat_codtipo")
    private Usuario usuario;

    /* Getters and Setter */
    public String getLegenda(){ return this.legenda; }
    public String getSentimento(){ return this.sentimento; }
    public Date getData(){ return this.data; }
    public Usuario getUsuario(){ return this.usuario; }

    public void setLegenda(String legenda){ this.legenda = legenda; }
    public void setSentimento(String sentimento){ this.sentimento = sentimento; }
    public void setData(Date data){ this.data = data; }
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }
    
}