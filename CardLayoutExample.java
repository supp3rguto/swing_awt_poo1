import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * 
 * @author Emanoel
 */
public class CardLayoutExample extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CardLayoutExample() {
        // Configuração da janela
        setTitle("Exemplo de CardLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Criação do CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Adicionando cartões ao CardLayout
        cardPanel.add(createCard("Card 1 Esse card é de uma Biblioteca"), "1");
        cardPanel.add(createCard("Card 2"), "2");
        cardPanel.add(createCard("Card 3"), "3");

        // Criação dos botões de navegação
        JPanel buttonPanel = new JPanel();
        JButton nextButton = new JButton("Próximo");
        JButton prevButton = new JButton("Anterior");

        // Adicionando ação aos botões
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
        });

        // Adicionando botões ao painel de botões
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        // Adicionando painéis ao JFrame
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createCard(String text) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(text));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardLayoutExample example = new CardLayoutExample();
            example.setVisible(true);
        });
    }
}