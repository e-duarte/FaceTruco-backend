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

import com.utfpr.facetruco.data.PostagemDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Postagem;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.MarcadoPojo;

@Path("/marcados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcadosController{
    @Inject
    private PostagemDAO postagemDAO;

    @POST
    public Response store(MarcadoPojo mp){
        Postagem post = postagemDAO.get(mp.getPostId());
        
        if(post.getMarcados() == null)
            post.setMarcados(new ArrayList<Usuario>());
        for (String username : mp.getUsuarios())
            post.getMarcados().add(new UsuarioDAO().get(username));
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{id}")
    public MarcadoPojo list(@PathParam("id") Long id){
        List<Usuario> marcados = this.postagemDAO.get(id).getMarcados();
        List<String> marcadosList = new ArrayList<>();
        for (Usuario usuario : marcados) 
            marcadosList.add(usuario.getUsername());
        return new MarcadoPojo(id, marcadosList);
    }
}