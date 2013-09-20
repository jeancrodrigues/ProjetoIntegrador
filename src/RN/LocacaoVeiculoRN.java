/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Exception.ClienteException;
import Persistencia.LocacaoPers;
import Persistencia.PromocaoPers;
import Persistencia.TipoLocacaoPers;
import Wrapper.LocacaoWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Cliente;
import model.Funcionario;
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
    private Funcionario funcionario;

    private LocacaoPers pers;
    
    public LocacaoVeiculoRN() {
        this.pers = new LocacaoPers();
        locacao = new Locacao();
    }
    
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
        veiculo.setDisponivel(false);
        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setMotorista(motorista);                
        locacao.setFuncionario(funcionario);
        pers.gravar(locacao);
    }
    
    public List<LocacaoWrapper> getLocacaoWrapperList() throws ClienteException{
        List<LocacaoWrapper> lista = new ArrayList<>();
        for (Locacao locacao : pers.getLista()) {
                lista.add(new LocacaoWrapper(locacao));
        }
        return lista;
    }
    public void setLocacaoById(Integer id) {
        locacao = pers.procurarPorId(id);
    }
    
    public Locacao getLocacaoSelecionada(){
        return locacao;
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

    public void setDataLocacao(Date data) {
        locacao.setDatalocacao(data);
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void gravarDevolucao() {
        pers.gravar(locacao);
    }
    
    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
    
}
