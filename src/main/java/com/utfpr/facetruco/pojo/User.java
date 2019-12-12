package com.utfpr.facetruco.pojo;



public class User{
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String username;

    private String senha;
    private String genero;
    private String fotoPerfil;
    private String fotoTimeline;
    
    private String dataNascimento;


    public User(){ }


    public User(Long id, String nome, String sobrenome, String email, String username, String fotoPerfil, String fotoTimeline) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.username = username;
        this.fotoPerfil = fotoPerfil;
        this.fotoTimeline = fotoTimeline;
    }


    @Override
    public String toString(){
        return this.username;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFotoPerfil() {
        return this.fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getFotoTimeline() {
        return this.fotoTimeline;
    }

    public void setFotoTimeline(String fotoTimeline) {
        this.fotoTimeline = fotoTimeline;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}