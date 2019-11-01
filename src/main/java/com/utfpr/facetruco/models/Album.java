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
public class Album{
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String descricao;
    
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
    private List<Postagem> posts;

    @ManyToMany
    @JoinTable(name = "Colaborador",
        joinColumns = @JoinColumn(name = "id_alb"),
        inverseJoinColumns = @JoinColumn(name = "id_usu"))
    private List<Usuario> colabs;

    @ManyToMany
    // @JoinColumn(name="pat_codtipo")
    private List<Reacao> reacoes;

    /* Getters and Setters */
    public Long getId() { return this.id; }
    public String getTitulo() { return this.titulo; }
    public String getDescricao() { return this.descricao; }
    public Date geTimestamp() { return this.timestamp; }
    public Usuario getUsuario() { return this.usuario; }
    public List<Comentario> getComentarios() { return this.comentarios; }
    public List<Postagem> getPosts() { return this.posts; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void seTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }
    public void setPosts(List<Postagem> posts) { this.posts = posts; }

}