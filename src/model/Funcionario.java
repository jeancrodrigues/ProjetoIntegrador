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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdfuncionario", query = "SELECT f FROM Funcionario f WHERE f.idfuncionario = :idfuncionario"),
    @NamedQuery(name = "Funcionario.findBySenha", query = "SELECT f FROM Funcionario f WHERE f.senha = :senha"),
    @NamedQuery(name = "Funcionario.findByUsuario", query = "SELECT f FROM Funcionario f WHERE f.usuario = :usuario")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfuncionario")
    private Integer idfuncionario;
    
    @Column(name = "senha")
    private String senha;
    
    @Column(name = "usuario")
    private String usuario;
    
    @JoinTable(name = "funcionariosetor", joinColumns = {
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")}, inverseJoinColumns = {
    @JoinColumn(name = "idsetor", referencedColumnName = "idsetor")})
    @ManyToMany
    private List<Setor> setorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Compra> compraList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Manutencao> manutencaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionarioEmissor")
    private List<Boleto> boletoList;
    
    @JoinColumn(name = "idpessoafisica", referencedColumnName = "idpessoafisica")
    @ManyToOne(optional = false)
    private PessoaFisica pessoafisica;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Locacao> locacaoList;
    
    @OneToMany(mappedBy = "funcionarioBaixa")
    private List<Pagamento> pagamentoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Venda> vendaList;

    public Funcionario() {
        this.pessoafisica = new PessoaFisica();
    }

    public Funcionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Setor> getSetorList() {
        return setorList;
    }

    public void setSetorList(List<Setor> setorList) {
        this.setorList = setorList;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Manutencao> getManutencaoList() {
        return manutencaoList;
    }

    public void setManutencaoList(List<Manutencao> manutencaoList) {
        this.manutencaoList = manutencaoList;
    }

    @XmlTransient
    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
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

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    @XmlTransient
    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfuncionario != null ? idfuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idfuncionario == null && other.idfuncionario != null) || (this.idfuncionario != null && !this.idfuncionario.equals(other.idfuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcionario[ idfuncionario=" + idfuncionario + " ]";
    }
    
}
