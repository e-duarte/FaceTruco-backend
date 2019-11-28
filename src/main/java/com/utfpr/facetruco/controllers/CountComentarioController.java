package com.utfpr.facetruco.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.data.ComentarioDAO;


@Path("/countcomentarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountComentarioController{
    private ComentarioDAO comentarioDAO;

    public CountComentarioController(){
        this.comentarioDAO = new ComentarioDAO();
    }

    @GET
    @Path("/{id}")
    public Long get(@PathParam("id") Long id){
        return comentarioDAO.countComentarios(id);
    }
}