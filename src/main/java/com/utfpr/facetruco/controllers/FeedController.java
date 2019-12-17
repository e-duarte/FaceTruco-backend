package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.pojo.Post;


@Path("/feeds")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedController{
    @Inject
    private PostagemDAO postagemDAO;

    @GET
    @Path("/{username}")
    public List<Post> list(@PathParam("username") String username){
        return postagemDAO.listPostAmigosUsuario(new UsuarioDAO().get(username));
    }
}