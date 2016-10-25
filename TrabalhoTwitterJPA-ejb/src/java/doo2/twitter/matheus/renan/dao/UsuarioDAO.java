package doo2.twitter.matheus.renan.dao;

import doo2.twitter.matheus.renan.persist.Mensagem;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mdx67
 */
@Stateless
public class UsuarioDAO implements UsuarioDAORemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario findByEmail(String email) {
        Query query = em.createQuery("Select o from Usuario o where o.email = :email");
        try {
            Usuario usuario = (Usuario) query.setParameter("email", email).getSingleResult();
            return usuario;
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Usuario create(Usuario value) {
        if (this.valida(value)) {
            em.persist(value);
            return value;
        } else {
            return null;
        }
    }

    @Override
    public Usuario retrive(Usuario value) {
        Usuario ret = em.find(Usuario.class, value.getCod());
        return ret;
    }

    @Override
    public Usuario update(Usuario value) {
        if (this.valida(value)) {
            em.merge(value);
            return value;
        } else{
            return null;
        } 
            
        
    }

    @Override
    public void delete(Usuario value) {
        value = this.retrive(value);
        em.remove(value);
    }

    @Override
    public boolean valida(Usuario value) {
        boolean ret = false;
        if (value != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public List<Usuario> listaTodos() {
        return (List<Usuario>) em.createNamedQuery("buscaSeguidores").getResultList();
    }

    @Override
    public Usuario findByApelido(String apelido) {
        Query query = em.createQuery("Select o from Usuario o where o.apelido = :apelido");
        try {
            Usuario usuario = (Usuario) query.setParameter("apelido", apelido).getSingleResult();
            return usuario;
        } catch (NoResultException nre) {
            return null;
        }
    }
}
