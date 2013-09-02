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
public class ClientePjWrapper {
    @Resolvable(colName="Nome Fantasia")
    private String nomeFantasia;
    @Resolvable(colName="Razão Social")
    private String razaoSocial;
    @Resolvable(colName="Cnpj")
    private String cnpj;
    @Resolvable(colName="Telefone1")
    private String telefone1;
    @Resolvable(colName="Telefone2")
    private String telefone2;

    public ClientePjWrapper(Cliente cliente) throws ClienteException {
        if(cliente != null && !!cliente.isPessoaFisica()){
           this.nomeFantasia = cliente.getPessoajuridica().getNomefantasia();
           this.razaoSocial = cliente.getPessoajuridica().getRazaosocial();
           this.telefone1 = cliente.getPessoajuridica().getTelefone1();
           this.telefone2 = cliente.getPessoajuridica().getTelefone2();
        }          
    }    

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }    
}
