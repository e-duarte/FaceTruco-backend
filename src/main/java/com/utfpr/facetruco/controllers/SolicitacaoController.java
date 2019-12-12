package com.utfpr.facetruco.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.SolicitacaoDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Solicitacao;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.Request;

@Path("solicitacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SolicitacaoController{
    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private SolicitacaoDAO solicitacaoDAO;

    @POST
    public Response store(Request request){
        Usuario userTarget = usuarioDAO.get(request.getTarget());
        Usuario userLogged = usuarioDAO.get(request.getOrigin());

        Solicitacao s = new Solicitacao();
        s.setVisualizada(false);
        s.setUsernameOrigem(request.getOrigin());
        s.setUsuario(userTarget);
        solicitacaoDAO.store(s);

        List<String> soliLogged = userLogged.getSolicitacoesEnviadas();
        if(soliLogged == null)
            soliLogged = new ArrayList<>();

        soliLogged.add(request.getTarget());
        usuarioDAO.store(userLogged);

        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/{username}")
    public List<Request> list(@PathParam("username") String username){
        return this.solicitacaoDAO.listAll(username);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id){
        Solicitacao s = solicitacaoDAO.get(id);
        s.setVisualizada(true);
        solicitacaoDAO.store(s);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.solicitacaoDAO.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}