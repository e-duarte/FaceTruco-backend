package com.utfpr.facetruco.models;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Usuario extends Model{
    private static final long serialVersionUID = -248494534314157762L;
    
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
    
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    @ManyToMany
    @JoinTable(name = "Amigo",
    joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "id_target"))
    private List<Usuario> amigos;

    @ElementCollection
    @CollectionTable(
        name="SolicitacoesEnviadas",
        joinColumns=@JoinColumn(name="id_usuario"))
    @Column(name="Solicitacoes")
    private List<String> solicitacoesEnviadas;

    @Override
    public String toString(){
        return this.username;
    }



    /* Getters and Setters */
    public String getGenero() { return this.genero; }
    public String getNome() { return this.nome; }
    public String getSobrenome() { return this.sobrenome; }
    public String getSenha() { return this.senha; }
    public LocalDate getDataNascimento() { return this.dataNascimento; }
    public String getFotoPerfil() { return this.fotoPerfil; }
    public String getFotoTimeline() { return this.fotoTimeline; }
    public String getEmail() { return this.email; }
    public List<Usuario> getAmigos() { return this.amigos; }
    public String getUsername() { return this.username; }
    public List<String> getSolicitacoesEnviadas() { return this.solicitacoesEnviadas; }

    public void setNome(String nome) { this.nome = nome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }
    public void setFotoTimeline(String fotoTimeline) { this.fotoTimeline = fotoTimeline; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAmigos(List<Usuario> amigos) { this.amigos = amigos; }
    public void setUsername(String username) { this.username = username; }
    public void setSolicitacoesEnviadas(List<String> solicitacoesEnviadas) { this.solicitacoesEnviadas = solicitacoesEnviadas; }

}