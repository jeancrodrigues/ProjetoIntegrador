package Visao;

import Exception.ClienteException;
import Exception.VeiculoException;
import RN.ClienteRN;
import RN.LocacaoVeiculoRN;
import RN.LoginUsuarioUtil;
import Util.DataUtil;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Motorista;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Promocao;
import model.Tipolocacao;
import model.Veiculo;

public class LocacaoVeiculo extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private LocacaoVeiculoRN locacaoVeiculoRN;

    public LocacaoVeiculo(java.awt.Frame parent, boolean modal, boolean visible) {
        super();
        initComponents();
        inicializar();
        setLocationRelativeTo(null);
        setVisible(visible);
    }
    
    private void inicializar(){
        locacaoVeiculoRN = new LocacaoVeiculoRN();
        
        locacaoVeiculoRN.setDataLocacao(Calendar.getInstance().getTime());
        locacaoVeiculoRN.setFuncionario(LoginUsuarioUtil.getUsuarioLogado());
        
        setarPromocoesVigentes();
        setarTipoLocacao();
        
        txtFuncionario.setText( LoginUsuarioUtil.getUsuarioLogado().getNome() );
        txtRetirada.setText(DataUtil.dateToString(Calendar.getInstance().getTime()));
    }
    
    private void setMotorista(PessoaFisica pessoaFisica){
        Motorista motorista = new Motorista(pessoaFisica);
        locacaoVeiculoRN.setMotoristaLocacao(motorista);
        setarCamposMotorista(motorista);
    }
    
    private void setMotorista(){
        setMotorista(new PessoaFisica());
    }
    
    private Cliente buscaCliente() throws ClienteException {
        BuscarCliente buscarCliente = new BuscarCliente(this, true);
        buscarCliente.setVisible(true);

        ClienteRN clienteRN = buscarCliente.getClienteRN();
        return clienteRN.getCliente();
    }

    private void setClienteLocacaoTela(Cliente cliente) {
        try {
            if (cliente.isPessoaFisica()) {
                setClientePFLocacaoTela(cliente);
                System.out.println("cliente pf: " + cliente);
            } else {
                System.out.println("cliente pj: " + cliente);
                setClientePJLocacaoTela(cliente);
            }
        } catch (ClienteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void setClientePJLocacaoTela(Cliente cliente) {
        PessoaJuridica pessoaJuridica = cliente.getPessoajuridica();
        txtNomeCliente.setText(pessoaJuridica.getNomefantasia());
        lbCpf.setText("CNPJ");
        txtCpfCnpj.setText(pessoaJuridica.getCnpj());
        txtTelefone.setText(pessoaJuridica.getTelefone1());
        txtCelular.setText(pessoaJuridica.getTelefone2());
        txtEmail.setText(pessoaJuridica.getEmail());
    }

    private void setClientePFLocacaoTela(Cliente cliente) {
        PessoaFisica pessoaFisica = cliente.getPessoafisica();
        txtNomeCliente.setText(pessoaFisica.getNome());
        lbCpf.setText("CPF");
        txtCpfCnpj.setText(pessoaFisica.getCpf());
        txtTelefone.setText(pessoaFisica.getTelefone1());
        txtCelular.setText(pessoaFisica.getTelefone2());
        txtEmail.setText(pessoaFisica.getEmail());
    }
    
    private void setarPromocoesVigentes(){
        cmbbxPromocao.addItem(null);
        for(Promocao promo : locacaoVeiculoRN.getPromocoesVigentes()){
            cmbbxPromocao.addItem(promo);
        }        
    }
    private void setarTipoLocacao(){
        for(Tipolocacao tipolocacao : locacaoVeiculoRN.getTiposLocacao()){
            cmbbxTipoLocacao.addItem(tipolocacao);
        }
    }
    
    public void gravarLocacao(){        
        if(validaMotorista()){
            try{
                
                locacaoVeiculoRN.setPromocao((Promocao) cmbbxPromocao.getSelectedItem());
                locacaoVeiculoRN.setTipoLocacao((Tipolocacao) cmbbxTipoLocacao.getSelectedItem());
                locacaoVeiculoRN.gravarLocacao();
                
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Erro ao gravar locacao.\nErro: " + ex.getMessage());
            }
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        lbCpf = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lbRg1 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lbCpf1 = new javax.swing.JLabel();
        lbRg2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtEmailMotorista = new javax.swing.JTextField();
        txtCelularMotorista = new javax.swing.JTextField();
        txtTelefoneMotorista = new javax.swing.JTextField();
        lbRg3 = new javax.swing.JLabel();
        lbCpf2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNomeMotorista = new javax.swing.JTextField();
        lbCpf3 = new javax.swing.JLabel();
        txtCpfMotorista = new javax.swing.JTextField();
        lbRg4 = new javax.swing.JLabel();
        lbCpf4 = new javax.swing.JLabel();
        txtNumeroCnhMorista = new javax.swing.JTextField();
        lbCpf5 = new javax.swing.JLabel();
        txtDataValidadeCnhMotorista = new javax.swing.JTextField();
        chckbxMotorista = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbbxTipoLocacao = new javax.swing.JComboBox();
        cmbbxPromocao = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtRetirada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFuncionario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel1.setText("Nome");

        txtNomeCliente.setEditable(false);

        lbCpf.setText("Cpf / Cnpj");

        txtCpfCnpj.setEditable(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lbRg1.setText("Celular");

        txtTelefone.setEditable(false);

        txtCelular.setEditable(false);

        lbCpf1.setText("Telefone");

        lbRg2.setText("Email");

        txtEmail.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar)
                                .addGap(119, 119, 119))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCpf)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbCpf1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRg1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbRg2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(189, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbRg2)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCpf1)
                        .addComponent(lbRg1)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Motorista", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        lbRg3.setText("Email");

        lbCpf2.setText("Telefone");

        jLabel11.setText("Nome");

        lbCpf3.setText("Cpf / Cnpj");

        lbRg4.setText("Celular");

        lbCpf4.setText("Numero CNH");

        lbCpf5.setText("Data Validade CNH");

        chckbxMotorista.setText("Cliente é motorista");
        chckbxMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chckbxMotoristaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCpfMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCpf3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroCnhMorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCpf4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataValidadeCnhMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCpf5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbCpf2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefoneMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRg4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCelularMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbRg3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmailMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chckbxMotorista))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(chckbxMotorista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCpf3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCpf4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCpf5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeMotorista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpfMotorista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroCnhMorista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataValidadeCnhMotorista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbRg3)
                        .addComponent(txtEmailMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCpf2)
                        .addComponent(lbRg4)
                        .addComponent(txtCelularMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTelefoneMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Locação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veículo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        txtModelo.setEditable(false);

        jLabel3.setText("Modelo");

        jLabel4.setText("Marca");

        txtMarca.setEditable(false);

        txtPlaca.setEditable(false);

        jLabel5.setText("Placa");

        txtKm.setEditable(false);

        jLabel6.setText("KM");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
                .addGap(56, 56, 56)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jLabel7.setText("Tipo Locação");

        jLabel8.setText("Promoção");

        txtRetirada.setEditable(false);

        jLabel9.setText("Data Retirada");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRetirada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbbxTipoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbbxPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cmbbxPromocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cmbbxTipoLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar Locação");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Locação de Veículos");

        jLabel10.setText("Funcionario");

        txtFuncionario.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Deseja finalizar a locação?","Locação",JOptionPane.YES_NO_OPTION ) == 0 ) {
            System.out.println("gravar locacao");
            gravarLocacao();
            JOptionPane.showConfirmDialog(this, "Locacao efetuada com sucesso.");            
            limparCampos();
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            BuscarVeiculos veiculos = new BuscarVeiculos(this, true);
            veiculos.setVisible(true);
            locacaoVeiculoRN.setVeiculoLocacao(veiculos.getVeiculoRN().getVeiculoSelecionado());
            setVeiculoTela(veiculos.getVeiculoRN().getVeiculoSelecionado());

        } catch (VeiculoException ex) {
            Logger.getLogger(LocacaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Cliente cliente = buscaCliente();
            if (cliente != null) {
                locacaoVeiculoRN.setClienteLocacao(cliente);
                setClienteLocacaoTela(cliente);
            }
        } catch (ClienteException ex) {
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void chckbxMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chckbxMotoristaActionPerformed
        if (chckbxMotorista.isSelected()) {
            Cliente cliente = locacaoVeiculoRN.getClienteLocacao();
            if ( cliente != null) {                
                try {
                    if (cliente.isPessoaFisica()) {
                        setMotorista(cliente.getPessoafisica());
                    } else {
                        chckbxMotorista.setSelected(false);
                        JOptionPane.showMessageDialog(this, "Cliente PJ não pode ser motorista");
                        setMotorista();                        
                    }
                } catch (ClienteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage() );
                }
            }
        } else {
            limparCamposMotorista();
        }
    }//GEN-LAST:event_chckbxMotoristaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox chckbxMotorista;
    private javax.swing.JComboBox cmbbxPromocao;
    private javax.swing.JComboBox cmbbxTipoLocacao;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lbCpf5;
    private javax.swing.JLabel lbRg1;
    private javax.swing.JLabel lbRg2;
    private javax.swing.JLabel lbRg3;
    private javax.swing.JLabel lbRg4;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelularMotorista;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtCpfMotorista;
    private javax.swing.JTextField txtDataValidadeCnhMotorista;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailMotorista;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtKm;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeMotorista;
    private javax.swing.JTextField txtNumeroCnhMorista;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRetirada;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefoneMotorista;
    // End of variables declaration//GEN-END:variables

    private void setarCamposMotorista(Motorista motorista) {
        PessoaFisica pf = motorista.getPessoafisica();
        txtNomeMotorista.setText(pf.getNome());
        txtCpfMotorista.setText(pf.getCpf());
        txtNumeroCnhMorista.setText("");
        txtDataValidadeCnhMotorista.setText("");
        txtTelefoneMotorista.setText(pf.getTelefone1());
        txtCelularMotorista.setText(pf.getTelefone2());
        txtEmailMotorista.setText(pf.getEmail());
    }

    private void limparCamposMotorista() {
        txtNomeMotorista.setText("");
        txtCpfMotorista.setText("");
        txtNumeroCnhMorista.setText("");
        txtDataValidadeCnhMotorista.setText("");
        txtTelefoneMotorista.setText("");
        txtCelularMotorista.setText("");
        txtEmailMotorista.setText("");
    }

    private void setVeiculoTela(Veiculo veiculoLocacao) {
        if (veiculoLocacao != null) {
            txtModelo.setText(veiculoLocacao.getModelo());
            txtMarca.setText(veiculoLocacao.getMarca());
            txtPlaca.setText(veiculoLocacao.getPlaca());
            txtKm.setText(String.valueOf(veiculoLocacao.getQuilometragem()));
        }
    }
    
    private void limparCampos(){
        txtNomeMotorista.setText("");
        txtCpfMotorista.setText("");
        txtNumeroCnhMorista.setText("");
        txtDataValidadeCnhMotorista.setText("");
        txtTelefoneMotorista.setText("");
        txtCelularMotorista.setText("");
        txtEmailMotorista.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtPlaca.setText("");
        txtKm.setText("");
        txtNomeCliente.setText("");
        lbCpf.setText("");
        txtCpfCnpj.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        
    }

    private boolean validaMotorista() {
        try {
            String numeroCnh = txtNumeroCnhMorista.getText();
            if("".equals(numeroCnh.trim())){
                return false;
            }            
            Date dataValidade = DataUtil.stringToDate(txtDataValidadeCnhMotorista.getText());
            
            Motorista motorista = locacaoVeiculoRN.getMotorista();
            motorista.setDatavalidade(dataValidade);
            motorista.setRegistro(numeroCnh);            
            return true;
            
        } catch (ParseException ex) {
            return false;
        }
    }
}
