/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doo2.twitter.matheus.renan.persist;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author mdx67
 */
@Entity
@Table(name="MENSAGEM")
@SequenceGenerator(name = "seqMensagem", sequenceName = "SEQMENSAGEM", allocationSize = 1)
@NamedQuery(name="Mensagem.findAll", query="select o from Mensagem o")
public class Mensagem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seqMensagem")
    @Column(nullable = false)
    private Integer cod;
    @Column(nullable = false)
    private String descricao;
    @OneToOne
    private Usuario usuario;

    public Mensagem() {
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensagem other = (Mensagem) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    
}
