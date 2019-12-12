package com.utfpr.facetruco.controllers;

import java.util.ArrayList;
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

import com.utfpr.facetruco.data.AlbumDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Album;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.AlbumPojo;

@Path("/albuns")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlbumController{
    @Inject
    public AlbumDAO albumDAO;

    @POST
    public Response store(AlbumPojo albumPojo){
        Album album = new Album();
        List<Usuario> users = new ArrayList<>();
        
        if(albumPojo.getColabs() == null)
            albumPojo.setColabs(new ArrayList<String>());

        album.setTitulo(albumPojo.getTitulo());
        album.setDescricao(albumPojo.getDescricao());
        album.setUsuario(new UsuarioDAO().get(albumPojo.getUsuario()));
        for (String user : albumPojo.getColabs()) 
            users.add(new UsuarioDAO().get(user));
        album.setColabs(users);

        albumDAO.store(album);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{username}")
    public List<AlbumPojo> list(@PathParam("username") String username){
        return this.albumDAO.listAll(username);
    }

    @DELETE
    @Path("/{albumId}")
    public Response delete(@PathParam("albumId")Long albumId){
        albumDAO.delete(albumId);
        return Response.status(Response.Status.OK).build();
    }
}