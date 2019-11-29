package com.utfpr.facetruco.controllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.data.ReacaoDAO;

@Path("/countreacoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CountReacaoController{
    @Inject
    private ReacaoDAO reacaoDAO;
    
    @GET
    @Path("/{id}")
    public Long get(@PathParam("id") Long id){
        return reacaoDAO.countReacoes(id);
    }

    @GET
    @Path("/{id}/{reacao}")
    public Long get(@PathParam("id") Long id, @PathParam("reacao") String reacao){
        return reacaoDAO.countReacoes(id, reacao);
    }
}