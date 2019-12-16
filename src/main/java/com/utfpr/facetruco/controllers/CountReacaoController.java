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
    @Path("/{id}/{target}")
    public Long get(@PathParam("id") Long id, @PathParam("target") String target){
        return reacaoDAO.countReacoes(id, target);
    }

    @GET
    @Path("/{id}/{target}/{reacao}")
    public Long get(@PathParam("id") Long id, @PathParam("target") String target, @PathParam("reacao") String reacao){
        return reacaoDAO.countReacoes(id, target, reacao);
    }
}