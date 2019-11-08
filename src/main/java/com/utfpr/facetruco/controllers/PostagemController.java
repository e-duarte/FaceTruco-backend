package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.models.Postagem;


@Path("/Postagem")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostagemController{
    private PostagemDAO postagemDAO;

    public PostagemController(){
        this.postagemDAO = new PostagemDAO();
    }

    @GET
    @Path("/{username}")
    public List<Postagem> list(@PathParam("username") String username){
        List<Postagem> post = this.postagemDAO.listAll(username);
        return post;
    }

    @POST
    public Response store(Postagem post){
        this.postagemDAO.store(post);
        return Response.status(Response.Status.CREATED).build();
    }
}