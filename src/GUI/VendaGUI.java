package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VendaGUI extends JFrame {
    private JPanel panel;
    
    public VendaGUI(String nome, String cpf, String numero, String endereco) {
        this.setTitle("Detalhes da Venda");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel = new JPanel();
        panel.add(new JLabel("Nome: " + nome));
        panel.add(new JLabel("CPF: " + cpf));
        panel.add(new JLabel("Número: " + numero));
        panel.add(new JLabel("Endereço: " + endereco));
        
        this.add(panel);
        this.setVisible(true);
    }
}
