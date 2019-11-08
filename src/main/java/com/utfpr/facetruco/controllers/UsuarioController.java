package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.ws.rs.PathParam;
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
    private UsuarioDAO usuarioDAO;
    
    public UsuarioController(){
        this.usuarioDAO = new UsuarioDAO();
    }
    
    @GET
    // @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> list(){
        List<Usuario> usuarios = this.usuarioDAO.listAll();
        return usuarios;
    }

    @GET
    @Path("/{username}")
    public Usuario getUsuario(@PathParam("username") String username){
        Usuario u = this.usuarioDAO.get(username);
        return u;
    }

    @POST
    public Response store(Usuario u){
        this.usuarioDAO.store(u);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{username}")
    public Response delete(@PathParam("username") String username){
        this.usuarioDAO.delete(username);
        return Response.status(Response.Status.OK).build();
    }
}