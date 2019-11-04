package com.utfpr.facetruco.data;

import java.util.List;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.models.Loginho;
import com.utfpr.facetruco.models.Usuario;

public class UsuarioDAO {

    public void store (Usuario u){
        Connection.getConnection().getTransaction().begin();
        Connection.getConnection().persist(u);
        Connection.getConnection().getTransaction().commit();
    }

    public List<Usuario> listAll(){
        String sql = "select u from Usuario u";
        TypedQuery<Usuario> q = Connection.getConnection().createQuery(sql, Usuario.class);
        List<Usuario> usuarios = q.getResultList();
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

    public Usuario get(Loginho loguinho){
        String sql = "select u "+
                        "from Usuario u " +
                        "where u.email = :email and " +
                        "u.senha = :senha";
        TypedQuery<Usuario> query = Connection.getConnection().createQuery(sql, Usuario.class);
        query.setParameter("email",loguinho.getEmail());
        query.setParameter("senha",loguinho.getSenha());
        Usuario usuario = query.getSingleResult();

        return usuario;
    }

}