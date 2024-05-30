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
    private JLabel lblCarroModelo;
    private JLabel lblCarroMarca;
    private JLabel lblCarroAno;
    private JLabel lblCarroQuilometragem;
    private JLabel lblCarroCategoria;
    private JLabel lblCarroPlaca;
    private JLabel lblTotalPago;
    private JLabel lblFormaPagamento;
    private JLabel lblMensagem;

    public ReciboGUI(String nome, String cpf, String numero, String email, String endereco, Carro selectedCar, int formaPagamento) {
        setTitle("Recibo da Compra");
        setSize(800, 350); // Aumentou a altura para acomodar a mensagem de sucesso
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new GradientPanel();
        panel.setLayout(new GridLayout(2, 1)); 

        JPanel userInfoPanel = new JPanel(new GridLayout(0, 1)); 
        userInfoPanel.setOpaque(false); 
        JPanel purchaseInfoPanel = new JPanel(new GridLayout(0, 1)); 
        purchaseInfoPanel.setOpaque(false); 

        // Adiciona a mensagem de sucesso
        lblMensagem = new JLabel("Compra realizada com sucesso!");
        lblMensagem.setFont(new Font(lblMensagem.getFont().getName(), Font.BOLD, 32)); 
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER); 
        panel.add(lblMensagem);

        // Rótulos de informações do usuário
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

        // Rótulos de informações da compra
        purchaseInfoPanel.setBorder(BorderFactory.createTitledBorder("Informações da Compra"));
        lblCarroModelo = new JLabel("Modelo: " + (selectedCar != null ? selectedCar.getModelo() : "N/A"));
        lblCarroMarca = new JLabel("Marca: " + (selectedCar != null ? selectedCar.getMarca() : "N/A"));
        lblCarroAno = new JLabel("Ano: " + (selectedCar != null ? selectedCar.getAno() : "N/A"));
        lblCarroQuilometragem = new JLabel("Quilometragem: " + (selectedCar != null ? selectedCar.getQuilometragem() : "N/A"));
        lblCarroCategoria = new JLabel("Categoria: " + (selectedCar != null ? selectedCar.getCategoria() : "N/A"));
        lblCarroPlaca = new JLabel("Placa: " + (selectedCar != null ? selectedCar.getPlaca() : "N/A"));
        lblTotalPago = new JLabel("Total pago: R$" + (selectedCar != null ? selectedCar.getPreco() : "0.00"));
        lblTotalPago.setFont(new Font(lblTotalPago.getFont().getName(), Font.BOLD, lblTotalPago.getFont().getSize())); 
        
        String formaPagamentoStr;
        if (formaPagamento == 1) {
            formaPagamentoStr = "À vista (Dinheiro)";
        } else if (formaPagamento == 2) {
            formaPagamentoStr = "À vista (Cartão)";
        } else {
            formaPagamentoStr = "Cartão de Crédito";
        }
        lblFormaPagamento = new JLabel("Forma de Pagamento: " + formaPagamentoStr);

        // Adiciona os rótulos aos painéis de informações do usuário e da compra
        purchaseInfoPanel.add(lblCarroModelo);
        purchaseInfoPanel.add(lblCarroMarca);
        purchaseInfoPanel.add(lblCarroAno);
        purchaseInfoPanel.add(lblCarroQuilometragem);
        purchaseInfoPanel.add(lblCarroCategoria);
        purchaseInfoPanel.add(lblCarroPlaca);
        purchaseInfoPanel.add(lblTotalPago);
        purchaseInfoPanel.add(lblFormaPagamento);

        // Adiciona os painéis de informações do usuário e da compra ao painel principal
        JPanel infoPanel = new JPanel(new GridLayout(1, 2)); // Painel para informações do usuário e da compra lado a lado
        infoPanel.setOpaque(false); // Tornar o painel transparente para ver o gradiente
        infoPanel.add(userInfoPanel);
        infoPanel.add(purchaseInfoPanel);
        panel.add(infoPanel);

        // Adiciona o painel principal ao frame
        add(panel);
    }

    // Painel personalizado com gradiente
    class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(246, 115, 7);
            Color color2 = getBackground(); // Cor padrão do sistema
            GradientPaint gp = new GradientPaint(0, 0, color1, width, 0, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
}