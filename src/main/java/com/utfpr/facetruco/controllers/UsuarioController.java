package com.utfpr.facetruco.controllers;

import java.util.Date;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Usuario;

@Path("/usuario")
public class UsuarioController{
    private UsuarioDAO usuarioDAO;
    
    public UsuarioController(){
        this.usuarioDAO = new UsuarioDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> list(){
        List<Usuario> usuarios = this.usuarioDAO.listAll();
        return usuarios;
    }

    @GET
    @Path("/email")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuario(@PathParam("email") String email){
        Usuario u = this.usuarioDAO.get(email);
        return u;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void store(Usuario u){
        this.usuarioDAO.store(u);
    }
}