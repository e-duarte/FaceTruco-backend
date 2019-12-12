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

import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.Request;


@Path("/amigos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AmigoController{
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @POST
    public Response store(Request request){
        Usuario userLogged = usuarioDAO.get(request.getOrigin());
        Usuario newFriend = usuarioDAO.get(request.getTarget());
        List<Usuario> friends = userLogged.getAmigos();
        List<String> sEnviadas = userLogged.getSolicitacoesEnviadas();

        if(friends == null) friends = new ArrayList<>();
        if(sEnviadas == null) sEnviadas = new ArrayList<>();

        friends.add(newFriend);
        sEnviadas.remove(newFriend.getUsername());
        usuarioDAO.store(userLogged);                
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{username}")
    public List<Usuario> store(@PathParam("username") String username){
        Usuario userLogged = usuarioDAO.get(username);
        return userLogged.getAmigos();
    }
    
    @DELETE
    @Path("/{logged}/{target}")
    public Response delete(@PathParam("logged")String logged, @PathParam("target")String target){
        Usuario userLogged = usuarioDAO.get(logged);
        List<Usuario> friends = userLogged.getAmigos();
        Usuario utarget = null;
        for (Usuario usuario : friends) {
            if(usuario.getUsername().equals(target)){
                utarget = usuario;
            }
        }

        friends.remove(utarget);
        userLogged.setAmigos(friends);
        usuarioDAO.store(userLogged);
        return Response.status(Response.Status.OK).build();
    }
}