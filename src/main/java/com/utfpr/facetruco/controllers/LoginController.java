package com.utfpr.facetruco.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;
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
public class LoginController {
    @Inject
    private LoginDAO loginDAO;

    @POST
    @Path("/login")
    public Response login(final Loginho loguinho) {
        final Usuario user = loginDAO.get(loguinho);
        if (user != null) {
            final String token = JWTUtil.create(user.getUsername());
            final UserLogged me = new UserLogged();
            me.setUsername(user.getUsername());
            me.setToken(token);
            return Response.ok().entity(me).build();
        }else{  
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}