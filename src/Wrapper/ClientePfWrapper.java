/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

import Exception.ClienteException;
import com.towel.el.annotation.Resolvable;
import model.Cliente;

/**
 *
 * @author Jean
 */
public class ClientePfWrapper {
    
    private Integer id;
    
    @Resolvable(colName="Nome")
    private String nome;
    @Resolvable(colName="Cpf")
    private String cpf;
    @Resolvable(colName="Rg")
    private String rg;
    @Resolvable(colName="Telefone1")
    private String telefone1;
    @Resolvable(colName="Telefone2")
    private String telefone2;

    public ClientePfWrapper(Cliente cliente) throws ClienteException {
        if(cliente != null && cliente.isPessoaFisica()){
           this.id = cliente.getIdcliente();
           this.nome = cliente.getPessoafisica().getNome();
           this.cpf = cliente.getPessoafisica().getCpf();
           this.rg = cliente.getPessoafisica().getRg();
           this.telefone1 = cliente.getPessoafisica().getTelefone1();
           this.telefone2 = cliente.getPessoafisica().getTelefone2();
        }          
    }    
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public Integer getId() {
        return id;
    }
}