package com.utfpr.facetruco.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Postagem extends Model{
    private static final long serialVersionUID = -1760189516304570363L;
    
    private String legenda;
    private String sentimento;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "Marcacao",
    joinColumns = @JoinColumn(name = "id_post"),
    inverseJoinColumns = @JoinColumn(name = "id_usu"))
    private List<Usuario> marcados;

    public Postagem() {}


    /* Getters and Setter */
    public String getLegenda(){ return this.legenda; }
    public String getSentimento(){ return this.sentimento; }
    public Usuario getUsuario(){ return this.usuario; }
    public List<Usuario> getMarcados() { return this.marcados; }

    public void setLegenda(String legenda){ this.legenda = legenda; }
    public void setSentimento(String sentimento){ this.sentimento = sentimento; }
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }
    public void setMarcados(List<Usuario> marcados) { this.marcados = marcados; }
}