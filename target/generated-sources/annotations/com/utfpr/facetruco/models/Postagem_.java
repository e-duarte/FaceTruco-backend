package com.utfpr.facetruco.models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Postagem.class)
public abstract class Postagem_ {

	public static volatile SingularAttribute<Postagem, String> legenda;
	public static volatile SingularAttribute<Postagem, Date> data;
	public static volatile SingularAttribute<Postagem, Usuario> usuario;
	public static volatile SingularAttribute<Postagem, Long> id;
	public static volatile SingularAttribute<Postagem, String> sentimento;

}

