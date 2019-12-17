package com.utfpr.facetruco.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.AlbumDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Album;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.ColaboradorPojo;

@Path("/colabs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ColaboradoresController{
    @Inject
    private AlbumDAO albumDAO;

    @POST
    public Response store(ColaboradorPojo colab){
        Album album = albumDAO.get(colab.getAlbumId());

        if(album.getColabs() == null)
            album.setColabs(new ArrayList<Usuario>());
        for (String users : colab.getColabs())
            album.getColabs().add(new UsuarioDAO().get(users));
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public ColaboradorPojo list(@PathParam("id") Long id){
        List<Usuario> marcados = this.albumDAO.get(id).getColabs();
        List<String> colabs = new ArrayList<>();
        for (Usuario usuario : marcados) 
            colabs.add(usuario.getUsername());
        return new ColaboradorPojo(id, colabs);
    }
}