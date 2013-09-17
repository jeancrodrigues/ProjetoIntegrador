/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

import com.towel.el.annotation.Resolvable;
import model.Venda;

/**
 *
 * @author rafael
 */
public class VendaWrapper extends DefaultWrapper{

    @Resolvable(colName = "Data Venda")
    private String datavenda;
    @Resolvable(colName = "Valor Venda")
    private String valorvenda;
    @Resolvable(colName = "Funcionário")
    private String funcionario;
    @Resolvable(colName = "Data Autorização")
    private String dataautorizacao;
    @Resolvable(colName = "Autorizada")
    private boolean autorizada;

    public VendaWrapper(Venda venda) {
        if (venda != null) {
            this.id = venda.getIdvenda();
            this.datavenda = Util.DataUtil.dateToString(venda.getDatavenda());
            this.valorvenda = venda.getValorvenda().toString();
            if (venda.getFuncionario() != null)
            this.funcionario = venda.getFuncionario().getPessoafisica().getNome();
            /*if (venda.getDataautorizacao() == null) {
                autorizada = false;
            } else {
                autorizada = true;
                this.dataautorizacao = Util.DataUtil.dateToString(venda.getDataautorizacao());
            }*/
        }
    }
    
    public String getDatacompra() {
        return datavenda;
    }

    public void setDatacompra(String datavenda) {
        this.datavenda = datavenda;
    }

    public String getValorcompra() {
        return valorvenda;
    }

    public void setValorcompra(String valorvenda) {
        this.valorvenda = valorvenda;
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
