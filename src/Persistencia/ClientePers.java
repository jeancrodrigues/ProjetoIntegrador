/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import model.Cliente;

/**
 *
 * @author RAFAEL
 */
public class ClientePers extends BasePers implements IPersistencia<Cliente> {

    public ClientePers() {
        super();
    }

    @Override
    public Cliente gravar(Cliente cli) {
        beginTransaction();
        getEm().merge(cli);
        commitTransaction();
        return null;
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente atualizar(Cliente t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente procurarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getLista() {
        return (List<Cliente>) getEm().createNamedQuery("Cliente.findAll").getResultList();
    }
}
