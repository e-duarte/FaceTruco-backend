package com.utfpr.facetruco.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.AlbumDAO;
import com.utfpr.facetruco.data.ComentarioDAO;
import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.ReacaoDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Reacao;
import com.utfpr.facetruco.pojo.React;

@Path("/reacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReacaoController{
    @Inject
    private ReacaoDAO reactDAO;

    @POST
    public Response store(React react){
        Reacao reacao = new Reacao();
        if(react.getPostId() != null)
            reacao.setPostagem(new PostagemDAO().get(react.getPostId()));
        if(react.getAlbumId() != null)
            reacao.setAlbum(new AlbumDAO().get(react.getAlbumId()));
        if(react.getCommentId() != null)
            reacao.setComentario(new ComentarioDAO().get(react.getCommentId()));
        reacao.setUsuario(new UsuarioDAO().get(react.getUsername()));
        reacao.setReacao(react.getReacao());
        reactDAO.store(reacao);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.reactDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}