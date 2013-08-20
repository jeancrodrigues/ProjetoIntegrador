/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import model.Cliente;
import model.PessoaFisica;

/**
 *
 * @author Jean
 */
public class ClienteTableModel implements TableModel{

    private List<Cliente> clientes;

    public ClienteTableModel(List<Cliente> clientes) {
        this.clientes = clientes;
    }    
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "Nome";
            case 1: return "Cpf";
        }
        return "Coluna Inexistente";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PessoaFisica pf = clientes.get(rowIndex).getPessoafisica();        
        switch(columnIndex){            
            case 0: return pf.getNome();
            case 1: return pf.getCpf();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
