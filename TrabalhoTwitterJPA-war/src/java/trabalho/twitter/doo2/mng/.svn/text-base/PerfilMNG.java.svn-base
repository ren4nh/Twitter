package trabalho.twitter.doo2.mng;

import doo2.twitter.matheus.renan.dao.UsuarioDAORemote;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author mdx67
 */
@Named(value = "perfilMNG")
@SessionScoped
public class PerfilMNG implements Serializable {

    @EJB
    UsuarioDAORemote dao;
    private Usuario user;
    private Usuario usuario;
    private boolean ativa;

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean isAtiva() {
        isTestaSeguir();
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getNumSeguindo() {
        int count = 0;
        FacesContext context = FacesContext.getCurrentInstance();
        boolean ok = (Boolean) context.getExternalContext().getSessionMap().get("perfilUsuario");
        if (ok) {
            usuario = (Usuario) context.getExternalContext().getSessionMap().get("sessaoUsuario");
        } else {
            usuario = (Usuario) context.getExternalContext().getSessionMap().get("sessaoPerfil");
        }
        usuario = dao.retrive(usuario);
        for (Usuario usuario1 : usuario.getListaUsuario()) {
            count++;
        }
        return count;                                       
    }   

    public boolean isTestaSeguir() {
        boolean ok = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfilUsuario");
        if (ok) {
            ativa = false;
            return false;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        user = (Usuario) context.getExternalContext().getSessionMap().get("sessaoUsuario");
        if (user == null) {
            return false;
        }
        usuario = (Usuario) context.getExternalContext().getSessionMap().get("sessaoPerfil");
        if (user.getListaUsuario().contains(usuario)) {
            ativa = true;
            return false;
        }
        ativa = false;
        return true;
    }

    public void seguir() {
        user.getListaUsuario().add(usuario);
        dao.update(user);
        isAtiva();
        getNumSeguindo();
    }

    public void deixarSeguir() {
        user.getListaUsuario().remove(usuario);
        dao.update(user);
        isAtiva();
    }
}
