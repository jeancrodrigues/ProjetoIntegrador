/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

import Exception.ClienteException;
import com.towel.el.annotation.Resolvable;
import model.Compra;

/**
 *
 * @author rafael
 */
public class CompraWrapper extends DefaultWrapper{

    @Resolvable(colName = "Data Compra")
    private String datacompra;
    @Resolvable(colName = "Vendedor")
    private String vendedor;
    @Resolvable(colName = "Valor Compra")
    private String valorcompra;
    @Resolvable(colName = "Funcionário")
    private String funcionario;
    @Resolvable(colName = "Data Autorização")
    private String dataautorizacao;
    @Resolvable(colName = "Autorizada")
    private boolean autorizada;

    public CompraWrapper(Compra compra) throws ClienteException{
        if (compra != null) {
            this.id = compra.getIdcompra();
            this.datacompra = Util.DataUtil.dateToString(compra.getDatacompra());
            this.vendedor = compra.getVendedor().getNomefantasia();
            this.valorcompra = compra.getValorcompra().toString();
            if (compra.getFuncionario() != null)
            this.funcionario = compra.getFuncionario().getPessoafisica().getNome();
            if (compra.getDataautorizacao() == null) {
                autorizada = false;
            } else {
                autorizada = true;
                this.dataautorizacao = Util.DataUtil.dateToString(compra.getDataautorizacao());
            }
        }
    }
    
    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(String valorcompra) {
        this.valorcompra = valorcompra;
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
