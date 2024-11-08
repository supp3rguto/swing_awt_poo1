import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
/*
 * 
 * @author Augusto
 */
public class PasswordField {
    private JPasswordField passwordField;
    private JButton loginButton;

    public PasswordField() {
        JFrame frame = new JFrame("Login");
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                if (isPasswordCorrect(password)) {
                    JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                Arrays.fill(password, '0');
            }
        });

        JPanel panel = new JPanel();
        panel.add(passwordField);
        panel.add(loginButton);
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private boolean isPasswordCorrect(char[] input) {
        String correctPassword = "12345";
        return new String(input).equals(correctPassword);
    }

    public static void main(String[] args) {
        new PasswordField();
    }
}