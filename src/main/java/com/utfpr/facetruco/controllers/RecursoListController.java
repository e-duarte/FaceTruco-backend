package com.utfpr.facetruco.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.data.RecursoDAO;
import com.utfpr.facetruco.pojo.Resource;

@Path("/reclists")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecursoListController{
    @Inject
    private RecursoDAO recursoDAO;

    @GET
    @Path("/{id}/{target}")
    public List<Resource> list(@PathParam("id") Long id, @PathParam("target") String target){
        return recursoDAO.listPost(id, target);
    }
    
}