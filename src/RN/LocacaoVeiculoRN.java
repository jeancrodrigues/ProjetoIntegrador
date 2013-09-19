/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Exception.ClienteException;
import Persistencia.PromocaoPers;
import Persistencia.TipoLocacaoPers;
import java.util.Calendar;
import java.util.List;
import model.Cliente;
import model.Locacao;
import model.Motorista;
import model.Promocao;
import model.Tipolocacao;
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

    public List<Promocao> getPromocoesVigentes() {
        PromocaoPers promocaoPers = new PromocaoPers();
        return promocaoPers.
                getListaPromocoesVigentesData(Calendar.getInstance().getTime());
    }

    public List<Tipolocacao> getTiposLocacao() {
        TipoLocacaoPers pers = new TipoLocacaoPers();
        return pers.getLista();
    }

    public void setMotoristaLocacao(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setPromocao(Promocao promocao) {
        locacao.setPromocao(promocao);
    }

    public void setTipoLocacao(Tipolocacao tipolocacao) {
        locacao.setTipolocacao(tipolocacao);
    }

    public Motorista getMotorista() {
        return motorista;
    }
}
