/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

/**
 *
 * @author RAFAEL
 */

import com.towel.el.annotation.Resolvable;
import model.CompraVeiculo;

public class VeiculoWrapper {
    @Resolvable(colName="Chassi")
    private String chassi;
    @Resolvable(colName="Ano Modelo")
    private String anoModelo;
    @Resolvable(colName="Ano Fabricação")
    private String anoFabricacao;
    @Resolvable(colName="Modelo")
    private String modelo;
    @Resolvable(colName="Combustivel")
    private String combustivel;
    @Resolvable(colName="Marca")
    private String marca;
    @Resolvable(colName="Quilometragem")
    private String quilometragem;
    @Resolvable(colName="Valor")
    private String valor;
    
    public VeiculoWrapper(CompraVeiculo comprav) {
        if(comprav != null){
           this.chassi = comprav.getVeiculo().getChassi();
           this.anoModelo = String.valueOf(comprav.getVeiculo().getAnomodelo());
           this.anoFabricacao = String.valueOf(comprav.getVeiculo().getAnofabricacao());
           this.modelo = comprav.getVeiculo().getModelo();
           this.combustivel = String.valueOf(comprav.getVeiculo().getCombustivel());
           this.marca = comprav.getVeiculo().getMarca();
           this.quilometragem = String.valueOf(comprav.getVeiculo().getQuilometragem());
           this.valor = String.valueOf(comprav.getValor());
        }          
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getAnoFabricação() {
        return anoFabricacao;
    }

    public void setAnoFabricação(String anoFabricação) {
        this.anoFabricacao = anoFabricação;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
}
