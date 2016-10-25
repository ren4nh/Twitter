/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.twitter.doo2.mng;

import doo2.twitter.matheus.renan.dao.UsuarioDAORemote;
import doo2.twitter.matheus.renan.persist.Usuario;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author mdx67
 */
@Named(value = "cadastroMNG")
@RequestScoped
public class CadastroMNG {

    public static final String USER_SESSION_KEY = "sessaocadastro";
    @EJB
    UsuarioDAORemote dao;
    private String nome;
    private String apelido;
    private String email;
    private String senha;
    private String senha2;

    public CadastroMNG() {
    }

    public UsuarioDAORemote getDao() {
        return dao;
    }

    public void setDao(UsuarioDAORemote dao) {
        this.dao = dao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    public String save() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (senha.equals(senha2)) {
            Usuario user = new Usuario();
            Usuario userTemp = new Usuario();
            userTemp = dao.findByEmail(email);
            if (userTemp == null) {
                user.setNome(getNome());
                user.setApelido(getApelido());
                user.setEmail(getEmail());
                user.setSenha(getSenha());
                dao.create(user);
                return "ok";
            } else {
                this.emailInvalid(context);
                return null;
            }
        } else {
            this.cadastroInvalid(context);
            return null;
        }
    }

    private void cadastroInvalid(FacesContext context) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem!", "Falha ao cadastrar.");
        context.addMessage(null, message);
    }

    private void emailInvalid(FacesContext context) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail ja cadastrado", "Falha ao cadastrar.");
        context.addMessage(null, message);
    }
}
