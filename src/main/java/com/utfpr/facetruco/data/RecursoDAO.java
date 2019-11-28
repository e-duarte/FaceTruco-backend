package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Recurso;
import com.utfpr.facetruco.pojo.Resource;

public class RecursoDAO{
    public void store(Recurso recurso){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(recurso);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Resource> listPost(Long id){
        String sql = "SELECT NEW com.utfpr.facetruco.pojo.Resource " +
            "(r.id, r.postagem.id, r.usuario.username, r.url, r.tipo) " +
            "FROM Recurso r " +
            "WHERE r.postagem.id = :id";

        TypedQuery<Resource> query = Connection.getConnection().createQuery(sql, Resource.class);
        query.setParameter("id", id);
        return query.getResultList();
    }


    public Recurso get(Long id){
        String sql = "SELECT r "+
            "FROM Recurso r " +
            "WHERE r.id = :id";
        TypedQuery<Recurso> query = Connection.getConnection().createQuery(sql, Recurso.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public void delete(Long id){
        Recurso resource = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(resource);
        Connection.getConnection().getTransaction().commit();
    }

}