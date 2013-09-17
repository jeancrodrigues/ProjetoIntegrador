/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Exception.VeiculoException;
import Persistencia.VeiculoPers;
import Wrapper.CompraVeiculoWrapper;
import Wrapper.VeiculoWrapper;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;

/**
 *
 * @author rafael
 */


public class VeiculoRN {
    VeiculoPers pers;
    Veiculo veiculo;
    
    public VeiculoRN() {
        pers =  new VeiculoPers();
        veiculo = new Veiculo();
    }
    
    public Veiculo getVeiculoSelecionado(){
        return veiculo;
    }
    public List<VeiculoWrapper> getVeiculoWrapperList() throws  VeiculoException{
        List<VeiculoWrapper> lista = new ArrayList<>();
        for (Veiculo veiculo : pers.getLista()) {
                lista.add(new VeiculoWrapper(veiculo));
        }
        return lista;
    }
    
    public void setVeiculoById(Integer id) {
        veiculo = pers.procurarPorId(id);
    }
    
}
