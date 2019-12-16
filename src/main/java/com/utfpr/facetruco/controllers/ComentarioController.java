package com.utfpr.facetruco.controllers;

import javax.ws.rs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.AlbumDAO;
import com.utfpr.facetruco.data.ComentarioDAO;
import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Comentario;
import com.utfpr.facetruco.pojo.Comment;

@Path("/comentarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComentarioController{
    @Inject
    private ComentarioDAO comentarioDAO;

    @POST
    public Response store(Comment comment){
        Comentario comentario = new Comentario();

        if(comment.getPostId() != null)
            comentario.setPostagem(new PostagemDAO().get(comment.getPostId()));
        if(comment.getAlbumId() != null)
            comentario.setAlbum(new AlbumDAO().get(comment.getAlbumId()));
        
        comentario.setComentario(comment.getComentario());
        comentario.setRecurso(comment.getRecurso());
        comentario.setUsuario(new UsuarioDAO().get(comment.getUsername()));
        this.comentarioDAO.store(comentario);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.comentarioDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}