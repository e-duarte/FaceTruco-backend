package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Postagem;
import com.utfpr.facetruco.models.Usuario;


@Path("/Postagens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostagemController {
    private PostagemDAO postagemDAO;
    private UsuarioDAO usuarioDAO;

    public PostagemController(){
        this.postagemDAO = new PostagemDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    @GET
    @Path("/{username}")
    public List<Postagem> list(@PathParam("username") String username){
        List<Postagem> post = this.postagemDAO.listAll(username);
        return post;
    }

    @POST
    public Response store(Postagem post){
        Usuario user = this.usuarioDAO.get(post.getUsuario().getUsername());
        post.setUsuario(user);
        this.postagemDAO.store(post);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.postagemDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}