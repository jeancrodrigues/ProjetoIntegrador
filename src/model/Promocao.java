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
@Table(name = "promocao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocao.findAll", query = "SELECT p FROM Promocao p"),
    @NamedQuery(name = "Promocao.findByIdpromocao", query = "SELECT p FROM Promocao p WHERE p.idpromocao = :idpromocao"),
    @NamedQuery(name = "Promocao.findByNome", query = "SELECT p FROM Promocao p WHERE p.nome = :nome"),
    @NamedQuery(name = "Promocao.findByDescricao", query = "SELECT p FROM Promocao p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Promocao.findByDatainicio", query = "SELECT p FROM Promocao p WHERE p.datainicio = :datainicio"),
    @NamedQuery(name = "Promocao.findByDatatermino", query = "SELECT p FROM Promocao p WHERE p.datatermino = :datatermino"),
    @NamedQuery(name = "Promocao.findVigentes", query = "SELECT p FROM Promocao p WHERE :data BETWEEN p.datainicio AND p.datatermino")
    }
)
public class Promocao implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpromocao")
    private Integer idpromocao;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "datainicio")
    @Temporal(TemporalType.DATE)
    private Date datainicio;
    
    @Column(name = "datatermino")
    @Temporal(TemporalType.DATE)
    private Date datatermino;
    
    @Column(name="descontodiario")
    private Integer porcentagemDescontoDiario ;

    @Column(name="descontosemanal")
    private Integer porcentagemDescontoSemanal ;

    @Column(name="descontomensal")
    private Integer porcentagemDescontoMensal ;

    @Column(name="descontoquilometro")
    private Integer porcentagemDescontoQuilometro;

    @Column(name="quilometragemmaxima")
    private Integer quilometragemMaxima;
    
    @Column(name="descontoreais")
    private boolean descontoreais;
    
    @OneToMany(mappedBy = "promocao")
    private List<Pagamento> pagamentoList;

    public Promocao() {
    }

    public Promocao(Integer idpromocao) {
        this.idpromocao = idpromocao;
    }

    public Integer getIdpromocao() {
        return idpromocao;
    }

    public void setIdpromocao(Integer idpromocao) {
        this.idpromocao = idpromocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromocao != null ? idpromocao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocao)) {
            return false;
        }
        Promocao other = (Promocao) object;
        if ((this.idpromocao == null && other.idpromocao != null) || (this.idpromocao != null && !this.idpromocao.equals(other.idpromocao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Promocao[ idpromocao=" + idpromocao + " ]";
    }    

    public Integer getPorcentagemDescontoDiario() {
        return porcentagemDescontoDiario;
    }

    public void setPorcentagemDescontoDiario(Integer porcentagemDescontoDiario) {
        this.porcentagemDescontoDiario = porcentagemDescontoDiario;
    }

    public Integer getPorcentagemDescontoSemanal() {
        return porcentagemDescontoSemanal;
    }

    public void setPorcentagemDescontoSemanal(Integer porcentagemDescontoSemanal) {
        this.porcentagemDescontoSemanal = porcentagemDescontoSemanal;
    }

    public Integer getPorcentagemDescontoMensal() {
        return porcentagemDescontoMensal;
    }

    public void setPorcentagemDescontoMensal(Integer porcentagemDescontoMensal) {
        this.porcentagemDescontoMensal = porcentagemDescontoMensal;
    }

    public Integer getPorcentagemDescontoQuilometro() {
        return porcentagemDescontoQuilometro;
    }

    public void setPorcentagemDescontoQuilometro(Integer porcentagemDescontoQuilometro) {
        this.porcentagemDescontoQuilometro = porcentagemDescontoQuilometro;
    }

    public Integer getQuilometragemMaxima() {
        return quilometragemMaxima;
    }

    public void setQuilometragemMaxima(Integer quilometragemMaxima) {
        this.quilometragemMaxima = quilometragemMaxima;
    }

    public boolean isDescontoreais() {
        return descontoreais;
    }

    public void setDescontoreais(boolean descontoreais) {
        this.descontoreais = descontoreais;
    }
}
