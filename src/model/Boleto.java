/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "boleto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleto.findAll", query = "SELECT b FROM Boleto b"),
    @NamedQuery(name = "Boleto.findByIdboleto", query = "SELECT b FROM Boleto b WHERE b.idboleto = :idboleto"),
    @NamedQuery(name = "Boleto.findByCodigobarras", query = "SELECT b FROM Boleto b WHERE b.codigobarras = :codigobarras"),
    @NamedQuery(name = "Boleto.findByValor", query = "SELECT b FROM Boleto b WHERE b.valor = :valor"),
    @NamedQuery(name = "Boleto.findByValorpago", query = "SELECT b FROM Boleto b WHERE b.valorpago = :valorpago"),
    @NamedQuery(name = "Boleto.findByDatavencimento", query = "SELECT b FROM Boleto b WHERE b.datavencimento = :datavencimento"),
    @NamedQuery(name = "Boleto.findByDatapagamento", query = "SELECT b FROM Boleto b WHERE b.datapagamento = :datapagamento")})
public class Boleto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idboleto")
    private Integer idboleto;
    
    @Column(name = "codigobarras")
    private String codigobarras;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    
    @Column(name = "valorpago")
    private BigDecimal valorpago;
    
    @Column(name = "datavencimento")
    @Temporal(TemporalType.DATE)
    private Date datavencimento;
    
    @Column(name = "datapagamento")
    @Temporal(TemporalType.DATE)
    private Date datapagamento;
    
    @JoinColumn(name = "idpessoajuridica", referencedColumnName = "idpessoajuridica")
    @ManyToOne(optional = false)
    private PessoaJuridica pessoajuridica;
    
    @JoinColumn(name = "idpagamento", referencedColumnName = "idpagamento")
    @ManyToOne(optional = false)
    private Pagamento pagamento;
    
    @JoinColumn(name = "idfuncemissor", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioEmissor;

    public Boleto() {
    }

    public Boleto(Integer idboleto) {
        this.idboleto = idboleto;
    }

    public Integer getIdboleto() {
        return idboleto;
    }

    public void setIdboleto(Integer idboleto) {
        this.idboleto = idboleto;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorpago() {
        return valorpago;
    }

    public void setValorpago(BigDecimal valorpago) {
        this.valorpago = valorpago;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }

    public PessoaJuridica getPessoajuridica() {
        return pessoajuridica;
    }

    public void setPessoajuridica(PessoaJuridica pessoajuridica) {
        this.pessoajuridica = pessoajuridica;
    }

    public Pagamento getIdpagamento() {
        return pagamento;
    }

    public void setIdpagamento(Pagamento idpagamento) {
        this.pagamento = idpagamento;
    }

    public Funcionario getIdfuncemissor() {
        return funcionarioEmissor;
    }

    public void setIdfuncemissor(Funcionario idfuncemissor) {
        this.funcionarioEmissor = idfuncemissor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idboleto != null ? idboleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleto)) {
            return false;
        }
        Boleto other = (Boleto) object;
        if ((this.idboleto == null && other.idboleto != null) || (this.idboleto != null && !this.idboleto.equals(other.idboleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Boleto[ idboleto=" + idboleto + " ]";
    }
    
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      