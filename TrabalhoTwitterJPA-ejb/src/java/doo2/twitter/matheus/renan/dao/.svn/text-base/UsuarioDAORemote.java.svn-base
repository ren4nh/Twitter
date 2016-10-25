package doo2.twitter.matheus.renan.dao;

import doo2.twitter.matheus.renan.persist.Usuario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author mdx67
 */
@Remote
public interface UsuarioDAORemote {

    Usuario create(Usuario value);

    Usuario retrive(Usuario value);

    Usuario update(Usuario value);

    void delete(Usuario value);

    Usuario findByEmail(String email);
    
    List<Usuario> listaTodos();

    boolean valida(Usuario value);

    Usuario findByApelido(String apelido);
}
