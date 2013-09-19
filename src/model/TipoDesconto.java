/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jean
 */
public class TipoDesconto {
    private boolean tipo;
    private String descricao;

    public TipoDesconto(boolean tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }
    
    public boolean isTipoDescontoReais() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
    
}
