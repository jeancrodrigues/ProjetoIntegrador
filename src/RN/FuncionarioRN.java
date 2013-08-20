/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.FuncionarioPers;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.PessoaFisica;

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
        
    public Funcionario getFunc() {
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

    public Object getErrosValidacao() {
        return errosValidacao;
    }
}
