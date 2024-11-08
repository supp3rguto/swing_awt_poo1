import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * 
 * @author Augusto
 */
public class Frames extends JFrame {
    private JLabel label;
    private JButton botao;

    public Frames() {

        setTitle("Exemplo de JFrame");

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Clique no botão abaixo!");
        botao = new JButton("Clique Aqui");

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Você clicou no botão!");
            }
        });

        setLayout(new java.awt.FlowLayout());
        add(label);
        add(botao);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Frames();
    }
}
