package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.data.ReacaoDAO;
import com.utfpr.facetruco.pojo.React;

@Path("/reaclists")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReacaoListController{
    @Inject
    private ReacaoDAO reactDAO;

    @GET
    @Path("/{id}/{target}")
    public List<React> list(@PathParam("id") Long id, @PathParam("target") String target){
        return this.reactDAO.listAll(id, target);
    }
}