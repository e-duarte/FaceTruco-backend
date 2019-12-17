package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Usuario;
import com.utfpr.facetruco.pojo.User;

public class UsuarioDAO {
    public void store (Usuario u){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(u);
        Connection.getConnection().getTransaction().commit();
    }

    public List<User> listAll(){
        String sql = "select NEW com.utfpr.facetruco.pojo.User" +
            "(u.id,  u.nome, u.sobrenome, u.email, " +
            "u.username, u.fotoPerfil, " +
            "u.fotoTimeline) " +
            "from Usuario u";
        TypedQuery<User> query = Connection.getConnection().createQuery(sql, User.class);
        return query.getResultList();
    }

    public Usuario get(String username){
        String sql = "SELECT u "+
            "FROM Usuario u " +
            "WHERE u.username = :username";
            
        TypedQuery<Usuario> query = Connection.getConnection().createQuery(sql, Usuario.class);
        query.setParameter("username",username);
        Usuario usuario = query.getSingleResult();

        return usuario;
    }

    public void delete(String username){
        Usuario user = get(username);
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().remove(user);
        Connection.getConnection().getTransaction().commit();
    }

}