/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Persistencia.CompraPers;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Compra;
import model.CompraVeiculo;
import model.Veiculo;

/**
 *
 * @author Jean
 */
public class CompraVeiculoRN {

    CompraPers pers;
    private Compra compra;
    CompraVeiculo comprav;
    Double valor;
    private List<String> errosValidacao;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor + valor;
    }

    public CompraVeiculoRN() {
        compra = new Compra();
        pers = new CompraPers();
    }

    public boolean adicionaVeiculos(Veiculo veiculo) {
        comprav = new CompraVeiculo();
        
        if (isVeiculoValido(veiculo)) {
            comprav.setVeiculo(veiculo);
            compra.getVeiculos().add(comprav);
            JOptionPane.showMessageDialog(null, "Carro Adicionado com Sucesso");
            return true;
        }
        return false;

    }

    public void gravar() {

        pers.gravar(compra);
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public boolean isVeiculoValido(Veiculo veiculo) {
        boolean valido = true;
        errosValidacao = new ArrayList<>();
        if (veiculo != null) {
            if (veiculo.getChassi().trim().equals("")) {
                errosValidacao.add("Chassi não pode ser vazio.");
                valido = false;
            }
            if (veiculo.getQuilometragem().toString().isEmpty()) {
                errosValidacao.add("Kilometragem não pode ser vazio.");
                valido = false;
            }
            if (veiculo.getModelo().trim().equals("")) {
                errosValidacao.add("Modelo não pode ser vazio.");
                valido = false;
            }
            if (veiculo.getMarca().trim().equals("")) {
                errosValidacao.add("Modelo não pode ser vazio.");
                valido = false;
            }
            return valido;
        }
        errosValidacao.add("Veiculo não pode ser nulo");
        return false;
    }
    
    public Object getErrosValidacao() {
        return errosValidacao;
    }
}
