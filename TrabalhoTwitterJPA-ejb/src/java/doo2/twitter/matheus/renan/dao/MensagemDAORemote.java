package doo2.twitter.matheus.renan.dao;

import doo2.twitter.matheus.renan.persist.Mensagem;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mdx67
 */
@Remote
public interface MensagemDAORemote {

    Mensagem create(Mensagem value);

    Mensagem retrieve(Mensagem value);

    void update(Mensagem value);

    void delete(Mensagem value);

    boolean valida(Mensagem value);
    
    List<Mensagem> listaMsg(Usuario usuario);
}
