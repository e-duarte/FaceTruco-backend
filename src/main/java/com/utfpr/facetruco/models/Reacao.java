package com.utfpr.facetruco.models;


import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Reacao extends Model{
    private String reacao;
    
    /* Getters and Setters */
    public String getReacao() { return this.reacao; }

    public void setReacao(String reacao) { this.reacao = reacao; }

}