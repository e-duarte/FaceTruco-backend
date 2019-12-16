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
import com.utfpr.facetruco.pojo.Post;

@Path("/postalbuns")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostagemAlbumController{
    @Inject
    private PostagemDAO postagemDAO;

    @GET
    @Path("/{albumId}")
    public List<Post> list(@PathParam("albumId") Long albumId){
        return postagemDAO.listall(albumId);
    }
}