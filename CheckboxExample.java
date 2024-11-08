import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * 
 * @author Emanoel
 */
public class CheckboxExample extends JFrame {
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JButton button;

    public CheckboxExample() {
        // Configuração da janela
        setTitle("Exemplo de JCheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Criação dos checkboxes
        checkBox1 = new JCheckBox("Opção 1");
        checkBox2 = new JCheckBox("Opção 2");
        checkBox3 = new JCheckBox("Opção 3");

        // Criação do botão
        button = new JButton("Mostrar Seleção");

        // Adicionando componentes à janela
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);
        add(button);

        // Adicionando ação ao botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Seleções:\n";
                if (checkBox1.isSelected()) {
                    message += "Opção 1\n";
                }
                if (checkBox2.isSelected()) {
                    message += "Opção 2\n";
                }
                if (checkBox3.isSelected()) {
                    message += "Opção 3\n";
                }
                if (!checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected()) {
                    message += "Nenhuma opção selecionada";
                }
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CheckboxExample example = new CheckboxExample();
            example.setVisible(true);
        });
    }
}