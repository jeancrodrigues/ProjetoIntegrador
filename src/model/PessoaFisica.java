/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "pessoafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p"),
    @NamedQuery(name = "PessoaFisica.findByIdpessoafisica", query = "SELECT p FROM PessoaFisica p WHERE p.idpessoafisica = :idpessoafisica"),
    @NamedQuery(name = "PessoaFisica.findByNome", query = "SELECT p FROM PessoaFisica p WHERE p.nome = :nome"),
    @NamedQuery(name = "PessoaFisica.findByDatanascimento", query = "SELECT p FROM PessoaFisica p WHERE p.datanascimento = :datanascimento"),
    @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "PessoaFisica.findByRg", query = "SELECT p FROM PessoaFisica p WHERE p.rg = :rg"),
    @NamedQuery(name = "PessoaFisica.findByTelefone1", query = "SELECT p FROM PessoaFisica p WHERE p.telefone1 = :telefone1"),
    @NamedQuery(name = "PessoaFisica.findByTelefone2", query = "SELECT p FROM PessoaFisica p WHERE p.telefone2 = :telefone2")})
public class PessoaFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpessoafisica")
    private Integer idpessoafisica;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "datanascimento")
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "rg")
    private String rg;
    
    @Column(name = "telefone1")
    private String telefone1;
    
    @Column(name = "telefone2")
    private String telefone2;
    
    @JoinColumn(name = "idendereco", referencedColumnName = "idendereco")
    @ManyToOne( cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private Endereco endereco;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer idpessoafisica) {
        this.idpessoafisica = idpessoafisica;
    }

    public Integer getIdpessoafisica() {
        return idpessoafisica;
    }

    public void setIdpessoafisica(Integer idpessoafisica) {
        this.idpessoafisica = idpessoafisica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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
        hash += (idpessoafisica != null ? idpessoafisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.idpessoafisica == null && other.idpessoafisica != null) || (this.idpessoafisica != null && !this.idpessoafisica.equals(other.idpessoafisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + "idpessoafisica=" + idpessoafisica + ", nome=" + nome + ", datanascimento=" + datanascimento + ", cpf=" + cpf + ", rg=" + rg + ", telefone1=" + telefone1 + ", telefone2=" + telefone2 + ", endereco=" + endereco + '}';
    }

    
    
}
