package doo2.twitter.matheus.renan.persist;

import doo2.twitter.matheus.renan.persist.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-25T15:04:31")
@StaticMetamodel(Mensagem.class)
public class Mensagem_ { 

    public static volatile SingularAttribute<Mensagem, Integer> cod;
    public static volatile SingularAttribute<Mensagem, Usuario> usuario;
    public static volatile SingularAttribute<Mensagem, String> descricao;

}