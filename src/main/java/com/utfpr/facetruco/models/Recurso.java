package com.utfpr.facetruco.models;

import javax.persistence.Entity;

@Entity
public class Recurso extends Model{
    private static final long serialVersionUID = -2120085968170803672L;
    
    private String url;
    private String tipo;

    /* Getters and Setters */
    public String getUrl() { return this.url; }
    public String geTipo() { return this.tipo; }

    public void setUrl(String url) { this.url = url; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}