package doo2.twitter.matheus.renan.dao;

import doo2.twitter.matheus.renan.persist.Mensagem;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mdx67
 */
@Stateless
public class MensagemDAO implements MensagemDAORemote {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Mensagem create(Mensagem value) {
        if (this.valida(value)) {
            em.persist(value);
            return value;
        } else {
            return null;
        }
    }

    @Override
    public Mensagem retrieve(Mensagem value) {
        Mensagem valueRet = em.find(Mensagem.class, value.getCod());
        return valueRet;
    }

    @Override
    public void update(Mensagem value) {
        if (this.valida(value)) {
            em.merge(value);
        }
    }

    @Override
    public void delete(Mensagem value) {
        value = this.retrieve(value);
        em.remove(value);
    }

    @Override
    public boolean valida(Mensagem value) {
        boolean ret = false;
        if (value != null) {
            ret = true;
        }
        return ret;
    }
    
    @Override
    public List<Mensagem> listaMsg(Usuario usuario){
        Query q = em.createQuery("select o from Mensagem o where o.usuario =:usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }
}
