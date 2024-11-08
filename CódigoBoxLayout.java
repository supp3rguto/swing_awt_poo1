import javax.swing.*;
import java.awt.*;
/*
 * 
 * @author Pedro
 */
public class CódigoBoxLayout extends JFrame {

    public CódigoBoxLayout() {
        // Configurações do JFrame
        setTitle("Exemplo Avançado de BoxLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);


        JButton button1 = new JButton("Botão Centralizado");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setBackground(Color.LIGHT_GRAY);

        JButton button2 = new JButton("Botão Alinhado à Esquerda");
        button2.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2.setBackground(Color.CYAN);

        JButton button3 = new JButton("Botão Alinhado à Direita");
        button3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        button3.setBackground(Color.PINK);

        
        mainPanel.add(button1);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(button2);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(button3);

        
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));
        horizontalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        horizontalPanel.add(Box.createHorizontalGlue());
        horizontalPanel.add(new JButton("Esquerda"));
        horizontalPanel.add(Box.createHorizontalStrut(20)); // Espaço fixo
        horizontalPanel.add(new JButton("Centro"));
        horizontalPanel.add(Box.createHorizontalStrut(20)); // Espaço fixo
        horizontalPanel.add(new JButton("Direita"));
        horizontalPanel.add(Box.createHorizontalGlue());
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(horizontalPanel);

        
        mainPanel.add(Box.createVerticalGlue());

        

        // Torna a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Cria uma nova instância da janela
        new CódigoBoxLayout();
    }
}
