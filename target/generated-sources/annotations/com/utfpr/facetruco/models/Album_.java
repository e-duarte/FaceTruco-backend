package com.utfpr.facetruco.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Album.class)
public abstract class Album_ {

	public static volatile SingularAttribute<Album, Date> data;
	public static volatile SingularAttribute<Album, String> titulo;
	public static volatile SingularAttribute<Album, Usuario> usuario;
	public static volatile SingularAttribute<Album, Long> id;
	public static volatile ListAttribute<Album, Usuario> colabs;
	public static volatile ListAttribute<Album, Comentario> comentarios;
	public static volatile ListAttribute<Album, Postagem> posts;
	public static volatile ListAttribute<Album, Reacao> reacoes;
	public static volatile SingularAttribute<Album, String> descricao;

}

