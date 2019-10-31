package com.utfpr.facetruco.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Reacao{
    @Id @GeneratedValue
    private Long id;
    private String reacao;
    

    /* Getters and Setters */
    public Long getId() {return this.id; }
    public String getReacao() { return this.reacao; }

    public void setId(Long id) { this.id = id; }
    public void setReacao(String reacao) { this.reacao = reacao; }

}