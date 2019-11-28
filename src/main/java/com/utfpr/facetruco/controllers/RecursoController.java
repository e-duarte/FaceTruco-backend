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
import com.utfpr.facetruco.data.RecursoDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Recurso;
import com.utfpr.facetruco.pojo.Resource;

@Path("/recursos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecursoController{
    private RecursoDAO recursoDAO;

    public RecursoController(){
        this.recursoDAO = new RecursoDAO();
    }

    @POST
    public Response store(Resource resource){
        Recurso recurso = new Recurso();
        recurso.setUrl(resource.getUrl());
        recurso.setTipo(resource.getTipo());
        recurso.setUsuario(new UsuarioDAO().get(resource.getUsername()));

        recurso.setPostagem(new PostagemDAO().get(resource.getPostId()));

        recursoDAO.store(recurso);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}/post")
    public List<Resource> list(@PathParam("id") Long id){
        return recursoDAO.listPost(id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.recursoDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}