package com.utfpr.facetruco.models;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Recurso extends Model{
    private String url;
    private String tipo;

    /* Getters and Setters */
    public String getUrl() { return this.url; }
    public String geTipo() { return this.tipo; }

    public void setUrl(String url) { this.url = url; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}