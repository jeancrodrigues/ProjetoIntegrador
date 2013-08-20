/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "motorista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motorista.findAll", query = "SELECT m FROM Motorista m"),
    @NamedQuery(name = "Motorista.findByIdmotorista", query = "SELECT m FROM Motorista m WHERE m.idmotorista = :idmotorista"),
    @NamedQuery(name = "Motorista.findByRegistro", query = "SELECT m FROM Motorista m WHERE m.registro = :registro"),
    @NamedQuery(name = "Motorista.findByDataemissao", query = "SELECT m FROM Motorista m WHERE m.dataemissao = :dataemissao"),
    @NamedQuery(name = "Motorista.findByDatavalidade", query = "SELECT m FROM Motorista m WHERE m.datavalidade = :datavalidade")})
public class Motorista implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotorista")
    private Integer idmotorista;
    
    @Column(name = "registro")
    private String registro;
    
    @Column(name = "dataemissao")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    
    @Column(name = "datavalidade")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    
    @JoinColumn(name = "idpessoafisica", referencedColumnName = "idpessoafisica")
    @ManyToOne(optional = false)
    private PessoaFisica pessoafisica;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motorista")
    private List<Locacao> locacaoList;

    public Motorista() {
    }

    public Motorista(Integer idmotorista) {
        this.idmotorista = idmotorista;
    }

    public Integer getIdmotorista() {
        return idmotorista;
    }

    public void setIdmotorista(Integer idmotorista) {
        this.idmotorista = idmotorista;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public PessoaFisica getPessoafisica() {
        return pessoafisica;
    }

    public void setPessoafisica(PessoaFisica pessoafisica) {
        this.pessoafisica = pessoafisica;
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
        hash += (idmotorista != null ? idmotorista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motorista)) {
            return false;
        }
        Motorista other = (Motorista) object;
        if ((this.idmotorista == null && other.idmotorista != null) || (this.idmotorista != null && !this.idmotorista.equals(other.idmotorista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Motorista[ idmotorista=" + idmotorista + " ]";
    }
    
}
