package com.utfpr.facetruco.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Solicitacao extends Model{
    private static final long serialVersionUID = 1L;
    
    private String usernameOrigem;
    private Boolean visualizada;
    
    @ManyToOne
    private Usuario usuario;

    public String getUsernameOrigem() { return this.usernameOrigem; }
    public Boolean isVisualizada() { return this.visualizada; }
    public Boolean getVisualizada() { return this.visualizada; }
    public Usuario getUsuario() { return this.usuario; }

    public void setUsernameOrigem(String usernameOrigem) { this.usernameOrigem = usernameOrigem; }
    public void setVisualizada(Boolean visualizada) { this.visualizada = visualizada; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario;}
}