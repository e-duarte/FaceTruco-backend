package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Postagem;
import com.utfpr.facetruco.pojo.Post;

public class PostagemDAO{
    public void store(Postagem post){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(post);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Post> listAll(String username){
        String sql = "SELECT " + 
            "new com.utfpr.facetruco.pojo.Post " +
            "(p.id, p.legenda, p.sentimento, p.usuario.username) " +
            "FROM Postagem p " +
            "WHERE p.usuario.username = :username";

        TypedQuery<Post> query = Connection.getConnection().createQuery(sql, Post.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    public Postagem get(Long id){
        String sql = "select p "+
                        "from Postagem p " +
                        "where p.id = :id";
        TypedQuery<Postagem> query = Connection.getConnection().createQuery(sql, Postagem.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public void delete(Long id){
        Postagem post = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(post);
        Connection.getConnection().getTransaction().commit();
    }
}