    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.twitter.doo2.mng;

import doo2.twitter.matheus.renan.dao.UsuarioDAORemote;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mdx67
 */
@Named(value = "principalMNG")
@SessionScoped
public class PrincipalMNG implements Serializable {

    private String busca;
    @EJB
    UsuarioDAORemote userDAO;
    private Usuario usuario;

    public PrincipalMNG() {
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUser() {
        return usuario;
    }

    public void setUser(Usuario user) {
        this.usuario = user;
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "sair";
    }

    public String buscar() {
        usuario = userDAO.findByApelido(busca);
        if (usuario == null) {
            return "erro";
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessaoPerfil", usuario);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("perfilUsuario", false);
        return "perfil";
    }

    public String carregaPerfil() {
        usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoUsuario");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("perfilUsuario", true);
        return "perfil";
    }

    public String home() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("perfilUsuario", true);
        return "home";
    }
}
