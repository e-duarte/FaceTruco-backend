package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Usuario;

public class UsuarioDAO {
    public void store (Usuario u){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(u);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Usuario> listAll(){
        String sql = "select u from Usuario u";
        TypedQuery<Usuario> query = Connection.getConnection().createQuery(sql, Usuario.class);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }

    public Usuario get(String username){
        String sql = "select u "+
                        "from Usuario u " +
                        "where u.username = :username";
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