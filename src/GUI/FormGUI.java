package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import Controller.ClienteController;
import model.Cliente;

public class FormGUI extends JFrame {
    
    private JPanel form;
    private JPanel rodape;
    private JButton btnLimpar;
    private JButton btnCadastrar;
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblCpf;
    private JTextField txtCpf;
    private JLabel lblNumero;
    private JTextField txtNumero;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblEndereco;
    private JTextField txtEndereco;
    
    public ClienteController pessoaCtrl;
    
    public FormGUI(ClienteController pessoaCtrl) {
        this.pessoaCtrl = pessoaCtrl;
        this.criarEMostrarGUI();
    }
    
    private void criarEMostrarGUI() {
        this.setTitle("Cadastro de pessoa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define a cor de fundo da janela
        this.getForm().setBackground(new Color(246, 115, 7));
        this.setBackground(new Color(246, 115, 7));
        
        this.setLayout(new BorderLayout());
        this.getContentPane().add(this.getRodape(), BorderLayout.PAGE_END);
        this.setForeground(Color.white);
        
        // Cria um JPanel para conter a imagem
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("./miscellaneous/banner2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        
        imagePanel.add(imageLabel);
        this.getContentPane().add(imagePanel, BorderLayout.CENTER);
        this.getContentPane().add(this.getForm(), BorderLayout.LINE_END);
        
        this.eventos();
        this.pack();
        this.setSize(900, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    private JPanel getForm() {
        if(this.form == null) {
            this.form = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            
            // Creating and setting text color to white for labels and text fields
            this.lblNome = new JLabel("Nome:");
            this.lblNome.setForeground(Color.WHITE);
            this.txtNome = new JTextField(15);
            this.txtNome.setForeground(Color.BLACK);
            
            this.lblCpf = new JLabel("CPF:");
            this.lblCpf.setForeground(Color.WHITE);
            this.txtCpf = new JTextField(15);
            this.txtCpf.setForeground(Color.BLACK);

            this.lblNumero = new JLabel("Número:");
            this.lblNumero.setForeground(Color.WHITE);
            this.txtNumero = new JTextField(15);
            this.txtNumero.setForeground(Color.BLACK);
      
            this.lblEmail = new JLabel("Email:");
            this.lblEmail.setForeground(Color.WHITE);
            this.txtEmail = new JTextField(15);
            this.txtEmail.setForeground(Color.BLACK);

            this.lblEndereco = new JLabel("Endereço(CEP):");
            this.lblEndereco.setForeground(Color.WHITE);
            this.txtEndereco = new JTextField(15);
            this.txtEndereco.setForeground(Color.BLACK);

            
            // Adicionar componentes ao painel com posicionamento
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.form.add(this.lblNome, gbc);
            
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 1;
            gbc.gridy = 0;
            this.form.add(this.txtNome, gbc);
            
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.form.add(this.lblCpf, gbc);
            
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 1;
            gbc.gridy = 1;
            this.form.add(this.txtCpf, gbc);
            
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0;
            gbc.gridy = 2;
            this.form.add(this.lblNumero, gbc);
            
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 1;
            gbc.gridy = 2;
            this.form.add(this.txtNumero, gbc);

            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0;
            gbc.gridy = 3; // Moved email label to row 3
            this.form.add(this.lblEmail, gbc);
            
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 1;
            gbc.gridy = 3; // Moved email text field to row 3
            this.form.add(this.txtEmail, gbc);

            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 0;
            gbc.gridy = 4;
            this.form.add(this.lblEndereco, gbc);
            
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx = 1;
            gbc.gridy = 4;
            this.form.add(this.txtEndereco, gbc);
        }
        return this.form;
    }
    
    private JPanel getRodape() {
        if(this.rodape == null) {
            this.rodape = new JPanel();
            this.btnLimpar = new JButton("Limpar");
            this.btnLimpar.setMnemonic(KeyEvent.VK_L);
            this.btnCadastrar = new JButton("Cadastrar");
            this.btnCadastrar.setMnemonic(KeyEvent.VK_ENTER);
            this.rodape.add(this.btnLimpar);
            this.rodape.add(this.btnCadastrar);
            this.rodape.setBackground(Color.DARK_GRAY);
        }
        return this.rodape;
    }
    
    private void eventos() {
        this.btnLimpar.addActionListener(this::clickBtnLimpar);
        this.btnCadastrar.addActionListener(this::clickBtnCadastrar);
    }
    
    private void clickBtnLimpar(ActionEvent evento) {
        this.txtNome.setText("");
        this.txtCpf.setText("");
        this.txtNumero.setText("");
        this.txtEndereco.setText("");
    }
    
    private void clickBtnCadastrar(ActionEvent evento) {
        if(this.txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this.form,"O campo Nome é obrigatório","Dados inválidos",JOptionPane.ERROR_MESSAGE);
        } else if(this.txtCpf.getText().equals("")) {
                JOptionPane.showMessageDialog(this.form,"O campo CPF é obrigatório","Dados inválidos",JOptionPane.ERROR_MESSAGE);
        } else if(this.txtNumero.getText().equals("")) {
                JOptionPane.showMessageDialog(this.form,"O campo Número é obrigatório","Dados inválidos",JOptionPane.ERROR_MESSAGE);
        } else if(this.txtEndereco.getText().equals("")) {
                JOptionPane.showMessageDialog(this.form,"O campo Endereço é obrigatório","Dados inválidos",JOptionPane.ERROR_MESSAGE);
        } else {
            Cliente pessoa = new Cliente(this.txtNome.getText(), this.txtCpf.getText(), this.txtNumero.getText(), this.txtEmail.getText(), this.txtEndereco.getText());
            this.pessoaCtrl.add(pessoa);
            this.pessoaCtrl.listar();
            
            new VendaGUI(this.txtNome.getText(), this.txtCpf.getText(), this.txtNumero.getText(), this.txtEmail.getText(), this.txtEndereco.getText());
            this.clickBtnLimpar(evento); // Limpa os campos após cadastrar
            this.dispose();
        }
    }
    

    public static void main(String[] args) {
        ClienteController pessoaCtrl = new ClienteController();
        new FormGUI(pessoaCtrl).setVisible(true);

        
    }
}
