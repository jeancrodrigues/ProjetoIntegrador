/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.PromocaoPers;
import java.util.ArrayList;
import java.util.List;
import model.Promocao;
import model.TipoDesconto;

/**
 *
 * @author Jean
 */
public class PromocaoRN {

    private PromocaoPers pers;
    private Promocao promocao;

    public PromocaoRN() {
        pers = new PromocaoPers();
        promocao = new Promocao();
    }
    
    public List<TipoDesconto> getTiposDesconto() {
        List<TipoDesconto> tipos = new ArrayList<>();        
        tipos.add(new TipoDesconto(false, "Porcentagem"));
        return tipos;
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
    public void gravar(){
        pers.gravar(promocao);
    }
    
    public List<Promocao> getListaPromocao(){
        return pers.getLista();
    }
    
}
