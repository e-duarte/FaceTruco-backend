package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.ComentarioDAO;
import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Comentario;
import com.utfpr.facetruco.pojo.Comment;

@Path("/comentarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComentarioController{
    private ComentarioDAO comentarioDAO;

    public ComentarioController(){
        this.comentarioDAO = new ComentarioDAO();
    }

    @POST
    public Response store(@HeaderParam("id") Long id, Comentario comment){
        comment.setUsuario(new UsuarioDAO().get(comment.getUsuario().getUsername()));
        comment.setPostagem(new PostagemDAO().get(id));
    
        this.comentarioDAO.store(comment);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public Long list(@PathParam("id") Long id){
        //return this.comentarioDAO.listAll(id);
        return id;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.comentarioDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}