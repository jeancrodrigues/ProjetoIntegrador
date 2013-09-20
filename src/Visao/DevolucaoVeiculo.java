/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Exception.ClienteException;
import RN.LocacaoVeiculoRN;
import Util.DataUtil;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Locacao;
import model.Motorista;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Promocao;
import model.TipoVeiculo;
import model.Veiculo;

/**
 *
 * @author Jean
 */
public class DevolucaoVeiculo extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;

    private LocacaoVeiculoRN locacaoVeiculoRN;
    private long diasDecorridos;
    private Double valorLocacao;
    private Double valorDesconto;
    private Double valorTotal;
    
    /**
     * Creates new form DevolucaoVeiculo
     */
    public DevolucaoVeiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
    }

    public DevolucaoVeiculo(javax.swing.JDialog parent, boolean modal, LocacaoVeiculoRN locacaoVeiculoRN) throws ClienteException {
        super(parent, modal);
        setLocationRelativeTo(parent);
        initComponents();   
        this.locacaoVeiculoRN = locacaoVeiculoRN;
        setarCamposLocacao(locacaoVeiculoRN.getLocacaoSelecionada());
    }
    
    private void finalizarDevolucao(){
        Locacao locacao = locacaoVeiculoRN.getLocacao();
        locacao.setDatadevolucao(Calendar.getInstance().getTime());
        locacao.getVeiculo().setDisponivel(true);        
        locacaoVeiculoRN.gravarDevolucao();          
        JOptionPane.showMessageDialog(this, "Devolucao efetuada com sucesso");
        limparCampos();
    }
    
    private void limparCampos(){
        txtMarca.setText(null);
        txtModelo.setText(null);
        txtKm.setText(null);        
        txtPlaca.setText(null);
        txtNomeCliente.setText(null);        
        txtCpfCnpj.setText(null);        
        txtTelefone.setText(null);
        txtCelular.setText(null);
        txtEmail.setText(null);
        txtModelo.setText(null);
        txtMarca.setText(null);
        txtPlaca.setText(null);
        txtKm.setText(null);        
        txtTipoLocacao.setText(null);
        txtPromocao.setText(null);        
        txtNomeMotorista.setText(null);        
        txtCpfCnpjMotorista.setText(null);
        txtCnhMotorista.setText(null);        
        txtDataLocacao.setText(null);
        txtDataDevolucao.setText(null);        
        txtTotalDias.setText(null);
        txtValorDesconto.setText(null);
        txtValorLocacao.setText(null);
        txtValorTotal.setText(null);
    }
    
    private void limparCampos(){
        txtMarca.setText(null);
        txtModelo.setText(null);
        txtKm.setText(null);        
        txtPlaca.setText(null);
        txtNomeCliente.setText(null);        
        txtCpfCnpj.setText(null);        
        txtTelefone.setText(null);
        txtCelular.setText(null);
        txtEmail.setText(null);
        txtModelo.setText(null);
        txtMarca.setText(null);
        txtPlaca.setText(null);
        txtKm.setText(null);        
        txtTipoLocacao.setText(null);
        txtPromocao.setText(null);        
        txtNomeMotorista.setText(null);        
        txtCpfCnpjMotorista.setText(null);
        txtCnhMotorista.setText(null);        
        txtDataLocacao.setText(null);
        txtDataDevolucao.setText(null);        
        txtTotalDias.setText(null);
        txtValorDesconto.setText(null);
        txtValorLocacao.setText(null);
        txtValorTotal.setText(null);
    }
    
    private void setarCamposLocacao(Locacao locacao) throws ClienteException{
        limparCampos();
        setarCamposCliente(locacao.getCliente());
        setarCamposMotorista(locacao.getMotorista());
		setarCamposTotalizacao(locacao);
        setarCamposVeiculo(locacao.getVeiculo());
        setarCamposData(locacao);
        setarCamposTotalizacao(locacao);
    }
    
    private void setarCamposVeiculo(Veiculo veiculo){
        txtMarca.setText(veiculo.getMarca());
        txtModelo.setText(veiculo.getModelo());
        txtKm.setText(String.valueOf(veiculo.getQuilometragem()));        
        txtPlaca.setText(veiculo.getPlaca());
    }
    
    private void setarCamposVeiculo(Veiculo veiculo){
        txtMarca.setText(veiculo.getMarca());
        txtModelo.setText(veiculo.getModelo());
        txtKm.setText(String.valueOf(veiculo.getQuilometragem()));        
        txtPlaca.setText(veiculo.getPlaca());
    }
    
    private void setarCamposCliente(Cliente cliente) throws ClienteException{
        if(cliente.isPessoaFisica()){
            setarCamposPessoaFisica(cliente.getPessoafisica());   
        }else{
            setarCamposPessoaJuridica(cliente.getPessoajuridica());
        }
    }
    
    private void setarCamposPessoaFisica(PessoaFisica pessoa){
        txtNomeCliente.setText(pessoa.getNome());        
        txtCpfCnpj.setText(pessoa.getCpf());        
        txtTelefone.setText(pessoa.getTelefone1());
        txtCelular.setText(pessoa.getTelefone2());
        txtEmail.setText(pessoa.getEmail());
    }
    
    private void setarCamposPessoaJuridica(PessoaJuridica pessoa){
        txtNomeCliente.setText(pessoa.getRazaosocial());        
        txtCpfCnpj.setText(pessoa.getCnpj());        
        txtTelefone.setText(pessoa.getTelefone1());
        txtCelular.setText(pessoa.getTelefone2());
        txtEmail.setText(pessoa.getEmail());
    }
    
    private void setarCamposMotorista(Motorista motorista){
        PessoaFisica pessoa = motorista.getPessoafisica();
        txtNomeMotorista.setText(pessoa.getNome());        
        txtCpfCnpjMotorista.setText(pessoa.getCpf());        
        txtCnhMotorista.setText(motorista.getRegistro());
    }
    
    private void setarCamposTotalizacao(Locacao locacao){
        txtTipoLocacao.setText(locacao.getTipolocacao().getTipo());       
        Promocao promocao = locacao.getPromocao();
        if(promocao != null){
            txtPromocao.setText(promocao.getNome());
            Veiculo veiculo = locacao.getVeiculo();
            TipoVeiculo tipo = veiculo.getTipoVeiculo();
            
            switch(locacao.getTipolocacao().getIdtipolocacao()){
                case 1: {
                    valorLocacao = diasDecorridos * tipo.getValorDiario();
                    valorDesconto = ( valorLocacao * promocao.getPorcentagemDescontoDiario() )/100;
                } 
                break;
                case 2:{
                    valorLocacao = (( (int) diasDecorridos / 7 ) + ( diasDecorridos % 7 > 0 ? 1 : 0  )  )   * tipo.getValorSemanal();
                    valorDesconto = ( valorLocacao * promocao.getPorcentagemDescontoSemanal() )/100;
                } 
                break;
                case 3: {
                    valorLocacao = (( (int) diasDecorridos / 30 )  + ( diasDecorridos % 30 > 0 ? 1 : 0  ) )  * tipo.getValorMensal();
                    valorDesconto = ( valorLocacao * promocao.getPorcentagemDescontoMensal() )/100 ;
                }
                break;                    
            }
            
            valorTotal = valorLocacao - valorDesconto;
            
            txtValorLocacao.setText(String.valueOf(valorLocacao));
            txtValorDesconto.setText(String.valueOf(valorDesconto));
            txtValorTotal.setText(String.valueOf(valorTotal));
            
        }
    }
    
    private void setarCamposData(Locacao locacao){
        txtDataLocacao.setText(DataUtil.dateToString(locacao.getDatalocacao()));
        txtDataDevolucao.setText(DataUtil.dateToString(Calendar.getInstance().getTime()));        
        Calendar dtlocacao = Calendar.getInstance();
        dtlocacao.setTime(locacao.getDatalocacao());
        Calendar dtdevolucacao = Calendar.getInstance();        
        diasDecorridos = dtdevolucacao.getTimeInMillis() - dtlocacao.getTimeInMillis();        
        diasDecorridos = ((( diasDecorridos / 1000 ) / 60 ) / 60 ) / 24 ;
        txtTotalDias.setText(String.valueOf(diasDecorridos));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        lbCpf = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JTextField();
        lbRg1 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lbCpf1 = new javax.swing.JLabel();
        lbRg2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtNomeMotorista = new javax.swing.JTextField();
        lbCpf2 = new javax.swing.JLabel();
        txtCpfCnpjMotorista = new javax.swing.JTextField();
        txtCnhMotorista = new javax.swing.JTextField();
        lbCpf3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtDataLocacao = new javax.swing.JTextField();
        txtDataDevolucao = new javax.swing.JTextField();
        txtTotalDias = new javax.swing.JTextField();
        txtTipoLocacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPromocao = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtValorLocacao = new javax.swing.JTextField();
        txtValorDesconto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnFinalizarDevolucao = new javax.swing.JButton();
        lbCpf4 = new javax.swing.JLabel();
        txtNomeFuncionario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nome");

        txtNomeCliente.setEditable(false);

        lbCpf.setText("Cpf / Cnpj");

        txtCpfCnpj.setEditable(false);

        lbRg1.setText("Celular");

        txtTelefone.setEditable(false);

        txtCelular.setEditable(false);

        lbCpf1.setText("Telefone");

        lbRg2.setText("Email");

        txtEmail.setEditable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motorista", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel7.setText("Nome");

        txtNomeMotorista.setEditable(false);

        lbCpf2.setText("Cpf / Cnpj");

        txtCpfCnpjMotorista.setEditable(false);

        txtCnhMotorista.setEditable(false);

        lbCpf3.setText("Cnh");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCpf2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpfCnpjMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbCpf3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCnhMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCpf2)
                    .addComponent(txtCpfCnpjMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCpf3)
                    .addComponent(txtCnhMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCpf1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbRg1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbRg2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbCpf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCpf)
                    .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCpf1)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRg1)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRg2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veículo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txtModelo.setEditable(false);

        jLabel3.setText("Modelo");

        jLabel4.setText("Marca");

        txtMarca.setEditable(false);

        txtPlaca.setEditable(false);

        jLabel5.setText("Placa");

        txtKm.setEditable(false);

        jLabel6.setText("KM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Dados Locação");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totalização", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txtDataLocacao.setEditable(false);
        txtDataLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataLocacaoActionPerformed(evt);
            }
        });

        txtDataDevolucao.setEditable(false);
        txtDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataDevolucaoActionPerformed(evt);
            }
        });

        txtTotalDias.setEditable(false);
        txtTotalDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDiasActionPerformed(evt);
            }
        });

        txtTipoLocacao.setEditable(false);
        txtTipoLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoLocacaoActionPerformed(evt);
            }
        });

        jLabel8.setText("Data Saída");

        jLabel9.setText("Data Devolução");

        jLabel10.setText("Total Dias");

        jLabel11.setText("Tipo Locacao");

        jLabel12.setText("Promoção");

        txtPromocao.setEditable(false);
        txtPromocao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPromocaoActionPerformed(evt);
            }
        });

        jLabel13.setText("Valor Locação");

        txtValorLocacao.setEditable(false);
        txtValorLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorLocacaoActionPerformed(evt);
            }
        });

        txtValorDesconto.setEditable(false);
        txtValorDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDescontoActionPerformed(evt);
            }
        });

        jLabel14.setText("Valor Desconto");

        jLabel15.setText("Valor Total");

        txtValorTotal.setEditable(false);
        txtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(36, 36, 36)
                        .addComponent(txtValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtValorDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(42, 42, 42))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnFinalizarDevolucao.setText("Finalizar Devolução");
        btnFinalizarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarDevolucaoActionPerformed(evt);
            }
        });

        lbCpf4.setText("Funcionário");

        txtNomeFuncionario.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCpf4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizarDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCpf4)
                        .addComponent(txtNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnFinalizarDevolucao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataLocacaoActionPerformed

    private void txtDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataDevolucaoActionPerformed

    private void txtTotalDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDiasActionPerformed

    private void txtTipoLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoLocacaoActionPerformed

    private void txtPromocaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPromocaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPromocaoActionPerformed

    private void txtValorLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorLocacaoActionPerformed

    private void txtValorDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorDescontoActionPerformed

    private void txtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorTotalActionPerformed

    private void btnFinalizarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarDevolucaoActionPerformed
        finalizarDevolucao();
    }//GEN-LAST:event_btnFinalizarDevolucaoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarDevolucao;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbCpf1;
    private javax.swing.JLabel lbCpf2;
    private javax.swing.JLabel lbCpf3;
    private javax.swing.JLabel lbCpf4;
    private javax.swing.JLabel lbRg1;
    private javax.swing.JLabel lbRg2;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCnhMotorista;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtCpfCnpjMotorista;
    private javax.swing.JTextField txtDataDevolucao;
    private javax.swing.JTextField txtDataLocacao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeFuncionario;
    private javax.swing.JTextField txtNomeMotorista;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPromocao;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTipoLocacao;
    private javax.swing.JTextField txtTotalDias;
    private javax.swing.JTextField txtValorDesconto;
    private javax.swing.JTextField txtValorLocacao;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
