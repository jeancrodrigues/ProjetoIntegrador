/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.towel.el.annotation.Resolvable;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "pessoajuridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p"),
    @NamedQuery(name = "PessoaJuridica.findByIdpessoajuridica", query = "SELECT p FROM PessoaJuridica p WHERE p.idpessoajuridica = :idpessoajuridica"),
    @NamedQuery(name = "PessoaJuridica.findByRazaosocial", query = "SELECT p FROM PessoaJuridica p WHERE p.razaosocial = :razaosocial"),
    @NamedQuery(name = "PessoaJuridica.findByNomefantasia", query = "SELECT p FROM PessoaJuridica p WHERE p.nomefantasia = :nomefantasia"),
    @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj"),
    @NamedQuery(name = "PessoaJuridica.findByTelefone1", query = "SELECT p FROM PessoaJuridica p WHERE p.telefone1 = :telefone1"),
    @NamedQuery(name = "PessoaJuridica.findByTelefone2", query = "SELECT p FROM PessoaJuridica p WHERE p.telefone2 = :telefone2")})
public class PessoaJuridica implements Serializable, Pessoa {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoajuridica")
    private Integer idpessoajuridica;
    
    @Column(name = "razaosocial")
    @Resolvable(colName="razaosocial")
    private String razaosocial;
   
    @Column(name = "nomefantasia")
    @Resolvable(colName = "nomefantasia")
    private String nomefantasia;
    
    @Column(name = "cnpj")
    @Resolvable(colName="Cnpj")
    private String cnpj;
   
    @Column(name = "telefone1")
    @Resolvable(colName="Telefone")
    private String telefone1;
   
    @Column(name = "telefone2")
    @Resolvable(colName="Telefone 2")
    private String telefone2;
    
    @JoinColumn(name = "idendereco", referencedColumnName = "idendereco")
    @ManyToOne  (cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private Endereco endereco;

    public PessoaJuridica() {
        this.endereco = new Endereco();
    }

    public PessoaJuridica(Integer idpessoajuridica) {
        this.idpessoajuridica = idpessoajuridica;
    }

    public Integer getIdpessoajuridica() {
        return idpessoajuridica;
    }

    public void setIdpessoajuridica(Integer idpessoajuridica) {
        this.idpessoajuridica = idpessoajuridica;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpessoajuridica != null ? idpessoajuridica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.idpessoajuridica == null && other.idpessoajuridica != null) || (this.idpessoajuridica != null && !this.idpessoajuridica.equals(other.idpessoajuridica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PessoaJuridica[ idpessoajuridica=" + idpessoajuridica + " ]";
    }
}
