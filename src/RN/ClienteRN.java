package RN;

import Exception.ClienteException;
import Persistencia.ClientePers;
import Wrapper.ClientePjWrapper;
import Wrapper.ClientePfWrapper;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 *
 * @author RAFAEL
 */
public class ClienteRN {

    private Cliente cliente;
    private ClientePers pers;
    private List <String> errosValidacao;

    public ClienteRN() {
        pers = new ClientePers();
    }
    
    public ClienteRN(boolean isPessoaFisica) {
        if(isPessoaFisica){
            cliente = new Cliente(new PessoaFisica());
        }else{
            cliente = new Cliente(new PessoaJuridica());
        }
        pers = new ClientePers();
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public boolean gravarClienteAtual(){        
        if(isClienteValido(cliente)){
            pers.gravar(cliente);        
            return true;
        }
        return false;
    }
    
    public boolean isClienteValido(Cliente cliente){
        if(cliente != null){
            try {
                if(cliente.isPessoaFisica()){
                    return isPessoaFisicaValida(cliente.getPessoafisica());
                }else{
                    return isPessoaJuridicaValida(cliente.getPessoajuridica());            
                }
            } catch (ClienteException ex) {
                errosValidacao = new ArrayList<>();
                errosValidacao.add(ex.getMessage());
            }
        }
        return false;
    }
    
    public boolean isPessoaFisicaValida(PessoaFisica pf){
        boolean valido = true;
        errosValidacao = new ArrayList<>();        
        if(pf != null){            
            if(pf.getNome().trim().equals("")){
                errosValidacao.add("-  Nome não pode ser vazio.");
                valido = false;
            }
            if(pf.getDatanascimento() == null){
                errosValidacao.add("-  Data de Nascimento não pode ser vazio.");
                valido = false;
            }
            if(pf.getCpf().endsWith(" ")){
                errosValidacao.add("-  Cpf não pode ser vazio.");
                valido = false;
            }
            if(pf.getRg().trim().equals("")){
                errosValidacao.add("-  RG não pode ser vazio.");
                valido = false;
            }
            if(pf.getEndereco().getCep().endsWith(" ")){
                errosValidacao.add("-  Cep não pode ser vazio.");
                valido = false;
            }
            return valido;
        }
        errosValidacao.add("Pessoa não pode ser nula");
        return false;
    }
    
    public boolean isPessoaJuridicaValida(PessoaJuridica pj){
        boolean valido = true;
        errosValidacao = new ArrayList<>();        
        if(pj != null){            
            if(pj.getRazaosocial().trim().equals("")){
                errosValidacao.add("Razão Social não pode ser vazio.");
                valido = false;
            }
            if(pj.getNomefantasia().trim().equals("")){
                errosValidacao.add("Nome Fantasia não pode ser vazio.");
                valido = false;
            }
            if(pj.getCnpj().trim().equals("")){
                errosValidacao.add("CNPJ não pode ser vazio.");
                valido = false;
            }
            if(pj.getEndereco().getCep().trim().equals("")){
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

    public List<ClientePfWrapper> getClienteWrapperList() throws ClienteException {
        List<ClientePfWrapper> lista = new ArrayList<>();
        for (Cliente cliente : pers.getLista()) {
            if(cliente.isPessoaFisica()){
                lista.add(new ClientePfWrapper(cliente));
            }
        }
        return lista;
    }

    public List<ClientePjWrapper> getClientePjWrapperList() throws ClienteException {
        List<ClientePjWrapper> lista = new ArrayList<>();
        for (Cliente cliente : pers.getLista()) {
            if(!cliente.isPessoaFisica()){
                lista.add(new ClientePjWrapper(cliente));
            }
        }
        return lista;
    }

    public void setClienteById(Integer id) {
        cliente = pers.procurarPorId(id);
    }
}
