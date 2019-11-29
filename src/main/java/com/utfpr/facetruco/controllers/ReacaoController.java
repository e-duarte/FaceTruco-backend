package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.inject.Inject;
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
        reacao.setPostagem(new PostagemDAO().get(react.getPostId()));
        reacao.setUsuario(new UsuarioDAO().get(react.getUsername()));
        reacao.setReacao(react.getReacao());
        reactDAO.store(reacao);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public List<React> list(@PathParam("id") Long id){
        return this.reactDAO.listAll(id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.reactDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}