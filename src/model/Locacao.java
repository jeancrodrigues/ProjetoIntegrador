/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "locacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
    @NamedQuery(name = "Locacao.findByIdlocacao", query = "SELECT l FROM Locacao l WHERE l.idlocacao = :idlocacao"),
    @NamedQuery(name = "Locacao.findByDatalocacao", query = "SELECT l FROM Locacao l WHERE l.datalocacao = :datalocacao"),
    @NamedQuery(name = "Locacao.findByDatadevolucao", query = "SELECT l FROM Locacao l WHERE l.datadevolucao = :datadevolucao")})
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlocacao")
    private Integer idlocacao;
    
    @Column(name = "datalocacao")
    @Temporal(TemporalType.DATE)
    private Date datalocacao;
    
    @Column(name = "datadevolucao")
    @Temporal(TemporalType.DATE)
    private Date datadevolucao;
    
    @OneToMany(mappedBy = "locacao")
    private List<Manutencao> manutencaoList;
    
    @JoinColumn(name = "idveiculo", referencedColumnName = "idveiculo")
    @ManyToOne(optional = false)
    private Veiculo veiculo;
    
    @JoinColumn(name = "idtipolocacao", referencedColumnName = "idtipolocacao")
    @ManyToOne(optional = false)
    private Tipolocacao tipolocacao;
    
    @JoinColumn(name = "idpagamento", referencedColumnName = "idpagamento")
    @ManyToOne(optional = false)
    private Pagamento pagamento;
    
    @JoinColumn(name = "idmotorista", referencedColumnName = "idmotorista")
    @ManyToOne(optional = false)
    private Motorista motorista;
    
    @JoinColumn(name = "idfuncionario", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;
    
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Locacao() {
    }

    public Locacao(Integer idlocacao) {
        this.idlocacao = idlocacao;
    }

    public Integer getIdlocacao() {
        return idlocacao;
    }

    public void setIdlocacao(Integer idlocacao) {
        this.idlocacao = idlocacao;
    }

    public Date getDatalocacao() {
        return datalocacao;
    }

    public void setDatalocacao(Date datalocacao) {
        this.datalocacao = datalocacao;
    }

    public Date getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    @XmlTransient
    public List<Manutencao> getManutencaoList() {
        return manutencaoList;
    }

    public void setManutencaoList(List<Manutencao> manutencaoList) {
        this.manutencaoList = manutencaoList;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Tipolocacao getTipolocacao() {
        return tipolocacao;
    }

    public void setTipolocacao(Tipolocacao tipolocacao) {
        this.tipolocacao = tipolocacao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlocacao != null ? idlocacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.idlocacao == null && other.idlocacao != null) || (this.idlocacao != null && !this.idlocacao.equals(other.idlocacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Locacao[ idlocacao=" + idlocacao + " ]";
    }
    
}
