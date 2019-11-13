package com.utfpr.facetruco.models;

import javax.persistence.Entity;

@Entity
public class Reacao extends Model{
    private static final long serialVersionUID = -4317924078052165686L;
    
    private String reacao;
    
    /* Getters and Setters */
    public String getReacao() { return this.reacao; }

    public void setReacao(String reacao) { this.reacao = reacao; }

}