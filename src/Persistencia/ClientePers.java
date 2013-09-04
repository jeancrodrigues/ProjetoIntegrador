/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import javax.persistence.Query;
import model.Cliente;
import org.hibernate.annotations.NamedQuery;

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
    }

    @Override
    public void deletar(Cliente cliente) {
        beginTransaction();
        getEm().remove(cliente);
        commitTransaction();
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        beginTransaction();
        cliente = getEm().merge(cliente);
        commitTransaction();
        return cliente;
    }

    @Override
    public Cliente procurarPorId(int id) {        
        Query query = getEm().createNamedQuery("Cliente.findByIdcliente");
        query.setParameter("idcliente", id);
        return (Cliente)query.getSingleResult();
    }

    @Override
    public List<Cliente> getLista() {
        return (List<Cliente>) getEm().createNamedQuery("Cliente.findAll").getResultList();
    }
}
