/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.CombustivelPers;
import Persistencia.FuncionarioPers;
import Persistencia.SetorPers;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.PessoaFisica;
import model.Setor;

/**
 *
 * @author RAFAEL
 */
public class FuncionarioRN {
    private Funcionario func;
    private FuncionarioPers pers;       
    private List<String> errosValidacao;

    public FuncionarioRN() {        
        pers = new FuncionarioPers();
        func = new Funcionario();
    }
        
    public Funcionario getFuncionario() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }
    
    public boolean gravar(){        
        if(isFuncionarioValido(func)){
            pers.gravar(func);        
            return true;            
        }
        return false;
    }
    
    public boolean isFuncionarioValido(Funcionario func){
        if(func != null){
            return isPessoaFisicaValida(func.getPessoafisica());
        }
        return false;
    }
    
    public boolean isPessoaFisicaValida(PessoaFisica pf){
        boolean valido = true;
        errosValidacao = new ArrayList<>();        
        if(pf != null){            
            if(pf.getNome().trim().equals("")){
                errosValidacao.add("Nome não pode ser vazio.");
                valido = false;
            }
            if(pf.getCpf().trim().equals("")){
                errosValidacao.add("Cpf não pode ser vazio.");
                valido = false;
            }
            if(pf.getRg().trim().equals("")){
                errosValidacao.add("RG não pode ser vazio.");
                valido = false;
            }
            if(pf.getEndereco().getCep().trim().equals("")){
                errosValidacao.add("Cep não pode ser vazio.");
                valido = false;
            }
            return valido;
        }
        errosValidacao.add("Pessoa não pode ser nula");
        return false;
    }

    public List<String> getErrosValidacao() {
        return errosValidacao;
    }
    
    public Iterable<Setor> getListaSetor() {
        SetorPers setorPers = new SetorPers();
        return setorPers.getLista();
    }

    public void setSenha(String senhaNova) throws Exception {        
        if( !senhaNova.equals("") && senhaNova.length() < 4){
            throw new Exception("A nova precisa ter no minímo 4 caracteres.");
        }                                               
        func.setSenha(senhaNova);
    }
}
