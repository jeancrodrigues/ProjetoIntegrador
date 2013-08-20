/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name = "manutencao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manutencao.findAll", query = "SELECT m FROM Manutencao m"),
    @NamedQuery(name = "Manutencao.findByIdmanutencao", query = "SELECT m FROM Manutencao m WHERE m.idmanutencao = :idmanutencao"),
    @NamedQuery(name = "Manutencao.findByDatainicio", query = "SELECT m FROM Manutencao m WHERE m.datainicio = :datainicio"),
    @NamedQuery(name = "Manutencao.findByDatatermino", query = "SELECT m FROM Manutencao m WHERE m.datatermino = :datatermino"),
    @NamedQuery(name = "Manutencao.findByObservacoes", query = "SELECT m FROM Manutencao m WHERE m.observacoes = :observacoes")})
public class Manutencao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmanutencao")
    private Integer idmanutencao;
    
    @Column(name = "datainicio")
    @Temporal(TemporalType.DATE)
    private Date datainicio;
    
    @Column(name = "datatermino")
    @Temporal(TemporalType.DATE)
    private Date datatermino;
    
    @Column(name = "observacoes")
    private String observacoes;
    
    @JoinColumn(name = "idveiculo", referencedColumnName = "idveiculo")
    @ManyToOne(optional = false)
    private Veiculo veiculo;
    
    @JoinColumn(name = "idlocacao", referencedColumnName = "idlocacao")
    @ManyToOne
    private Locacao locacao;
    
    @JoinColumn(name = "idfunc", referencedColumnName = "idfuncionario")
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public Manutencao() {
    }

    public Manutencao(Integer idmanutencao) {
        this.idmanutencao = idmanutencao;
    }

    public Integer getIdmanutencao() {
        return idmanutencao;
    }

    public void setIdmanutencao(Integer idmanutencao) {
        this.idmanutencao = idmanutencao;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setIdlocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setIdfunc(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmanutencao != null ? idmanutencao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutencao)) {
            return false;
        }
        Manutencao other = (Manutencao) object;
        if ((this.idmanutencao == null && other.idmanutencao != null) || (this.idmanutencao != null && !this.idmanutencao.equals(other.idmanutencao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Manutencao[ idmanutencao=" + idmanutencao + " ]";
    }
    
}
