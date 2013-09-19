/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import model.Promocao;

/**
 *
 * @author Jean
 */
public class PromocaoPers extends BasePers implements IPersistencia<Promocao> {

    @Override
    public Promocao gravar(Promocao promocao) {
        beginTransaction();
        promocao = getEm().merge(promocao);
        commitTransaction();
        return promocao;
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Promocao promocao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Promocao atualizar(Promocao promocao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Promocao procurarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Promocao> getLista() {
        Query query = getEm().createNamedQuery("Promocao.findAll");
        return query.getResultList();
    }
    
    public List<Promocao> getListaPromocoesVigentesData(Date data){
        Query query = getEm().createNamedQuery("Promocao.findVigentes");
        query.setParameter(":data", data);
        return query.getResultList();
    }
    
}
