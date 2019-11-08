package com.utfpr.facetruco.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

import java.util.Date;
import java.util.List;

@Entity
public class Usuario{
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String sobrenome;
    
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String senha;
    private String genero;
    private String fotoPerfil;
    private String fotoTimeline;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", nullable = false,
    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date timestamp;

    @ManyToMany
    @JoinTable(name = "Amigo",
    joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "id_target"))
    private List<Usuario> amigos;

    /* Getters and Setters */
    public Long getId() { return this.id; }
    public String getGenero() { return this.genero; }
    public String getNome() { return this.nome; }
    public String getSobrenome() { return this.sobrenome; }
    public String getSenha() { return this.senha; }
    public Date getDataNascimento() { return this.dataNascimento; }
    public String getFotoPerfil() { return this.fotoPerfil; }
    public String getFotoTimeline() { return this.fotoTimeline; }
    public String getEmail() { return this.email; }
    public Date getTimestamp() { return this.timestamp; }
    public List<Usuario> getAmigos() { return this.amigos; }
    public String getUsername() { return this.username; }

    public void setNome(String nome) { this.nome = nome; }
    public void setId(Long id) { this.id = id; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
    public void setFotoTimeline(String fotoTimeline) { this.fotoTimeline = fotoTimeline; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public void setAmigos(List<Usuario> amigos) { this.amigos = amigos; }
    public void setUsername(String username) { this.username = username; }


}