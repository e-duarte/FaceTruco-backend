package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;
import com.utfpr.facetruco.models.Album;
import com.utfpr.facetruco.pojo.AlbumPojo;

public class AlbumDAO{
    public void store(Album album){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(album);
        Connection.getConnection().getTransaction().commit();
    }

    public List<AlbumPojo> listAll(String username){
        String sql = "SELECT " + 
            "NEW com.utfpr.facetruco.pojo.AlbumPojo " +
            "(a.id, a.titulo, a.descricao, a.usuario.username) " +
            "FROM Album a " +
            "WHERE a.usuario.username = :username";

        TypedQuery<AlbumPojo> query = Connection.getConnection().createQuery(sql, AlbumPojo.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    public Album get(Long id){
        String sql = "select a "+
            "from Album a " +
            "where a.id = :id";
            
        TypedQuery<Album> query = Connection.getConnection().createQuery(sql, Album.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    public void delete(Long id){
        Album album = get(id);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(album);
        Connection.getConnection().getTransaction().commit();
    }
}