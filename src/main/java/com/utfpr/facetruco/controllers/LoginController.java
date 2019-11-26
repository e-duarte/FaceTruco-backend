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
import com.utfpr.facetruco.pojo.Loginho;
import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.UserLogged;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController{
    private LoginDAO loginDAO;

    public LoginController(){
        loginDAO = new LoginDAO();
    }

    @GET
    @Path("/me")
    public UserLogged me(@Context HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader(JWTUtil.TOKEN_HEADER);
        Jws<Claims> jws = JWTUtil.decode(token);
        UserLogged me = new UserLogged();
        me.setUsername(jws.getBody().getSubject());
        return me;
    }

    @POST
    @Path("/login")
    public Response login(Loginho loguinho){
        Usuario user = loginDAO.get(loguinho);
        if(user != null){
            String token = JWTUtil.create(user.getUsername());
            UserLogged me = new UserLogged();
            me.setUsername(user.getUsername());
            me.setToken(token);
            return Response.ok().entity(me).build();
        }else{  
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}