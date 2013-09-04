/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

import com.towel.el.annotation.Resolvable;
import model.Compra;

/**
 *
 * @author rafael
 */
public class CompraWrapper {
    @Resolvable(colName="Data Compra")
    private String dataCompra;
    @Resolvable(colName="Vendedor")
    private String vendedor;
    @Resolvable(colName="Valor Compra")
    private String valorCompra;
    @Resolvable(colName="Data Autorização")
    private String dataautorizacao;
    @Resolvable(colName="Autorizada")
    private boolean autorizada;

    public CompraWrapper(Compra compra) {
        if(compra != null){
           this.dataCompra = Util.DataUtil.dateToString(compra.getDatacompra());
           this.vendedor = compra.getFuncionario().getPessoafisica().getNome();
           this.dataautorizacao = Util.DataUtil.dateToString(compra.getDataautorizacao());
        }          
    }
    
    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDataautorizacao() {
        return dataautorizacao;
    }

    public void setDataautorizacao(String dataautorizacao) {
        this.dataautorizacao = dataautorizacao;
    }

    public boolean isAutorizada() {
        return autorizada;
    }

    public void setAutorizada(boolean autorizada) {
        this.autorizada = autorizada;
    }
}
