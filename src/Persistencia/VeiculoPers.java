/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.persistence.Query;
import model.Veiculo;

/**
 *
 * @author rafael
 */
public class VeiculoPers extends BasePers implements IPersistencia<Veiculo>{

    public VeiculoPers() {
        super();
    }

    
    @Override
    public Veiculo gravar(Veiculo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Veiculo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo atualizar(Veiculo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo procurarPorId(int id) {
        Query query = getEm().createNamedQuery("Veiculo.findByIdveiculo");
        query.setParameter("idveiculo", id);
        return (Veiculo)query.getSingleResult();
    }

    @Override
    public List<Veiculo> getLista() {
        return (List<Veiculo>) getEm().createNamedQuery("Veiculo.findAll").getResultList();
    }
    
}
