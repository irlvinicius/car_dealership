package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import model.Carro;
import Controller.CarroController;

public class VendaGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel rodape;
    private JButton btnCancelar;
    private JButton btnComprar;
    private CarroController carroController;
    private JComboBox<Integer> comboCarroId;
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtNumero;
    private JTextField txtEmail;
    private JTextField txtEndereco;
    
    // Adicionando ButtonGroup como um campo da classe
    private ButtonGroup buttonGroup;

    public VendaGUI(String nome, String cpf, String numero, String email, String endereco) {
        this.setTitle("Detalhes da Venda");
        this.setSize(959, 680);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        carroController = new CarroController();

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getUsuarioPanel(nome, cpf, numero, email, endereco), BorderLayout.WEST);
        mainPanel.add(getPatioCarros(), BorderLayout.CENTER);
        mainPanel.add(getRodape(), BorderLayout.SOUTH);

        // Inicializar campos de texto
        txtNome = new JTextField(nome);
        txtCPF = new JTextField(cpf);
        txtNumero = new JTextField(numero);
        txtEmail = new JTextField(email);
        txtEndereco = new JTextField(endereco);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel getUsuarioPanel(String nome, String cpf, String numero, String email, String endereco) {
        JPanel usuarioPanel = new JPanel(new GridBagLayout());
        usuarioPanel.setBackground(new Color(246, 115, 7));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        usuarioPanel.add(createLabel("Nome: "), gbc);

        gbc.gridy++;
        usuarioPanel.add(createLabel("CPF: "), gbc);

        gbc.gridy++;
        usuarioPanel.add(createLabel("Celular: "), gbc);

        gbc.gridy++;
        usuarioPanel.add(createLabel("Email: "), gbc);

        gbc.gridy++;
        usuarioPanel.add(createLabel("Endereço (CEP): "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        usuarioPanel.add(createValueLabel(nome), gbc);

        gbc.gridy++;
        usuarioPanel.add(createValueLabel(cpf), gbc);

        gbc.gridy++;
        usuarioPanel.add(createValueLabel(numero), gbc);

        gbc.gridy++;
        usuarioPanel.add(createValueLabel(email), gbc);

        gbc.gridy++;
        usuarioPanel.add(createValueLabel(endereco), gbc);

        return usuarioPanel;
    }

    private JPanel getPatioCarros() {
        JPanel carrosPanel = new JPanel(new BorderLayout());
        List<Carro> carros = carroController.getCarros();

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("Modelo");
        model.addColumn("Marca");
        model.addColumn("Ano");
        model.addColumn("Quilometragem");
        model.addColumn("Preco");

        for (Carro carro : carros) {
            model.addRow(new Object[]{
                    carro.getId(),
                    carro.getModelo(),
                    carro.getMarca(),
                    carro.getAno(),
                    carro.getQuilometragem(),
                    carro.getPreco()
            });
        }

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel scrollPaneContainer = new JPanel(new BorderLayout());
        scrollPaneContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

        carrosPanel.add(scrollPaneContainer, BorderLayout.CENTER);

        JPanel selectionPanel = new JPanel(new BorderLayout());

        JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        comboBoxPanel.add(new JLabel("Selecionar Carro:   "));
        comboBoxPanel.add(getComboBox());

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(new JLabel("Forma de pagamento:   "));
        radioPanel.add(getFormaPagamento());

        selectionPanel.add(comboBoxPanel, BorderLayout.NORTH);
        selectionPanel.add(radioPanel, BorderLayout.SOUTH);

        carrosPanel.add(selectionPanel, BorderLayout.SOUTH);

        return carrosPanel;
    }

    private JPanel getFormaPagamento() {
        JPanel radioPanel = new JPanel(new GridLayout(1, 3));
    
        JRadioButton vistaDinheiro = new JRadioButton("À vista (dinheiro)");
        JRadioButton vistaCartao = new JRadioButton("À vista (cartão)");
        JRadioButton cartaoCredito = new JRadioButton("Cartão de crédito");
    
        // Definindo os ActionCommand como valores inteiros
        vistaDinheiro.setActionCommand("1");
        vistaCartao.setActionCommand("2");
        cartaoCredito.setActionCommand("3");
    
        buttonGroup = new ButtonGroup();
        buttonGroup.add(vistaDinheiro);
        buttonGroup.add(vistaCartao);
        buttonGroup.add(cartaoCredito);
    
        radioPanel.add(vistaDinheiro);
        radioPanel.add(vistaCartao);
        radioPanel.add(cartaoCredito);
    
        return radioPanel;
    }
    

    // Método para obter a forma de pagamento selecionada como um inteiro
    private int getSelectedFormaPagamento() {
        if (buttonGroup.getSelection() != null) {
            return Integer.parseInt(buttonGroup.getSelection().getActionCommand());
        }
        return -1; // ou outra indicação de que nada foi selecionado
    }


    private JComboBox<Integer> getComboBox() {
        comboCarroId = new JComboBox<>();
        comboCarroId.addItem(null);
        List<Carro> carros = carroController.getCarros();
        for (Carro carro : carros) {
            comboCarroId.addItem(carro.getId());
        }
        comboCarroId.setPreferredSize(new Dimension(50, 30));
        return comboCarroId;
    }

    private JLabel createLabel(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    private JLabel createValueLabel(String valueText) {
        JLabel label = new JLabel(valueText);
        label.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    private JPanel getRodape() {
        if (this.rodape == null) {
            this.rodape = new JPanel();
            this.btnCancelar = new JButton("Cancelar");
            this.btnCancelar.setMnemonic(KeyEvent.VK_C);
            this.btnComprar = new JButton("Comprar");
            this.btnComprar.setMnemonic(KeyEvent.VK_ENTER);
            this.rodape.add(this.btnCancelar);
            this.rodape.add(this.btnComprar);
            this.rodape.setBackground(Color.GRAY);

            this.btnCancelar.addActionListener(this::clickBtnCancelar);
            this.btnComprar.addActionListener(this::clickBtnComprar);
        }
        return this.rodape;
    }

    private void clickBtnCancelar(ActionEvent evento) {
        dispose();
    }

    private void clickBtnComprar(ActionEvent event) {
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        String numero = txtNumero.getText();
        String email = txtEmail.getText();
        String endereco = txtEndereco.getText();
    
        Integer carroId = (Integer) comboCarroId.getSelectedItem();
    
        if (carroId == null) {
            JOptionPane.showMessageDialog(this, "Selecione um Carro para a Compra", "Dados inválidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    
        int formaPagamento = getSelectedFormaPagamento();
    
        if (formaPagamento == -1) {
            JOptionPane.showMessageDialog(this, "Selecione a forma de pagamento!", "Dados inválidos", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {

        }
    
        // Criar um objeto ReciboGUI com os valores preenchidos
        new ReciboGUI(nome, cpf, numero, email, endereco, carroId, formaPagamento);
        // Fechar a janela VendaGUI
        dispose();
    }

    public static void main(String[] args) {
        new VendaGUI("Vinícius Vieira de Lima", "123.456.789-00", "987654321", "vieira.lma10@gmail.com", "51059790");
    }
}
