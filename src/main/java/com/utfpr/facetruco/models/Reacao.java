package com.utfpr.facetruco.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




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