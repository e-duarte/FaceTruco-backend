package com.utfpr.facetruco.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Loginho;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.models.UsuarioLogado;
import com.utfpr.facetruco.security.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController{
    private UsuarioDAO usuarioDAO;

    public LoginController(){
        usuarioDAO = new UsuarioDAO();
    }

    @GET
    @Path("/me")
    public UsuarioLogado me(@Context HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader(JWTUtil.TOKEN_HEADER);
        Jws<Claims> jws = JWTUtil.decode(token);
        UsuarioLogado me = new UsuarioLogado();
        me.setEmail(jws.getBody().getSubject());
        return me;
    }

    @POST
    @Path("/login")
    public Response login(Loginho loguinho){
        Usuario u = usuarioDAO.get(loguinho);
        if(u != null){
            String token = JWTUtil.create(loguinho.getEmail());
            UsuarioLogado me = new UsuarioLogado();
            me.setEmail(loguinho.getEmail());
            me.setToken(token);
            return Response.ok().entity(me).build();
        }else{  
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}