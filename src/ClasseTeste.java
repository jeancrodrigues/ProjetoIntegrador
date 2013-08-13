import Persistencia.PessoaFisicaPers;
import Util.EntityManagerUtil;
import java.util.Calendar;
import java.util.List;
import model.Endereco;
import model.PessoaFisica;

/**
 * @author Jean
 */
public class ClasseTeste {
    
    public static void main(String[] args){        
        
        PessoaFisica pessoaFisica = CriaPessoaFisicaDeMentirinha();        
        PessoaFisicaPers pers = new PessoaFisicaPers();    
        
        pessoaFisica = pers.gravar(pessoaFisica);            
        
        List<PessoaFisica> lista = pers.getLista();
        
        for (PessoaFisica pf : lista){
            System.out.println(pf);
        }
        
        System.out.println(pessoaFisica);
        
        EntityManagerUtil.finalizaEntityManager();
    }

    private static PessoaFisica CriaPessoaFisicaDeMentirinha() {
        PessoaFisica pf = new PessoaFisica();
                
        pf.setNome("elias");
        pf.setCpf("2424");
        pf.setRg("242424");
        
        Calendar c = Calendar.getInstance();
        c.set(1912, 12, 12);                
        
        pf.setDatanascimento(c.getTime());        
        
        pf.setTelefone1("4230707070");
        pf.setTelefone2("4233707070");
        
        Endereco en = new Endereco();
        en.setLogradouro("Rua dois");
        en.setBairro("Parque do leite");
        en.setNumero("123");
        en.setCidade("Ponta Fina");
        en.setUf("PR");        
        pf.setEndereco(en);
        
        return pf;
    }    
}
