package com.utfpr.facetruco.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Recurso{
    @Id @GeneratedValue
    private Long id;
    private String url;
    private String tipo;
    
    @Temporal(TemporalType.DATE)
    private Date data;

    /* Getters and Setters */
    public Long getId() { return this.id; }
    public String getUrl() { return this.url; }
    public String geTipo() { return this.tipo; }
    public Date getData() { return this.data; }

    public void setId(Long id) { this.id = id; }
    public void setUrl(String url) { this.url = url; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setData(Date data) { this.data = data; }

}