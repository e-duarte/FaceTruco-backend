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
import com.utfpr.facetruco.pojo.Post;


@Path("/Postagens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostagemController {
    private PostagemDAO postagemDAO;

    public PostagemController(){
        this.postagemDAO = new PostagemDAO();
    }

    @POST
    public Response store(Postagem post){
        post.setUsuario(new UsuarioDAO().get(post.getUsuario().getUsername()));
        this.postagemDAO.store(post);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{username}")
    public List<Post> list(@PathParam("username") String username){
        return this.postagemDAO.listAll(username);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.postagemDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}