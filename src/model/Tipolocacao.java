/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "tipolocacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipolocacao.findAll", query = "SELECT t FROM Tipolocacao t"),
    @NamedQuery(name = "Tipolocacao.findByIdtipolocacao", query = "SELECT t FROM Tipolocacao t WHERE t.idtipolocacao = :idtipolocacao"),
    @NamedQuery(name = "Tipolocacao.findByTipo", query = "SELECT t FROM Tipolocacao t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tipolocacao.findByDescricao", query = "SELECT t FROM Tipolocacao t WHERE t.descricao = :descricao")})
public class Tipolocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipolocacao")
    private Integer idtipolocacao;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "descricao")
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipolocacao")
    private List<Locacao> locacaoList;

    public Tipolocacao() {
    }

    public Tipolocacao(Integer idtipolocacao) {
        this.idtipolocacao = idtipolocacao;
    }

    public Integer getIdtipolocacao() {
        return idtipolocacao;
    }

    public void setIdtipolocacao(Integer idtipolocacao) {
        this.idtipolocacao = idtipolocacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipolocacao != null ? idtipolocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipolocacao)) {
            return false;
        }
        Tipolocacao other = (Tipolocacao) object;
        if ((this.idtipolocacao == null && other.idtipolocacao != null) || (this.idtipolocacao != null && !this.idtipolocacao.equals(other.idtipolocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipolocacao[ idtipolocacao=" + idtipolocacao + " ]";
    }
    
}
