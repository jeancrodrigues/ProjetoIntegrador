/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Exception.ClienteException;
import Exception.VeiculoException;
import RN.LocacaoVeiculoRN;
import Wrapper.DefaultWrapper;
import Wrapper.LocacaoWrapper;
import com.towel.swing.table.ObjectTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Jean
 */
public class ListaLocacao extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;    
        
    private LocacaoVeiculoRN locacaoRN;
    private ObjectTableModel<LocacaoWrapper> locacaoModel;    
    
    public LocacaoVeiculoRN getLocacaoRN() {
        return locacaoRN;
    }

    public void setLocacaoRN(LocacaoVeiculoRN locacaoRN) {
        this.locacaoRN = locacaoRN;
    }
    
    public ListaLocacao(javax.swing.JFrame parent, boolean modal) throws VeiculoException, ClienteException{
        super(parent,modal);
        initComponents();
        locacaoRN = new LocacaoVeiculoRN();
        inicializaTableModelLocacao();      
    }   
    
    public ListaLocacao(javax.swing.JDialog parent, boolean modal) throws VeiculoException, ClienteException{
        super(parent,modal);
        initComponents();
        locacaoRN = new LocacaoVeiculoRN();
        inicializaTableModelLocacao();      
    }
    private void inicializaTableModelLocacao() throws ClienteException, VeiculoException{
        try {
            locacaoModel = new ObjectTableModel(LocacaoWrapper.class, 
                    "datalocacao,cliente,veiculo,motorista,tipolocacao,promocao,funcionario,datadevolucao");
            locacaoModel.setData(locacaoRN.getLocacaoWrapperList());        
            tbLocacao.setModel(locacaoModel);
        } catch (ClienteException ex) {
            Logger.getLogger("ERRO FATAL").log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void selectLocacaoFromTable(JTable table){
        int selectedRow = table.getSelectedRow();
        if(selectedRow>-1){
            ObjectTableModel tableModel = (ObjectTableModel) table.getModel();
            LocacaoWrapper wrapper = (LocacaoWrapper) tableModel.getValue(selectedRow);
            setLocacaoSelecionada(wrapper.getId());            
        }
    }
    
    private void setLocacaoSelecionada(Integer codigoLocacao) {
        locacaoRN.setLocacaoById(codigoLocacao);
        System.out.println("locacao selecionada " + codigoLocacao);
    }
    
    private void realizarDevolucao(){        
        try {
            DevolucaoVeiculo devolucao = new DevolucaoVeiculo(this,true,locacaoRN);        
            devolucao.setVisible(true);
        } catch (ClienteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbLocacao = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnDevolucao = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de Veiculos");
        setResizable(false);

        tbLocacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbLocacao);
        tbLocacao.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                selectLocacaoFromTable(tbLocacao);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnDevolucao.setText("Devolução");
        btnDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucaoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Locações Ativas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDevolucao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDevolucao)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucaoActionPerformed
        int itemSelecionado = tbLocacao.getSelectedRow();
        if(itemSelecionado >= 0){        
            LocacaoWrapper locacaoSelecionada = locacaoModel.getValue(itemSelecionado);
            locacaoRN.setLocacaoById(locacaoSelecionada.getId());
            realizarDevolucao();                
        }
    }//GEN-LAST:event_btnDevolucaoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolucao;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbLocacao;
    // End of variables declaration//GEN-END:variables
}
