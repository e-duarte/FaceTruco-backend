package com.utfpr.facetruco.data;

import java.rmi.ConnectIOException;
import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Usuario;

/**
 * @author vitor
 */

public class UsuarioDAO {

    public void store (Usuario u){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(u);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Usuario> listAll(){
        // String sql = "select u from Usuario u";
        // TypedQuery<Usuario> q = Connection.getConnection().createQuery(sql, Usuario.class);
        // List<Usuario> usuarios = q.getResultList();
         Connection.getConnection().close();
        return usuarios;
    }

    public Usuario get(String email){
        String sql = "select u "+
                        "from Usuario u " +
                        "where u.email = :email";
        TypedQuery<Usuario> query = Connection.getConnection().createQuery(sql, Usuario.class);
        query.setParameter("email",email);
        Usuario usuario = query.getSingleResult();

        return usuario;
    }

}