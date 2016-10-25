package trabalho.twitter.doo2.mng;

import doo2.twitter.matheus.renan.dao.UsuarioDAORemote;
import doo2.twitter.matheus.renan.persist.Mensagem;
import doo2.twitter.matheus.renan.persist.Usuario;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.inject.Named;

/**
 *
 * @author mdx67
 */
@Named(value = "usuarioMNG")
@RequestScoped
public class UsuarioMNG {

    public static final String USER_SESSION_KEY = "sessaoUsuario";
    public static final String PERFIL_SESSION = "sessaoperfil";
    @EJB
    UsuarioDAORemote dao;
    private String nome;
    private String email;
    private String senha;
    int c = 0;

    public UsuarioMNG() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getLista() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessaoUsuario");
        user = dao.retrive(user);
        return user.getListaUsuario();
    }

    public int getNumUsuarios() {
        for (Usuario usr : getLista()) {
            c++;
        }
        return c;
    }

    public String valida() {
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usuario = dao.findByEmail(email);
        if (usuario != null) {
            if (!usuario.getSenha().equals(senha)) {
                this.msgInvalidEmail(context);
                return null;
            }
            context.getExternalContext().getSessionMap().put("sessaoUsuario", usuario);
            return "ok";
        } else {
            this.msgInvalidEmail(context);
            return null;
        }
    }

    private void msgInvalidEmail(FacesContext context) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha na autenticação!", "E-mail ou senha inválidos");
        context.addMessage(null, message);
    }
}
