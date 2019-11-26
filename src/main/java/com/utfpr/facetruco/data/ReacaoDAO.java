package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Reacao;
import com.utfpr.facetruco.pojo.React;

public class ReacaoDAO{
    public void store(Reacao react){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(react);
        Connection.getConnection().getTransaction().commit();
    }

    public List<React> listAll(Long id){
        String sql = "SELECT new com.utfpr.facetruco.pojo.React " +
            "(r.postagem.id, r.reacao, r.usuario.username) " +
            "FROM Reacao r " +
            "WHERE r.postagem.id = :id";
    
        TypedQuery<React> query = Connection.getConnection().createQuery(sql, React.class);
        query.setParameter("id", id); 
        return query.getResultList();
    }

    public Reacao get(Long id){
        String sql = "SELECT r " +
            "FROM Reacao r " +
            "WHERE r.id = :id";
        TypedQuery<Reacao> query = Connection.getConnection().createQuery(sql, Reacao.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public void delete(Long id){
        Reacao reacao = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(reacao);
        Connection.getConnection().getTransaction().commit();
    }
    
}