package com.utfpr.facetruco.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
public class Postagem{
    @Id @GeneratedValue
    private Long id;
    private String legenda;
    private String sentimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", nullable = false,
    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date timestamp;

    @ManyToOne
    // @JoinColumn(name="pat_codtipo")
    private Usuario usuario;

    @ManyToMany
    // @JoinColumn(name="pat_codtipo")
    private List<Comentario> comentarios;

    @ManyToMany
    // @JoinColumn(name="pat_codtipo")
    private List<Recurso> recursos;

    @ManyToMany
    // @JoinColumn(name="pat_codtipo")
    private List<Reacao> reacoes;

    @ManyToMany
    @JoinTable(name = "Marcacao",
    joinColumns = @JoinColumn(name = "id_post"),
    inverseJoinColumns = @JoinColumn(name = "id_usu"))
    private List<Usuario> marcados;

    /* Getters and Setter */
    public Long getId(){ return this.id; }
    public String getLegenda(){ return this.legenda; }
    public String getSentimento(){ return this.sentimento; }
    public Date getTimestamp(){ return this.timestamp; }
    public Usuario getUsuario(){ return this.usuario; }
    public List<Comentario> getComentarios() { return this.comentarios; }
    public List<Recurso> getRecursos(){ return this.recursos; }
    public List<Reacao> getReacoes() { return this.reacoes; }
    public List<Usuario> getMarcados() { return this.marcados; }

    public void setId(Long id){ this.id = id; }
    public void setLegenda(String legenda){ this.legenda = legenda; }
    public void setSentimento(String sentimento){ this.sentimento = sentimento; }
    public void setTimestamp(Date timestamp){ this.timestamp = timestamp; }
    public void setUsuario(Usuario usuario){ this.usuario = usuario; }
    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }
    public void setRecursos(List<Recurso> recursos) { this.recursos = recursos; }
    public void setReacoes(List<Reacao> reacoes) { this.reacoes = reacoes; }
    public void setMarcados(List<Usuario> marcados) { this.marcados = marcados; }

    
}