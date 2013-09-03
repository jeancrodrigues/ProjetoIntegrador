/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.swing.JOptionPane;
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
        getEm().merge(func);
        commitTransaction();
        return null;
       
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Funcionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario atualizar(Funcionario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario procurarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
