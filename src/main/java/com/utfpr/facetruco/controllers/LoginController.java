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


import com.utfpr.facetruco.util.JWTUtil;
import com.utfpr.facetruco.data.LoginDAO;
import com.utfpr.facetruco.data.UsuarioDAO;
import com.utfpr.facetruco.models.Loginho;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.models.UsuarioLogado;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController{
    private LoginDAO loginDAO;
    private UsuarioDAO usuarioDAO;

    public LoginController(){
        loginDAO = new LoginDAO();
    }

    @GET
    @Path("/me")
    public UsuarioLogado me(@Context HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader(JWTUtil.TOKEN_HEADER);
        Jws<Claims> jws = JWTUtil.decode(token);
        UsuarioLogado me = new UsuarioLogado();
        me.setUsername(jws.getBody().getSubject());
        return me;
    }

    @POST
    @Path("/login")
    public Response login(Loginho loguinho){
        Usuario user = loginDAO.get(loguinho);
        if(user != null){
            String token = JWTUtil.create(user.getUsername());
            UsuarioLogado me = new UsuarioLogado();
            me.setUsername(user.getUsername());
            me.setToken(token);
            return Response.ok().entity(me).build();
        }else{  
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}