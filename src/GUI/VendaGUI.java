package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class VendaGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel rodape;
    private JButton btnCancelar;
    private JButton btnComprar;

    public VendaGUI(String nome, String cpf, String numero, String endereco) {
        this.setTitle("Detalhes da Venda");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(getUsuarioPanel(nome, cpf, numero, endereco), BorderLayout.WEST);
        mainPanel.add(getRodape(), BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }

    private JPanel getUsuarioPanel(String nome, String cpf, String numero, String endereco) {
        JPanel usuarioPanel = new JPanel(new GridBagLayout());
        usuarioPanel.setPreferredSize(new Dimension(200, 150)); // Define o tamanho preferido
        usuarioPanel.setBackground(new Color(30, 144, 255)); // Define a cor de fundo para destaque

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        usuarioPanel.add(createLabel("Nome: ", nome), gbc);
        usuarioPanel.add(createLabel("CPF: ", cpf), gbc);
        usuarioPanel.add(createLabel("Número: ", numero), gbc);
        usuarioPanel.add(createLabel("Endereço: ", endereco), gbc);

        return usuarioPanel;
    }

    private JLabel createLabel(String labelText, String valueText) {
        String formattedText = String.format("<html><body style='font-family: Arial; font-size: 14px;'><b>%s</b> %s</body></html>", labelText, valueText);
        JLabel label = new JLabel(formattedText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.BLACK);
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
        JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    public static void main(String[] args) {
        // Criar e exibir a janela VendaGUI com alguns dados de exemplo
        new VendaGUI("João Silva", "123.456.789-00", "987654321", "Rua Exemplo, 123");
    }
}
