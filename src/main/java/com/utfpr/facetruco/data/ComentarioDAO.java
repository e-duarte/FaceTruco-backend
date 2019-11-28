package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Comentario;
import com.utfpr.facetruco.pojo.Comment;

public class ComentarioDAO{
    public void store(Comentario comment){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(comment);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Comment> listAll(Long id){
        String sql = "SELECT new com.utfpr.facetruco.pojo.Comment " +
            "(c.id, c.postagem.id, c.comentario, c.usuario.username) " +
            "FROM Comentario c " +
            "WHERE c.postagem.id = :id";
    
        TypedQuery<Comment> query = Connection.getConnection().createQuery(sql, Comment.class);
        query.setParameter("id", id); 
        return query.getResultList();
    }

    public Comentario get(Long id){
        String sql = "SELECT c "+
            "FROM Comentario c " +
            "WHERE c.id = :id";
        TypedQuery<Comentario> query = Connection.getConnection().createQuery(sql, Comentario.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public void delete(Long id){
        Comentario comment = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(comment);
        Connection.getConnection().getTransaction().commit();
    }

    public Long countComentarios(Long id){
        String sql = "SELECT COUNT(c)" +
            "FROM Comentario c " +
            "WHERE c.postagem.id = :id";
    
        TypedQuery<Long> query = Connection.getConnection().createQuery(sql, Long.class);
        query.setParameter("id", id); 
        return query.getSingleResult();
    }
}