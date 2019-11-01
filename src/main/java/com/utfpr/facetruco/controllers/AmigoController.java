package com.utfpr.facetruco.controllers;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.models.Usuario;


@Path("/amigo")
public class AmigoController{
    EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
    EntityManager m = f.createEntityManager();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuario(){
        TypedQuery<Usuario> q = m.createQuery("SELECT u from Usuario u", Usuario.class);
        List<Usuario> usuarios = q.getResultList();
       return usuarios;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void store(Usuario usuario){
        m.getTransaction().begin();
        m.persist(usuario);
        m.getTransaction().commit();
    }
}