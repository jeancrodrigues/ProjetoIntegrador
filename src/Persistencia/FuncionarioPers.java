/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.persistence.Query;
import model.Funcionario;

/**
 *
 * @author RAFAEL
 */
public class FuncionarioPers extends BasePers implements IPersistencia<Funcionario>{

    public FuncionarioPers() {
        super();
    }  
    
    @Override
    public Funcionario gravar(Funcionario func) {
        beginTransaction();
        func = getEm().merge(func);
        commitTransaction();
        return func;       
    }

    @Override
    public void deletar(int id) {
    }

    @Override
    public void deletar(Funcionario func) {
        
    }

    @Override
    public Funcionario atualizar(Funcionario funcionario) {
        return gravar(funcionario);
    }

    @Override
    public Funcionario procurarPorId(int id) {
        Query query = getEm().createNamedQuery("Funcionario.findByIdfuncionario");
        query.setParameter("idfuncionario", id);
        return (Funcionario)query.getSingleResult();        
    }

    @Override
    public List<Funcionario> getLista() {
        Query query = getEm().createNamedQuery("Funcionario.findAll");
        return (List<Funcionario>)query.getResultList();        
    }

    public Funcionario procurarPorNomeUsuario(String usuario) {        
        Query query = getEm().createNamedQuery("Funcionario.findByUsuario");
        query.setParameter("usuario", usuario);
        return (Funcionario)query.getSingleResult();        
    }
}
