package GUI;

import javax.swing.*;
import java.awt.*;

import model.Carro;

public class ReciboGUI extends JFrame {
    private JLabel lblNome;
    private JLabel lblCPF;
    private JLabel lblNumero;
    private JLabel lblEmail;
    private JLabel lblEndereco;
    private JLabel lblCarro;
    private JLabel lblFormaPagamento;

    public ReciboGUI(String nome, String cpf, String numero, String email, String endereco, Carro selectedCar, int formaPagamento) {
        setTitle("Recibo da Compra");
        setSize(600, 300); // Increased width to accommodate side by side layout
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add user information labels
        JPanel userInfoPanel = new JPanel(new GridLayout(0, 1));
        userInfoPanel.setBorder(BorderFactory.createTitledBorder("Informações do Usuário"));
        lblNome = new JLabel("Nome: " + nome);
        lblCPF = new JLabel("CPF: " + cpf);
        lblNumero = new JLabel("Número: " + numero);
        lblEmail = new JLabel("Email: " + email);
        lblEndereco = new JLabel("Endereço: " + endereco);
        userInfoPanel.add(lblNome);
        userInfoPanel.add(lblCPF);
        userInfoPanel.add(lblNumero);
        userInfoPanel.add(lblEmail);
        userInfoPanel.add(lblEndereco);
        panel.add(userInfoPanel, gbc);


        String formaPagamentoStr;
        if (formaPagamento == 1) {
            formaPagamentoStr = "Á vista(Dinheiro)";
        } else if (formaPagamento == 2) {
            formaPagamentoStr = "Á vista(Cartão)";
        } else {
            formaPagamentoStr = "Cartão de Crédito";
        }



        // Add purchase information labels
        JPanel purchaseInfoPanel = new JPanel(new GridLayout(0, 1));
        purchaseInfoPanel.setBorder(BorderFactory.createTitledBorder("Informações da Compra"));
        lblCarro = new JLabel((selectedCar != null ? selectedCar.getModelo() + " " + selectedCar.getMarca() + " " + selectedCar.getAno() + " " + selectedCar.getQuilometragem() + " " + selectedCar.getCategoria() + " " + " " + selectedCar.getPlaca() + " " + selectedCar.getPreco() + " " : "Nenhum carro selecionado"));

  
        lblFormaPagamento = new JLabel("Forma de Pagamento: " + formaPagamentoStr); // Example label, you can adjust this as needed
        purchaseInfoPanel.add(lblCarro);
        purchaseInfoPanel.add(lblFormaPagamento);
        gbc.gridx = 1;
        panel.add(purchaseInfoPanel, gbc);

        add(panel);
    }

    public static void main(String[] args) {
        // Example usage
        Carro selectedCar = new Carro(1, "Toyota", "Corolla", 2020, 15000, "Sedan", "LMN-0123", 90000.00);
        ReciboGUI reciboGUI = new ReciboGUI("João", "123.456.789-00", "123456789", "joao@example.com", "Rua Exemplo, 123", selectedCar, 1);
        reciboGUI.setVisible(true);
    }
}
