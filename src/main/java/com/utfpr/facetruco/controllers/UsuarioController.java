package com.utfpr.facetruco.controllers;


import javax.ws.rs.PathParam;

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


@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController{
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @POST
    public Response store(Usuario user){
        this.usuarioDAO.store(user);
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    public List<Usuario> list(){
        return this.usuarioDAO.listAll();
    }

    @GET
    @Path("/{username}")
    public Usuario getUsuario(@PathParam("username") String username){
        Usuario u = this.usuarioDAO.get(username);
        return u;
    }

    @DELETE
    @Path("/{username}")
    public Response delete(@PathParam("username") String username){
        this.usuarioDAO.delete(username);
        return Response.status(Response.Status.OK).build();
    }
}