/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.CompraPers;
import model.Compra;
import model.CompraVeiculo;
import model.Veiculo;

/**
 *
 * @author Jean
 */
public class CompraVeiculoRN {

    CompraPers pers;
    Compra compra;
    CompraVeiculo comprav;
 

    public CompraVeiculoRN() {
        compra = new Compra();
        pers = new CompraPers();
    }       
    
    public void adicionaVeiculos(Veiculo veiculo) {
       comprav = new CompraVeiculo();
       comprav.setVeiculo(veiculo);
       compra.getVeiculos().add(comprav);
    }
    public void gravar(){
        
        pers.gravar(compra);
    }
}
