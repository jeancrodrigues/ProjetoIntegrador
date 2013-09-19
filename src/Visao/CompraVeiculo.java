/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import RN.CompraVeiculoRN;
import RN.LoginUsuarioUtil;
import Util.*;
import Wrapper.CompraVeiculoWrapper;
import com.towel.swing.table.ObjectTableModel;
import java.awt.Component;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import model.Combustivel;
import model.Compra;
import model.Funcionario;
import model.PessoaJuridica;
import model.Veiculo;

/**
 *
 * @author RAFAEL
 */
public class CompraVeiculo extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;

    private CompraVeiculoRN compraRN;
    private ObjectTableModel<CompraVeiculoWrapper> veiculoModel;

    /**
     * Creates new form CompraVeiculo
     */
    public CompraVeiculo(java.awt.Frame parent, boolean modal, boolean visible, Component component) {
        super(parent, modal);
        initComponents();
        inicizalizar();
        this.setLocationRelativeTo(component);
        this.setVisible(visible);

    }

    public void inicizalizar() {
        compraRN = new CompraVeiculoRN();
        for (Combustivel cb : compraRN.getListaCombustivel()) {
            cmbCombustivel.addItem(cb);
        }
        
        txtValorTotalCompra.setText(null);
        txtData.setText(String.valueOf(DataUtil.dateToString(Calendar.getInstance().getTime())));
        btnGravar.setEnabled(false);
                
        Funcionario funcionario = LoginUsuarioUtil.getUsuarioLogado();       
        setFuncionario(funcionario);
        compraRN.setFuncionarioCompra(funcionario);        
        
        limparVeiculo();
        limparCompra();
        inicializaTabelaVeiculo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pDadosCompras = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValorTotalCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFuncionario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRazaoSocial = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNomeFantasia = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        pDadosVeiculo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtChassi = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtQuilometragem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtValorVeiculo = new javax.swing.JTextField();
        btnAdicionaVeiculo = new javax.swing.JButton();
        cmbCombustivel = new javax.swing.JComboBox();
        txtModelo = new javax.swing.JTextField();
        txtAnoModelo = new javax.swing.JFormattedTextField();
        txtAnoFabricacao = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JFormattedTextField();
        pListaVeiculos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra de Veiculos");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Compra de Veiculos");

        pDadosCompras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pDadosCompras.setToolTipText("");

        jLabel3.setText("Data");

        txtData.setEditable(false);

        jLabel4.setText("Valor Total");

        txtValorTotalCompra.setFocusable(false);

        jLabel5.setText("Funcionario");

        txtFuncionario.setEditable(false);
        txtFuncionario.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Dados Compra");

        jLabel16.setText("Fornecedor");

        txtRazaoSocial.setDocument(new MaskFieldUtil(MaskFieldUtil.ONLY_LETTERS_MASK, 50, true));

        jLabel17.setText("Nome Fantasia");

        txtNomeFantasia.setDocument(new MaskFieldUtil(MaskFieldUtil.ONLY_LETTERS_NUMBERS_SPACE_MASK, 50, true));
        txtNomeFantasia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeFantasiaActionPerformed(evt);
            }
        });

        jLabel18.setText("CNPJ");

        try {
            txtCNPJ.setFormatterFactory(new DefaultFormatterFactory (new MaskFormatter("##.###.###/####-##")));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        jLabel19.setText("Telefone");

        try {
            txtTelefone.setFormatterFactory(new DefaultFormatterFactory (new MaskFormatter("(###)####-####")));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        javax.swing.GroupLayout pDadosComprasLayout = new javax.swing.GroupLayout(pDadosCompras);
        pDadosCompras.setLayout(pDadosComprasLayout);
        pDadosComprasLayout.setHorizontalGroup(
            pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosComprasLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pDadosComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDadosComprasLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFuncionario))
                    .addGroup(pDadosComprasLayout.createSequentialGroup()
                        .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazaoSocial)
                            .addComponent(txtCNPJ))))
                .addGap(18, 18, 18)
                .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pDadosComprasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDadosComprasLayout.createSequentialGroup()
                        .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeFantasia)
                            .addGroup(pDadosComprasLayout.createSequentialGroup()
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(22, 22, 22))
        );
        pDadosComprasLayout.setVerticalGroup(
            pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosComprasLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtValorTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pDadosVeiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dados Veiculo");

        jLabel8.setText("Modelo");

        jLabel9.setText("Marca");

        jLabel10.setText("Ano Modelo");

        jLabel11.setText("Ano Fabricação");

        jLabel12.setText("Quilometragem");

        jLabel13.setText("Chassi");

        jLabel14.setText("Combustivel");

        txtChassi.setDocument(new MaskFieldUtil(MaskFieldUtil.ONLY_LETTERS_NUMBERS_MASK, 17, true));

        txtMarca.setDocument(new MaskFieldUtil(MaskFieldUtil.ONLY_LETTERS_MASK, 50, true));

        txtQuilometragem.setDocument(new MaskFieldUtil(MaskFieldUtil.ONLY_NUMBERS_MASK, 6, true));

        jLabel15.setText("Valor");

        btnAdicionaVeiculo.setText("Adicionar");
        btnAdicionaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaVeiculoActionPerformed(evt);
            }
        });

        cmbCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCombustivelActionPerformed(evt);
            }
        });

        txtModelo.setDocument(new MaskFieldUtil(MaskFieldUtil.ONLY_LETTERS_NUMBERS_SPACE_MASK, 40, true));

        try {
            txtAnoModelo.setFormatterFactory(new DefaultFormatterFactory (new MaskFormatter("####")));
        } catch (ParseException ex) {
            Logger.getLogger(CompraVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            txtAnoFabricacao.setFormatterFactory(new DefaultFormatterFactory (new MaskFormatter("####")));
        } catch (ParseException ex) {
            Logger.getLogger(CompraVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        jLabel20.setText("Placa");

        try {
            txtPlaca.setFormatterFactory(new DefaultFormatterFactory (new MaskFormatter("UUU-####")));
        } catch (ParseException ex) {
            Logger.getLogger(CompraVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

        javax.swing.GroupLayout pDadosVeiculoLayout = new javax.swing.GroupLayout(pDadosVeiculo);
        pDadosVeiculo.setLayout(pDadosVeiculoLayout);
        pDadosVeiculoLayout.setHorizontalGroup(
            pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9))
                    .addComponent(jLabel6)
                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtChassi, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel11))
                                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(txtValorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(53, 53, 53)
                                .addComponent(btnAdicionaVeiculo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        pDadosVeiculoLayout.setVerticalGroup(
            pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(cmbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
                        .addComponent(btnAdicionaVeiculo)
                        .addContainerGap())
                    .addGroup(pDadosVeiculoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pDadosVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtValorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pListaVeiculos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbVeiculo);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Veiculos da Compra");

        javax.swing.GroupLayout pListaVeiculosLayout = new javax.swing.GroupLayout(pListaVeiculos);
        pListaVeiculos.setLayout(pListaVeiculosLayout);
        pListaVeiculosLayout.setHorizontalGroup(
            pListaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListaVeiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(pListaVeiculosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pListaVeiculosLayout.setVerticalGroup(
            pListaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pListaVeiculosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDadosCompras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pDadosVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pListaVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(pDadosCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(pDadosVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pListaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limparVeiculo() {
        txtChassi.setText(null);
        txtAnoModelo.setText(null);
        txtAnoFabricacao.setText(null);
        txtModelo.setText(null);
        txtMarca.setText(null);
        txtQuilometragem.setText(null);
        txtValorVeiculo.setText(null);
        txtPlaca.setText(null);
    }

    public void limparCompra() {
        txtRazaoSocial.setText(null);
        txtNomeFantasia.setText(null);
        txtCNPJ.setText(null);
        txtTelefone.setText(null);
    }

    private Veiculo lePropriedadesVeiculoTela() throws NumberFormatException {

        int anoFabricacao = Integer.parseInt(txtAnoFabricacao.getText().trim());
        int anoModelo = Integer.parseInt(txtAnoModelo.getText().trim());
        int quilometragem = Integer.parseInt(txtQuilometragem.getText());

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(txtPlaca.getText());
        veiculo.setChassi(txtChassi.getText().trim());
        veiculo.setMarca(txtMarca.getText().trim());
        veiculo.setModelo(txtModelo.getText().trim());
        veiculo.setCombustivel((Combustivel) cmbCombustivel.getSelectedItem());

        veiculo.setQuilometragem(quilometragem);
        veiculo.setAnomodelo(anoModelo);
        veiculo.setAnofabricacao(anoFabricacao);

        return veiculo;
    }

    public void inicializaTabelaVeiculo() {
        veiculoModel = new ObjectTableModel(CompraVeiculoWrapper.class, "chassi,anoModelo,anoFabricacao,modelo,marca,quilometragem,valor");
        veiculoModel.setData(compraRN.getVeiculoWrapperList());
        tbVeiculo.setModel(veiculoModel);
    }
    private void btnAdicionaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaVeiculoActionPerformed
        try {
            Veiculo veiculo = lePropriedadesVeiculoTela();
            Double valorVeiculo = Double.parseDouble(txtValorVeiculo.getText().trim());
            if (compraRN.adicionaVeiculo(veiculo, valorVeiculo)) {
                JOptionPane.showMessageDialog(this, "Carro Adicionado com Sucesso");
                limparVeiculo();
                btnGravar.setEnabled(true);
                txtValorTotalCompra.setText(String.valueOf(compraRN.getCompra().getValorcompra()));
                inicializaTabelaVeiculo();
            } else {
                String msgs = "Veiculo Inválido";
                for (String msg : compraRN.getErrosValidacaoVeiculo()) {
                    msgs = msgs + "\n" + msg;
                }
                JOptionPane.showMessageDialog(this, msgs);
            }
        } catch (NumberFormatException ex) {
            String msgs = "Campos Inválidos";
            if (txtAnoFabricacao.getText().endsWith(" ")) {
                msgs = msgs + "\n-Ano Fabricação";
            }
            if (txtAnoModelo.getText().endsWith(" ")) {
                msgs = msgs + "\n-Ano Modelo ";
            }
            if (txtQuilometragem.getText().equals("")) {
                msgs = msgs + "\n-Quilometragem ";
            }
            if (txtValorVeiculo.getText().equals("")) {
                msgs = msgs + "\n-Valor ";
            }
            if (txtPlaca.getText().equals("")) {
                msgs = msgs + "\n-Placa ";
            }
            JOptionPane.showMessageDialog(this, msgs);
        }
    }//GEN-LAST:event_btnAdicionaVeiculoActionPerformed

    private PessoaJuridica lePessoaJuridica() {
        PessoaJuridica p = new PessoaJuridica();
        p.setRazaosocial(txtRazaoSocial.getText());
        p.setNomefantasia(txtNomeFantasia.getText());
        p.setCnpj(txtCNPJ.getText());
        p.setTelefone1(txtTelefone.getText());
        return p;
    }

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Deseja Gravar?") == 0) {
            
            Compra compra = compraRN.getCompra();
            
            compra.setVendedor(lePessoaJuridica());
            compra.setDatacompra(Calendar.getInstance().getTime());

            if (!compraRN.gravar()) {
                String msgs = "Compra Inválida.";
                for (String msg : compraRN.getErrosValidacaoCompra()) {
                    msgs = msgs + "\n" + msg;
                }
                JOptionPane.showMessageDialog(this, msgs);
            } else {
                inicizalizar();
                JOptionPane.showMessageDialog(this, "Compra Inserida Com Sucesso!");
            }
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void cmbCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCombustivelActionPerformed

    private void txtNomeFantasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeFantasiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeFantasiaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if (compraRN.isCompraVazia()) {
            dispose();
        } else {
            if (JOptionPane.showConfirmDialog(this, "Deseja Sair?") == 0) {
                dispose();
            }
        }
    }//GEN-LAST:event_btnSairActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaVeiculo;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox cmbCombustivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pDadosCompras;
    private javax.swing.JPanel pDadosVeiculo;
    private javax.swing.JPanel pListaVeiculos;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbVeiculo;
    private javax.swing.JFormattedTextField txtAnoFabricacao;
    private javax.swing.JFormattedTextField txtAnoModelo;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JTextField txtChassi;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JFormattedTextField txtPlaca;
    private javax.swing.JTextField txtQuilometragem;
    private javax.swing.JTextField txtRazaoSocial;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtValorTotalCompra;
    private javax.swing.JTextField txtValorVeiculo;
    // End of variables declaration//GEN-END:variables

    private void setFuncionario(Funcionario funcionario) {
        txtFuncionario.setText(funcionario.getNome());
    }
}
