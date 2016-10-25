package trabalho.twitter.doo2.mng;

import doo2.twitter.matheus.renan.dao.MensagemDAORemote;
import doo2.twitter.matheus.renan.dao.UsuarioDAORemote;
import doo2.twitter.matheus.renan.persist.Mensagem;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

/**
 *
 * @author mdx67
 */
@Named(value = "mensagensMNG")
@RequestScoped
public class MensagensMNG {

    @EJB
    MensagemDAORemote dao;
    @EJB
    UsuarioDAORemote userDAO;
    private String cod;
    @Pattern(regexp = "(.+)", message = "{invalid.mensagem.descricao}")
    private String descricao;
    private DataModel<Mensagem> mensagem;
    int c = 0;

    public MensagensMNG() {
    }

    public MensagemDAORemote getDao() {
        return dao;
    }

    public void setDao(MensagemDAORemote dao) {
        this.dao = dao;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Mensagem> getLista() {
        Usuario user = new Usuario();
        boolean ok = true;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioPerfil") != null) {
        ok = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioPerfil");
        }
        if (ok) {
         user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoUsuario");
        } else {
         user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoPerfil");    
        }
        List<Mensagem> lista = new ArrayList<Mensagem>();
        List<Mensagem> listaTemp = null;
        lista = dao.listaMsg(user);
        if (!user.getListaUsuario().isEmpty()) {
            for (Usuario usuario : user.getListaUsuario()) {
                listaTemp = dao.listaMsg(usuario);
                for (Mensagem mensagem1 : listaTemp) {
                    lista.add(mensagem1);
                }
            }
        }
        return lista;
    }

    public int getNumMensagem() {
        Usuario user = new Usuario();
        boolean ok = true;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfilUsuario") != null) {
        ok = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfilUsuario");
        }
        if (ok) {
         user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoUsuario");
        } else {
         user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoPerfil");    
        }
        List<Mensagem> lista = new ArrayList<Mensagem>();
        lista = dao.listaMsg(user);
        for (Mensagem mensagem1 : lista) {
            c++;
        }
        return c;
    }

    public String save() {
        Mensagem msg = new Mensagem();
        Usuario user = new Usuario();
        user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoUsuario");
        msg.setDescricao(descricao);
        msg.setUsuario(user);
        msg = dao.create(msg);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sessaoUsuario", userDAO.update(user));
        return "ok";
    }
    
    public List<Mensagem> getMsgPerfil(){
        Usuario user = new Usuario();
        boolean ok = true;
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfilUsuario") != null) {
        ok = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfilUsuario");
        }
        if (ok) {
         user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoUsuario");
        } else {
         user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoPerfil");    
        }
        return dao.listaMsg(user);
    }
}
