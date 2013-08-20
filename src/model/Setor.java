/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "setor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setor.findAll", query = "SELECT s FROM Setor s"),
    @NamedQuery(name = "Setor.findByIdsetor", query = "SELECT s FROM Setor s WHERE s.idsetor = :idsetor"),
    @NamedQuery(name = "Setor.findByNome", query = "SELECT s FROM Setor s WHERE s.nome = :nome")})
public class Setor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsetor")
    private Integer idsetor;
    
    @Column(name = "nome")
    private String nome;
    
    @ManyToMany(mappedBy = "setorList")
    private List<Funcionario> funcionarioList;

    public Setor() {
    }

    public Setor(Integer idsetor) {
        this.idsetor = idsetor;
    }

    public Integer getIdsetor() {
        return idsetor;
    }

    public void setIdsetor(Integer idsetor) {
        this.idsetor = idsetor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsetor != null ? idsetor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.idsetor == null && other.idsetor != null) || (this.idsetor != null && !this.idsetor.equals(other.idsetor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Setor[ idsetor=" + idsetor + " ]";
    }
    
}
