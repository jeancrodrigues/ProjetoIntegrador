/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByIdpagamento", query = "SELECT p FROM Pagamento p WHERE p.idpagamento = :idpagamento"),
    @NamedQuery(name = "Pagamento.findByValor", query = "SELECT p FROM Pagamento p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagamento.findByDatalancamento", query = "SELECT p FROM Pagamento p WHERE p.datalancamento = :datalancamento"),
    @NamedQuery(name = "Pagamento.findByDatapagamento", query = "SELECT p FROM Pagamento p WHERE p.datapagamento = :datapagamento")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpagamento")
    private Integer idpagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "valor")
    private BigDecimal valor;
    
    @Column(name = "datalancamento")
    @Temporal(TemporalType.DATE)
    private Date datalancamento;
    
    @Column(name = "datapagamento")
    @Temporal(TemporalType.DATE)
    private Date datapagamento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamento")
    private List<Boleto> boletoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagamento")
    private List<Locacao> locacaoList;
    
    @JoinColumn(name = "idpromocao", referencedColumnName = "idpromocao")
    @ManyToOne
    private Promocao promocao;
    
    @JoinColumn(name = "idfuncbaixa", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionarioBaixa;

    public Pagamento() {
    }

    public Pagamento(Integer idpagamento) {
        this.idpagamento = idpagamento;
    }

    public Integer getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(Integer idpagamento) {
        this.idpagamento = idpagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    @XmlTransient
    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
    }

    @XmlTransient
    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
    }

    public Promocao getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Funcionario getFuncionarioBaixa() {
        return funcionarioBaixa;
    }

    public void setFuncionarioBaixa(Funcionario funcbaixa) {
        this.funcionarioBaixa = funcbaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpagamento != null ? idpagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.idpagamento == null && other.idpagamento != null) || (this.idpagamento != null && !this.idpagamento.equals(other.idpagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pagamento[ idpagamento=" + idpagamento + " ]";
    }
    
}
