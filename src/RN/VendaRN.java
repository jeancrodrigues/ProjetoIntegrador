/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.VendaPers;
import Wrapper.VeiculoWrapper;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;
import model.Venda;
/**
 *
 * @author rafael
 */
public class VendaRN {
   private VendaPers pers;
   private Venda venda;
   public List<Veiculo> veiculosVenda;
   
    public VendaRN() {
        pers = new VendaPers();
        veiculosVenda = new ArrayList<Veiculo>();
    }
   
    public List<VeiculoWrapper> getVendaWrapperList() {
        List<VeiculoWrapper> lista = new ArrayList<>();
        for (int i = 0; i < veiculosVenda.size(); i++) {
            lista.add(new VeiculoWrapper(veiculosVenda.get(i)));
        }
        return lista;
    }
    
    public VendaPers getPers() {
        return pers;
    }

    public void setPers(VendaPers pers) {
        this.pers = pers;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setCompra(Venda venda) {
        this.venda = venda;
    }
   
   public void setCompraById(Integer id) {
        venda = pers.procurarPorId(id);
    }
    public void gravar(){
        
        pers.gravar(venda);
        
    }
   /*
    public void autorizarCompraSelecionada() {
     venda.setDataautorizacao(Calendar.getInstance().getTime());
     pers.atualizar(venda);
    }*/
}