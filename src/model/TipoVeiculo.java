/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "tipoveiculo")
@XmlRootElement
@NamedQuery(name = "TipoVeiculo.findAll", query = "SELECT t FROM TipoVeiculo t")
public class TipoVeiculo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="idtipoveiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idveiculo;    
    
    @Column(name="tipo")
    private String nomeTipo;
    
    @Column(name="valordiario")
    private Double valorDiario;
    
    @Column(name="valorsemanal")
    private Double valorSemanal;
    
    @Column(name="valormensal")
    private Double valorMensal;
    
    @Column(name="valorquilometro")            
    private Double valorQuilometros;

    public Integer getIdveiculo() {
        return idveiculo;
    }

    @Override
    public String toString() {
        return nomeTipo;
    }

    public void setIdveiculo(Integer idveiculo) {
        this.idveiculo = idveiculo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idveiculo);
        hash = 59 * hash + Objects.hashCode(this.nomeTipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoVeiculo other = (TipoVeiculo) obj;
        if (!Objects.equals(this.idveiculo, other.idveiculo)) {
            return false;
        }
        if (!Objects.equals(this.nomeTipo, other.nomeTipo)) {
            return false;
        }
        return true;
    }
    
    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public Double getValorDiario() {
        return valorDiario;
    }

    public void setValorDiario(Double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public Double getValorSemanal() {
        return valorSemanal;
    }

    public void setValorSemanal(Double valorSemanal) {
        this.valorSemanal = valorSemanal;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public Double getValorQuilometros() {
        return valorQuilometros;
    }

    public void setValorQuilometros(Double valorQuilometros) {
        this.valorQuilometros = valorQuilometros;
    }
}
