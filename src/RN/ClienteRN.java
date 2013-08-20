/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.ClientePers;
import Util.ClienteTableModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Cliente;
import model.PessoaFisica;
import org.hibernate.tool.stat.BeanTableModel;
/**
 *
 * @author RAFAEL
 */
public class ClienteRN {

    private Cliente cli;
    private ClientePers pers;
    private List <String> errosValidacao;

    public ClienteRN() {
        cli = new Cliente(true);
        pers = new ClientePers();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    public boolean gravar(){        
        if(isClienteValido(cli)){
            pers.gravar(cli);        
            return true;
        }
        return false;
    }
    
    public boolean isClienteValido(Cliente cli){
        if(cli != null){
            return isPessoaFisicaValida(cli.getPessoafisica());
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

    public TableModel getClienteTableModel() {                
        return new ClienteTableModel(pers.getLista());
    }
}
