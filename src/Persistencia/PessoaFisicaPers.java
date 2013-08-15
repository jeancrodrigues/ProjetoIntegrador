package Persistencia;

import java.util.List;
import javax.swing.JOptionPane;
import model.PessoaFisica;

/**
 *
 * @author Jean
 */
public class PessoaFisicaPers extends BasePers implements IPersistencia<PessoaFisica>{

    public PessoaFisicaPers() {
        super();
    }    
    
    @Override
    public PessoaFisica gravar(PessoaFisica pessoaFisica) {
        PessoaFisica pf = pessoaFisica;
        
        beginTransaction();
        pf = getEm().merge(pf);
        commitTransaction();
        return pf;
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(PessoaFisica t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PessoaFisica atualizar(PessoaFisica pessoaFisica) {
        return gravar(pessoaFisica);
    }

    @Override
    public PessoaFisica procurarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PessoaFisica> getLista() {        
        List<PessoaFisica> lista = getEm().
                createNamedQuery("PessoaFisica.findAll").getResultList();
        return lista;
    }

    

    
}
