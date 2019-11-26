package com.utfpr.facetruco.data;

import javax.persistence.TypedQuery;

import com.utfpr.facetruco.pojo.Loginho;
import com.utfpr.facetruco.models.Usuario;

public class LoginDAO{
    public Usuario get(Loginho loguinho){
        String sql = "select u "+
                        "from Usuario u " +
                        "where u.email = :email and " +
                        "u.senha = :senha";
        TypedQuery<Usuario> query = Connection.getConnection().createQuery(sql, Usuario.class);
        query.setParameter("email",loguinho.getEmail());
        query.setParameter("senha",loguinho.getPassword());
        Usuario usuario = query.getSingleResult();

        return usuario;
    }
}