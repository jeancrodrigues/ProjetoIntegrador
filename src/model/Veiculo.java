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
@Table(name = "veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v"),
    @NamedQuery(name = "Veiculo.findByIdveiculo", query = "SELECT v FROM Veiculo v WHERE v.idveiculo = :idveiculo"),
    @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Veiculo.findByMarca", query = "SELECT v FROM Veiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Veiculo.findByAnomodelo", query = "SELECT v FROM Veiculo v WHERE v.anomodelo = :anomodelo"),
    @NamedQuery(name = "Veiculo.findByAnofabricacao", query = "SELECT v FROM Veiculo v WHERE v.anofabricacao = :anofabricacao"),
    @NamedQuery(name = "Veiculo.findByQuilometragem", query = "SELECT v FROM Veiculo v WHERE v.quilometragem = :quilometragem"),
    @NamedQuery(name = "Veiculo.findByChassi", query = "SELECT v FROM Veiculo v WHERE v.chassi = :chassi")})
public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idveiculo")    
    private Integer idveiculo;
    
    @Column(name = "modelo")    
    private String modelo;
    
    @Column(name = "marca")
    private String marca;
    
    @Column(name = "anomodelo")
    @Temporal(TemporalType.DATE)
    private Date anomodelo;
    
    @Column(name = "anofabricacao")
    private int anofabricacao;
    
    @Column(name = "quilometragem")
    private Integer quilometragem;
    
    @Column(name = "chassi")
    private String chassi;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
    private List<CompraVeiculo> compraList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
    private List<Manutencao> manutencaoList;
    
    @JoinColumn(name = "idcombustivel", referencedColumnName = "idcombustivel")
    @ManyToOne(optional = false)
    private Combustivel combustivel;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
    private List<Locacao> locacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")
    private List<Venda> vendaList;

    public Veiculo() {
    }

    public Veiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    public Integer getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnomodelo() {
        return anomodelo;
    }

    public void setAnomodelo(Date anomodelo) {
        this.anomodelo = anomodelo;
    }

    public int getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(int anofabricacao) {
        this.anofabricacao = anofabricacao;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @XmlTransient
    public List<CompraVeiculo> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<CompraVeiculo> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Manutencao> getManutencaoList() {
        return manutencaoList;
    }

    public void setManutencaoList(List<Manutencao> manutencaoList) {
        this.manutencaoList = manutencaoList;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    @XmlTransient
    public List<Locacao> getLocacaoList() {
        return locacaoList;
    }

    public void setLocacaoList(List<Locacao> locacaoList) {
        this.locacaoList = locacaoList;
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
        hash += (idveiculo != null ? idveiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.idveiculo == null && other.idveiculo != null) || (this.idveiculo != null && !this.idveiculo.equals(other.idveiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Veiculo[ idveiculo=" + idveiculo + " ]";
    }
    
}
