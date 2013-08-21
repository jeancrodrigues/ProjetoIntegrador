/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import model.Combustivel;

/**
 *
 * @author Jean
 */
public class CombustivelPers extends BasePers implements IPersistencia<Combustivel> {

    @Override
    public Combustivel gravar(Combustivel t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Combustivel t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Combustivel atualizar(Combustivel t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Combustivel procurarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Combustivel> getLista() {
        return getEm().createNamedQuery("Combustivel.findAll").getResultList();
    }
        
    
}
