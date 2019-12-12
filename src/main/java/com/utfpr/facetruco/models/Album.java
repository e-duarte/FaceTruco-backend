package com.utfpr.facetruco.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Album extends Model{
    private static final long serialVersionUID = 3679301964975935477L;
    
    private String titulo;
    private String descricao;
    
    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "Colaborador",
        joinColumns = @JoinColumn(name = "id_alb"),
        inverseJoinColumns = @JoinColumn(name = "id_usu"))
    private List<Usuario> colabs;

    /* Getters and Setters */
    public String getTitulo() { return this.titulo; }
    public String getDescricao() { return this.descricao; }
    public Usuario getUsuario() { return this.usuario; }
    public List<Usuario> getColabs() { return this.colabs; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setColabs(List<Usuario> colabs) { this.colabs = colabs; }
}