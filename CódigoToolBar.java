import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * 
 * @author Pedro
 */
// Classe base para ações da Barra de Ferramentas
abstract class AcaoBarraDeFerramentas extends AbstractAction {
    public AcaoBarraDeFerramentas(String nome) {
        super(nome); // Define o nome do botão
    }
}

// Classe para a ação "Novo"
class AcaoNovo extends AcaoBarraDeFerramentas {
    public AcaoNovo() {
        super("Novo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Novo documento criado!");
    }
}

// Classe para a ação "Abrir"
class AcaoAbrir extends AcaoBarraDeFerramentas {
    public AcaoAbrir() {
        super("Abrir");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Abrindo documento...");
    }
}

// Classe para a ação "Salvar"
class AcaoSalvar extends AcaoBarraDeFerramentas {
    public AcaoSalvar() {
        super("Salvar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Documento salvo com sucesso!");
    }
}

// Classe para a ação "Finalizar"
class AcaoFinalizar extends AcaoBarraDeFerramentas {
    public AcaoFinalizar() {
        super("Finalizar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            System.exit(0); // Finaliza o programa
        }
    }
}

public class CódigoToolBar extends JFrame {

    public CódigoToolBar() {
        // Configuração básica do JFrame
        setTitle("Exemplo de Barra de Ferramentas com Herança");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação da barra de ferramentas
        JToolBar barraDeFerramentas = new JToolBar();

        // Adiciona ações na barra de ferramentas
        barraDeFerramentas.add(new JButton(new AcaoNovo()));
        barraDeFerramentas.add(new JButton(new AcaoAbrir()));
        barraDeFerramentas.add(new JButton(new AcaoSalvar()));
        barraDeFerramentas.add(new JButton(new AcaoFinalizar()));

        // Adiciona a barra de ferramentas ao JFrame
        add(barraDeFerramentas, "North"); // Posiciona a barra de ferramentas no topo da janela

        setVisible(true);
    }

    public static void main(String[] args) {
        new CódigoToolBar();
    }
}
