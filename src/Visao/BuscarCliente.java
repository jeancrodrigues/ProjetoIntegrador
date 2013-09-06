/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Wrapper.ClientePjWrapper;
import Exception.ClienteException;
import RN.ClienteRN;
import Wrapper.ClientePfWrapper;
import Wrapper.DefaultWrapper;
import com.towel.swing.table.ObjectTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Jean
 */
public class BuscarCliente extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;    
    
    private static final int EDITAR_CLIENTE = 0;
    private static final int CADASTRAR_CLIENTE = 1;
        
    private ClienteRN cliRN;
    private ObjectTableModel<ClientePfWrapper> clientesModel;
    private ObjectTableModel<ClientePjWrapper> clientesPjModel;
    
    public BuscarCliente(javax.swing.JFrame parent, boolean modal) throws ClienteException{
        super();
        initComponents();
        cliRN = new ClienteRN();
        inicializaTableModelPf();
        inicializaTableModelPj();        
    }   
    
    private void inicializaTableModelPf(){
        try {
            clientesModel = new ObjectTableModel(ClientePfWrapper.class, 
                    "nome,cpf,rg,telefone1,telefone2");
            clientesModel.setData(cliRN.getClienteWrapperList());        
            tbClientes.setModel(clientesModel);
        } catch (ClienteException ex) {
            Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void inicializaTableModelPj(){
        try {
            clientesPjModel = new ObjectTableModel(ClientePjWrapper.class, 
                    "nomeFantasia,razaoSocial,cnpj,telefone1,telefone2");
            clientesPjModel.setData(cliRN.getClientePjWrapperList());
            tbClientesPj.setModel(clientesPjModel);
        } catch (ClienteException ex) {
            Logger.getLogger(BuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void selectClienteFromTable(JTable table){
        int selectedRow = table.getSelectedRow();
        if(selectedRow>-1){
            ObjectTableModel tableModel = (ObjectTableModel) table.getModel();
            DefaultWrapper wrapper = (DefaultWrapper) tableModel.getValue(selectedRow);
            setClienteSelecionado(wrapper.getId());            
        }
    }
    
    private void setClienteSelecionado(Integer codigoCliente) {
        cliRN.setClienteById(codigoCliente);
    }
    
    private void abrirCadastroCliente(int acao) {
        
        ClienteRN clienteRN = null;
        if(acao == EDITAR_CLIENTE) {
            clienteRN = cliRN;
        }
        
        JDialog cadastroCliente = null;
        switch(jTabCliente.getSelectedIndex()){
            case 0: cadastroCliente = new CadastroCliente(this, true, true , null,clienteRN);
                break;
            case 1: cadastroCliente = new CadastroClientePJ(this, true, true , null,clienteRN);
                break;
        }        
        inicializaTableModelPf();
        inicializaTableModelPj();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabCliente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientesPj = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de clientes");
        setResizable(false);

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbClientes);
        tbClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                selectClienteFromTable(tbClientes);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        jTabCliente.addTab("Clientes Pessoa Fisica", jPanel1);

        tbClientesPj.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbClientesPj);
        tbClientesPj.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting())
                return;
                selectClienteFromTable(tbClientesPj);
                //faça algo com selected
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        jTabCliente.addTab("Clientes Pessoa Juridica", jPanel2);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabCliente)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabCliente)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSelecionar)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        abrirCadastroCliente(CADASTRAR_CLIENTE);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        abrirCadastroCliente(EDITAR_CLIENTE);
    }//GEN-LAST:event_btnEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabCliente;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbClientesPj;
    // End of variables declaration//GEN-END:variables
}
