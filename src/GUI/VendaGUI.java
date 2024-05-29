package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Carro;
import Controller.CarroController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;

public class VendaGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel rodape;
    private JButton btnCancelar;
    private JButton btnComprar;
    private CarroController carroController;
    private JComboBox<Integer> comboCarroId;

    public VendaGUI(String nome, String cpf, String numero, String email, String endereco) {
        this.setTitle("Detalhes da Venda");
        this.setSize(1357, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        carroController = new CarroController();  // Initialize CarroController

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getUsuarioPanel(nome, cpf, numero, email, endereco), BorderLayout.WEST);
        mainPanel.add(getPatioCarros(), BorderLayout.CENTER);  // Add car panel to main panel
        mainPanel.add(getRodape(), BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel getUsuarioPanel(String nome, String cpf, String numero, String email, String endereco) {
        JPanel usuarioPanel = new JPanel(new GridBagLayout());
        usuarioPanel.setPreferredSize(new Dimension(200, 150)); // Define o tamanho preferido
        usuarioPanel.setBackground(new Color(246, 115, 7)); // Define a cor de fundo para destaque

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 5);

        usuarioPanel.add(createLabel("Nome: ", nome), gbc);
        usuarioPanel.add(createLabel("CPF: ", cpf), gbc);
        usuarioPanel.add(createLabel("Celular: ", numero), gbc);
        usuarioPanel.add(createLabel("Email: ", email), gbc);
        usuarioPanel.add(createLabel("Endereço(CEP): ", endereco), gbc);

        return usuarioPanel;
    }

    private JPanel getPatioCarros() {
        JPanel carrosPanel = new JPanel(new BorderLayout());
        List<Carro> carros = carroController.getCarros();
    
        // Create table model
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna todas as células não editáveis
            }
        };
        model.addColumn("ID");
        model.addColumn("Modelo");
        model.addColumn("Marca");
        model.addColumn("Ano");
        model.addColumn("Quilometragem");
        // model.addColumn("Placa");
        // model.addColumn("Preço");
    
        // Fill the table model with car data
        for (Carro carro : carros) {
            model.addRow(new Object[]{
                carro.getId(), 
                carro.getModelo(), 
                carro.getMarca(), 
                carro.getAno(), 
                carro.getQuilometragem(), 
                // carro.getPlaca(), 
                // carro.getPreco()
            });
        }
    
        // Create the table
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false); // Impede que as colunas sejam reordenadas
        table.setDefaultEditor(Object.class, null); // Impede a edição de células
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Adiciona uma margem ao redor do JScrollPane
        JPanel scrollPaneContainer = new JPanel(new BorderLayout());
        scrollPaneContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adiciona uma margem de 10 pixels em todos os lados
        scrollPaneContainer.add(scrollPane, BorderLayout.CENTER);

        carrosPanel.add(scrollPaneContainer, BorderLayout.CENTER);

    
        JPanel comboBoxPanel = new JPanel(new GridBagLayout());
        comboBoxPanel.add(new JLabel("Selecionar Carro:"));
        comboBoxPanel.add(getComboBox());
    
        JPanel container = new JPanel(new BorderLayout());
        container.add(comboBoxPanel, BorderLayout.SOUTH);
        carrosPanel.add(container, BorderLayout.SOUTH);
    
        return carrosPanel;
    }
    

    private JComboBox<Integer> getComboBox() {
        comboCarroId = new JComboBox<>();
        List<Carro> carros = carroController.getCarros();
        for (Carro carro : carros) {
            comboCarroId.addItem(carro.getId());
        }
        comboCarroId.setPreferredSize(new Dimension(200, 30));  // Set preferred size for combo box
        return comboCarroId;
    }

    private JLabel createLabel(String labelText, String valueText) {
        String formattedText = String.format("<html><body style='font-family: Arial; font-size: 14px;'><b>%s</b> %s</body></html>", labelText, valueText);
        JLabel label = new JLabel(formattedText);
        label.setFont(new Font("ARIAL", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);
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

            // Adicionar eventos
            this.btnCancelar.addActionListener(this::clickBtnCancelar);
            this.btnComprar.addActionListener(this::clickBtnComprar);
        }
        return this.rodape;
    }

    private void clickBtnCancelar(ActionEvent evento) {
        dispose();
    }

    private void clickBtnComprar(ActionEvent evento) {
        // Aqui você pode definir a lógica que será executada quando o botão "Comprar" for clicado.
        // JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    public static void main(String[] args) {
        // Criar e exibir a janela VendaGUI com alguns dados de exemplo
        new VendaGUI("João Silva", "123.456.789-00", "987654321", "receba@gmail.com", "Rua Exemplo, 123");
    }
}
