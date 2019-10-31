package com.utfpr.facetruco.controllers;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.models.Usuario;

@Path("/usuario")
public class UsuarioController{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario list(){
        Usuario u = new Usuario();
        u.setNome("João");
        u.setSobrenome("Souza");
        u.setEmail("@");
        u.setSenha("senha");
        u.setData_nascimento(new Date("1998/04/17"));
        u.setFoto_perfil("foto_perfil");
        u.setFoto_timeline("foto_timeline");
        u.setGenero("genero");
        return u;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario store(){
        Usuario u = new Usuario();
        u.setNome("João");
        u.setSobrenome("Souza");
        u.setEmail("@");
        u.setSenha("senha");
        u.setData_nascimento(new Date("1998/04/17"));
        u.setFoto_perfil("foto_perfil");
        u.setFoto_timeline("foto_timeline");
        u.setGenero("genero");
        return u;
    }
}