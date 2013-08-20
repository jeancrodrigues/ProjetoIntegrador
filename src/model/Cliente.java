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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Cliente.findByDatacadastro", query = "SELECT c FROM Cliente c WHERE c.datacadastro = :datacadastro")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    
    @Column(name = "datacadastro")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Locacao> locacaoList;
    
    @JoinColumn(name = "idpessoajuridica", referencedColumnName = "idpessoajuridica")
    @ManyToOne
    private PessoaJuridica pessoajuridica;
    
    @JoinColumn(name = "idpessoafisica", referencedColumnName = "idpessoafisica")
    @ManyToOne
    private PessoaFisica pessoafisica;

    public Cliente() {
    }

    public Cliente(boolean isPessoaFisica) {
        if (true){
            this.pessoafisica = new PessoaFisica();
        }else{
            this.pessoajuridica = new PessoaJuridica();
        }
            
    }

    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    @XmlTransient
    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }

    public PessoaJuridica getPessoajuridica() {
        return pessoajuridica;
    }

    public void setPessoajuridica(PessoaJuridica pessoajuridica) {
        this.pessoajuridica = pessoajuridica;
    }

    public PessoaFisica getPessoafisica() {
        return pessoafisica;
    }

    public void setPessoafisica(PessoaFisica pessoafisica) {
        this.pessoafisica = pessoafisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ idcliente=" + idcliente + " ]";
    }
}
