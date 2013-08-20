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
@Table(name = "combustivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combustivel.findAll", query = "SELECT c FROM Combustivel c"),
    @NamedQuery(name = "Combustivel.findByIdcombustivel", query = "SELECT c FROM Combustivel c WHERE c.idcombustivel = :idcombustivel"),
    @NamedQuery(name = "Combustivel.findByNome", query = "SELECT c FROM Combustivel c WHERE c.nome = :nome")})
public class Combustivel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcombustivel")
    private Integer idcombustivel;
    
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "combustivel")
    private List<Veiculo> veiculoList;

    public Combustivel() {
    }

    public Combustivel(Integer idcombustivel) {
        this.idcombustivel = idcombustivel;
    }

    public Integer getIdcombustivel() {
        return idcombustivel;
    }

    public void setIdcombustivel(Integer idcombustivel) {
        this.idcombustivel = idcombustivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Veiculo> getVeiculoList() {
        return veiculoList;
    }

    public void setVeiculoList(List<Veiculo> veiculoList) {
        this.veiculoList = veiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcombustivel != null ? idcombustivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combustivel)) {
            return false;
        }
        Combustivel other = (Combustivel) object;
        if ((this.idcombustivel == null && other.idcombustivel != null) || (this.idcombustivel != null && !this.idcombustivel.equals(other.idcombustivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Combustivel[ idcombustivel=" + idcombustivel + " ]";
    }
    
}
