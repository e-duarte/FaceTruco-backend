package com.utfpr.facetruco.controllers;


import javax.ws.rs.PathParam;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.User;


@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController{
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @POST
    public Response store(User user){
        Usuario usuario = new Usuario();

        usuario.setNome(user.getNome());
        usuario.setSobrenome(user.getSobrenome());
        usuario.setEmail(user.getEmail());
        usuario.setUsername(user.getUsername());
        usuario.setSenha(user.getSenha());
        usuario.setGenero(user.getGenero());
        usuario.setFotoPerfil(user.getFotoPerfil());
        usuario.setFotoTimeline(user.getFotoTimeline());
        usuario.setDataNascimento(LocalDate.parse(user.getDataNascimento()));

        this.usuarioDAO.store(usuario);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    public List<User> list(){
        return this.usuarioDAO.listAll();
    }

    @GET
    @Path("/{username}")
    public User getUsuario(@PathParam("username") String username){
        Usuario usuario = this.usuarioDAO.get(username);
        LocalDate date = LocalDate.parse(usuario.getDataNascimento().toString());
        User user = new User();

        user.setNome(usuario.getNome());
        user.setSobrenome(usuario.getSobrenome());
        user.setEmail(usuario.getEmail());
        user.setUsername(usuario.getUsername());
        user.setSenha(usuario.getSenha());
        user.setGenero(usuario.getGenero());
        user.setFotoPerfil(usuario.getFotoPerfil());
        user.setFotoTimeline(usuario.getFotoTimeline());   
        user.setDataNascimento(date.toString());

        return user;
    }

    @DELETE
    @Path("/{username}")
    public Response delete(@PathParam("username") String username){
        this.usuarioDAO.delete(username);
        return Response.status(Response.Status.OK).build();
    }
}