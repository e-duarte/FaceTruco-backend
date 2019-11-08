package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Postagem;

public class PostagemDAO{
    public void store(Postagem post){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(post);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Postagem> listAll(){
        String sql = "select p from Postagem u";
        TypedQuery<Postagem> q = Connection.getConnection().createQuery(sql, Postagem.class);
        List<Postagem> usuarios = q.getResultList();
        return usuarios;
    }

    public Postagem get(Long id){
        String sql = "select p "+
                        "from Postagem p " +
                        "where u.id = :id";
        TypedQuery<Postagem> query = Connection.getConnection().createQuery(sql, Postagem.class);
        query.setParameter("id",id);
        Postagem post = query.getSingleResult();
        return post;
    }

    public void delete(Long id){
        Postagem post = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(post);
        Connection.getConnection().getTransaction().commit();
    }
}