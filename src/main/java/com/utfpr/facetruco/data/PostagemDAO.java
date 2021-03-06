package com.utfpr.facetruco.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Postagem;
import com.utfpr.facetruco.models.Usuario;
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
            "(p.id, p.album.id, p.legenda, p.sentimento, p.usuario.username, p.timestamp) " +
            "FROM Postagem p " +
            "WHERE p.usuario.username = :username and p.album IS NULL";

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

    public List<Post> listall(Long albumId){
        String sql = "SELECT " + 
            "NEW com.utfpr.facetruco.pojo.Post " +
            "(p.id, p.album.id, p.legenda, p.sentimento, p.usuario.username, p.timestamp) " +
            "FROM Postagem p " +
            "WHERE p.album.id = :albumId";
        TypedQuery<Post> query = Connection.getConnection().createQuery(sql, Post.class);
        query.setParameter("albumId", albumId);
        return query.getResultList();
    }

    public List<Post> listPostAmigosUsuario(Usuario user){
        List<Usuario> users = user.getAmigos();
        if(users == null) users = new ArrayList<>();
        users.add(user);

        String sql = "SELECT NEW com.utfpr.facetruco.pojo.Post" + 
            "(p.id, p.album.id, p.legenda, p.sentimento, p.usuario.username, p.timestamp) " +
            "FROM Postagem p, Usuario u " +
            "WHERE p.usuario IN :users AND u.username = :username " +
            "ORDER BY p.timestamp DESC";
        TypedQuery<Post> query = Connection.getConnection().createQuery(sql, Post.class);
        query.setParameter("users", user.getAmigos());
        query.setParameter("username", user.getUsername());
        return query.getResultList();
    }
}