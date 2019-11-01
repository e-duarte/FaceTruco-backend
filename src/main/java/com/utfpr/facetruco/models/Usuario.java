package com.utfpr.facetruco.models;

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
    private String email;
    private String senha;
    private String genero;
    
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    private String foto_perfil;
    private String foto_timeline;

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
    public Date getData_nascimento() { return this.data_nascimento; }
    public String getFoto_perfil() { return this.foto_perfil; }
    public String getFoto_timeline() { return this.foto_timeline; }
    public String getEmail() { return this.email; }
    public void setNome(String nome) { this.nome = nome; }
    public void setId(Long id) { this.id = id; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setData_nascimento(Date data_nascimento) { this.data_nascimento = data_nascimento; }
    public void setFoto_perfil(String foto_perfil) { this.foto_perfil = foto_perfil; }
    public void setFoto_timeline(String foto_timeline) { this.foto_timeline = foto_timeline; }
    public void setGenero(String genero) { this.genero = genero; }


}