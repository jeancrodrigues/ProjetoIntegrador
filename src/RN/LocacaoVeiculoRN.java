/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Exception.ClienteException;
import model.Cliente;
import model.Locacao;
import model.Motorista;
import model.Veiculo;

/**
 *
 * @author Jean
 */
public class LocacaoVeiculoRN {

    private Locacao locacao;
    private Cliente cliente;
    private Veiculo veiculo;
    private Motorista motorista;
    
    public void setClienteLocacao(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculoLocacao(Veiculo veiculoSelecionado) {
        this.veiculo = veiculoSelecionado;
    }

    public Cliente getClienteLocacao() {
        return cliente;
    }

    public boolean clienteIsPessoaFisica() throws ClienteException {
        return cliente != null &&  cliente.isPessoaFisica();
    }

    public void gravarLocacao() {
        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setMotorista(motorista);                
    }    
}
