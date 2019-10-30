package com.utfpr.facetruco.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
public class Usuario{
    @Id @GeneratedValue
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    private String foto_perfil;
    private String foto_timeline;


    /* Getters and Setters */
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSobrenome() { return this.sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return this.senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public Date getData_nascimento() { return this.data_nascimento; }
    public void setData_nascimento(Date data_nascimento) { this.data_nascimento = data_nascimento; }
    public String getFoto_perfil() { return this.foto_perfil; }
    public void setFoto_perfil(String foto_perfil) { this.foto_perfil = foto_perfil; }
    public String getFoto_timeline() { return this.foto_timeline; }
    public void setFoto_timeline(String foto_timeline) { this.foto_timeline = foto_timeline; }

}