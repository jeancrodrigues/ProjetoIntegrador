/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import model.Compra;
import Persistencia.CompraPers;
import Wrapper.CompraWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author rafael
 */
public class CompraRN {
   private CompraPers pers;
   private Compra compra;
   
    public CompraRN() {
        pers = new CompraPers();
    }
   
    public List<CompraWrapper> getCompraWrapperList() {
        List<CompraWrapper> lista = new ArrayList<>();
        for (Compra compra : pers.getLista()) {
                lista.add(new CompraWrapper(compra));
        }
        return lista;
    }
    
    public CompraPers getPers() {
        return pers;
    }

    public void setPers(CompraPers pers) {
        this.pers = pers;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
   
   public void setCompraById(Integer id) {
        compra = pers.procurarPorId(id);
    }

    public void autorizarCompraSelecionada() {
     compra.setDataautorizacao(Calendar.getInstance().getTime());
    }
}