/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jean
 */
@Entity
@Table(name = "compraveiculo")
public class CompraVeiculo implements Serializable{    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompraveiculo", unique = true, nullable = false)
    private Integer idcompraveiculos;
    private String nome;

    @ManyToOne(targetEntity=Compra.class)
    @JoinColumn(name = "idcompra")
    private Compra compra;

    @ManyToOne(targetEntity=Veiculo.class)
    @JoinColumn(name = "idveiculo")
    private Veiculo veiculo;

    public Integer getIdCompraVeiculo() {
        return this.idcompraveiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }                
}
