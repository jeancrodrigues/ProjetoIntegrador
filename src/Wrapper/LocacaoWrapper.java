/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

/**
 *
 * @author rafael
 */
import Exception.ClienteException;
import com.towel.el.annotation.Resolvable;
import model.Cliente;
import model.Locacao;

public class LocacaoWrapper extends DefaultWrapper {

    @Resolvable(colName = "Data Locação")
    private String datalocacao;
    @Resolvable(colName = "Veiculo")
    private String veiculo;
    @Resolvable(colName = "Tipo de Locação")
    private String tipolocacao;
    @Resolvable(colName = "Cliente")
    private String cliente;
    @Resolvable(colName = "Motorista")
    private String motorista;
    @Resolvable(colName = "Funcionário")
    private String funcionario;
    @Resolvable(colName = "Promoção")
    private String promocao;
    @Resolvable(colName = "Data Devolução")
    private String datadevolucao;
    private boolean finalizada;

    public LocacaoWrapper(Locacao locacao) throws ClienteException{

        Cliente cli = locacao.getCliente();
        if (locacao != null) {
            this.id = cli.getIdcliente();
            if (cli.isPessoaFisica()) {
                this.cliente = cli.getPessoafisica().getNome();
            } else {
                this.cliente = cli.getPessoajuridica().getNomefantasia();
            }
            this.veiculo = locacao.getVeiculo().getModelo();
            if (locacao.getMotorista() != null){
                this.motorista = locacao.getMotorista().getPessoafisica().getNome();
            }
            if (locacao.getTipolocacao()!= null){
                this.tipolocacao = locacao.getTipolocacao().getTipo();
            }
            this.funcionario = locacao.getFuncionario().getPessoafisica().getNome();
            if (locacao.getPromocao()!= null){
                this.promocao = locacao.getPromocao().getNome();
            } 
            this.datalocacao = Util.DataUtil.dateToString(locacao.getDatalocacao());
            
            if (locacao.getDatadevolucao()== null) {
                finalizada = false;
            } else {
                finalizada = true;
                this.datadevolucao = Util.DataUtil.dateToString(locacao.getDatadevolucao());
            }
        }
    }
}