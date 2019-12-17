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

import com.utfpr.facetruco.data.SolicitacaoDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.AmigoPojo;
import com.utfpr.facetruco.pojo.Request;


@Path("/amigos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AmigoController{
    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private SolicitacaoDAO solicitacaoDAO;
    
    @POST
    public Response store(Request request){
        Usuario userLogged = usuarioDAO.get(request.getOrigin());
        Usuario userTarget = usuarioDAO.get(request.getTarget());

        List<Usuario> friendsLogged = userLogged.getAmigos();
        List<Usuario> friendsTarget = userTarget.getAmigos();
        List<String> sEnviadasTarget = userLogged.getSolicitacoesEnviadas();
        
        if(friendsLogged == null) friendsLogged = new ArrayList<>();
        if(friendsTarget == null) friendsTarget = new ArrayList<>();
        if(sEnviadasTarget == null) sEnviadasTarget = new ArrayList<>();

        friendsLogged.add(userTarget);
        friendsTarget.add(userLogged);

        sEnviadasTarget.remove(userLogged.getUsername());
        solicitacaoDAO.delete(solicitacaoDAO.get(request.getTarget(), request.getOrigin()).getId());
        usuarioDAO.store(userLogged);    
        usuarioDAO.store(userTarget);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{username}")
    public AmigoPojo list(@PathParam("username") String username){
        Usuario userLogged = usuarioDAO.get(username);
        AmigoPojo amigos = new AmigoPojo();
        amigos.setAmigos(new ArrayList<String>());
        for (Usuario user : userLogged.getAmigos()) amigos.getAmigos().add(user.getUsername());
        amigos.setUsername(username);
        return amigos;
        // return null;
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