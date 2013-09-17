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
import model.Veiculo;

public class VeiculoWrapper extends DefaultWrapper{
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
    
    public VeiculoWrapper(Veiculo veiculo) {
        if(veiculo != null){
           this.id = veiculo.getIdveiculo();
           this.chassi = veiculo.getChassi();
           this.anoModelo = String.valueOf(veiculo.getAnomodelo());
           this.anoFabricacao = String.valueOf(veiculo.getAnofabricacao());
           this.modelo = veiculo.getModelo();
           this.combustivel = String.valueOf(veiculo.getCombustivel());
           this.marca = veiculo.getMarca();
           this.quilometragem = String.valueOf(veiculo.getQuilometragem());
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
