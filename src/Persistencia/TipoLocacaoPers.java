/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.persistence.Query;
import model.Tipolocacao;

/**
 *
 * @author Jean
 */
public class TipoLocacaoPers extends BasePers implements IPersistencia<Tipolocacao> {

    @Override
    public Tipolocacao gravar(Tipolocacao t) {
        return null;
    }

    @Override
    public void deletar(int id) {
    }

    @Override
    public void deletar(Tipolocacao t) {
    }

    @Override
    public Tipolocacao atualizar(Tipolocacao t) {
        return null;
    }

    @Override
    public Tipolocacao procurarPorId(int id) {
        return null;
    }

    @Override
    public List<Tipolocacao> getLista() {
        Query query = getEm().createNamedQuery("Tipolocacao.findAll");
        return query.getResultList();
    }
    
}
