package com.utfpr.facetruco.controllers;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.utfpr.facetruco.models.Usuario;


@Path("/usuario")
public class UsuarioController{
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario list(){
        Usuario u = new Usuario();
        u.setNome("João");
        u.setSobrenome("Souza");
        u.setEmail("@");
        u.setSenha("senha");
        u.setData_nascimento(new Date("1998/04/17"));
        u.setFoto_perfil("foto_perfil");
        u.setFoto_timeline("foto_timeline");
        u.setGenero("genero");
        return u;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario store(){
       
        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager m = f.createEntityManager();
/* 
        Usuario u = new Usuario();
        u.setNome("João");
        u.setSobrenome("Souza");
        u.setEmail("@");
        u.setSenha("senha");
        u.setData_nascimento(new Date("1998/04/17"));
        u.setFoto_perfil("foto_perfil");
        u.setFoto_timeline("foto_timeline");
        u.setGenero("genero");

        Comentario c = new Comentario();
        c.setComentario("comentario");
        c.setData(new Date("1998/04/17"));

        Postagem p = new Postagem();
        p.setLegenda("legenda");
        p.setSentimento("sentimento");
        p.setData(new Date("1998/04/17"));

        p.setUsuario(u);
        List<Comentario> cs = new ArrayList<Comentario>();
        cs.add(c);
        p.setComentarios(cs);

        m.getTransaction().begin();
        m.persist(u);
        m.persist(c);
        m.persist(p);
        m.getTransaction().commit(); */
        
        m.close();
        f.close();

        return null;
    }
}