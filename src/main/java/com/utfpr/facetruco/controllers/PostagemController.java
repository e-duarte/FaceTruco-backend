package com.utfpr.facetruco.controllers;

import java.util.ArrayList;
import java.util.List;

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
import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Postagem;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.Post;

@Path("/postagens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostagemController {
    @Inject
    private PostagemDAO postagemDAO;
    
    @POST
    public Response store(Post post){
        Postagem postagem = new Postagem();
        List<Usuario> users = new ArrayList<>();

        if(post.getMarcados() == null)
            post.setMarcados(new ArrayList<String>());

        if(post.getAlbumId() != null)
            postagem.setAlbum(new AlbumDAO().get(post.getAlbumId()));
        postagem.setUsuario(new UsuarioDAO().get(post.getUsername()));
        postagem.setLegenda(post.getLegenda());
        postagem.setSentimento(post.getSentimento());
        for (String user : post.getMarcados()) 
            users.add(new UsuarioDAO().get(user));
        postagem.setMarcados(users);

        this.postagemDAO.store(postagem);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.postagemDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}