package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Solicitacao;
import com.utfpr.facetruco.pojo.Request;

public class SolicitacaoDAO{
    public void store (Solicitacao solicitacao){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(solicitacao);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Request> listAll(String username){
        String sql = "SELECT NEW com.utfpr.facetruco.pojo.Request" +
            "(s.id, s.usuario.username, s.usernameOrigem) "+
            "FROM Solicitacao s " +
            "WHERE s.usuario.username = :username";
        TypedQuery<Request> query = Connection.getConnection().createQuery(sql, Request.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    public Solicitacao get(Long id){
        String sql = "select s "+
                        "from Solicitacao s " +
                        "where s.id = :id";
        TypedQuery<Solicitacao> query = Connection.getConnection().createQuery(sql, Solicitacao.class);
        query.setParameter("id",id);
        Solicitacao usuario = query.getSingleResult();

        return usuario;
    }

    public void delete(Long id){
        Solicitacao s = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(s);
        Connection.getConnection().getTransaction().commit();
    }
}