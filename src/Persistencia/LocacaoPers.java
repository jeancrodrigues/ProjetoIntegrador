/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author rafael
 */
import java.util.List;
import javax.persistence.Query;
import model.Locacao;
public class LocacaoPers extends BasePers implements IPersistencia<Locacao>{

    @Override
    public Locacao gravar(Locacao locacao) {
        beginTransaction();
        locacao = getEm().merge(locacao);
        commitTransaction();
        return locacao;
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Locacao locacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao atualizar(Locacao locacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao procurarPorId(int id) {
        Query query = getEm().createNamedQuery("Locacao.findByIdlocacao");
        query.setParameter("idlocacao", id);
        return (Locacao)query.getSingleResult();
    }

    @Override
    public List<Locacao> getLista() {
        return (List<Locacao>) getEm().createNamedQuery("Locacao.findAll").getResultList();
    }
    
}
