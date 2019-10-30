package com.utfpr.facetruco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utfpr.facetruco.models.Postagem;
import com.utfpr.facetruco.models.Usuario;

public class Servlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        EntityManagerFactory f = Persistence.createEntityManagerFactory("teste");
        EntityManager m = f.createEntityManager();

        Usuario u = new Usuario();
        u.setNome("João");
        u.setSobrenome("Souza");
        u.setEmail("@");
        u.setSenha("senha");
        u.setData_nascimento(new Date("1998/04/17"));
        u.setFoto_perfil("foto_perfil");
        u.setFoto_timeline("foto_timeline");
        Postagem p = new Postagem();
        p.setLegenda("legenda");
        p.setSentimento("sentimento");
        p.setData(new Date("1998/04/17"));

        p.setUsuario(u);

        m.getTransaction().begin();
        m.persist(u);
        m.persist(p);
        m.getTransaction().commit();
        
        m.close();
        f.close();
        
        out.println("Estou Observando...");
    }
}