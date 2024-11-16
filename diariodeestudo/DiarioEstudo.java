import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiarioEstudo extends JFrame {
    private JPanel cards;
    private JPanel diarioPanel;
    private CardLayout cardLayout;
    private List<ImageIcon> fotosBarroco;
    private List<ImageIcon> fotosMinimalismo;
    private JLabel labelFoto;
    private int indiceAtual;
    private List<ImageIcon> fotosAtuais;
    private List<JCheckBox> tarefas;
    private JTextPane textPane;

    public DiarioEstudo() {
        setTitle("Diário de Estudo");
        setSize(1024, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tarefas = new ArrayList<>();

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel senhaPanel = criarPainelSenha();
        JPanel selecaoPanel = criarPainelSelecao();
        diarioPanel = criarPainelDiario();

        cards.add(senhaPanel, "senha");
        cards.add(selecaoPanel, "selecao");
        cards.add(diarioPanel, "diario");

        add(cards);
        cardLayout.show(cards, "senha");

        setVisible(true);
    }

    private JPanel criarPainelSenha() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel labelSenha = new JLabel("Insira a senha:", SwingConstants.CENTER);
        JPasswordField passwordField = new JPasswordField(20);
        JButton btnEntrar = new JButton("Entrar");

        String senhaCorreta = "poo1";

        btnEntrar.addActionListener(e -> {
            if (new String(passwordField.getPassword()).equals(senhaCorreta)) {
                cardLayout.show(cards, "selecao");
            } else {
                JOptionPane.showMessageDialog(this, "Senha incorreta. Tente novamente.");
            }
        });

        panel.add(labelSenha, BorderLayout.NORTH);
        panel.add(passwordField, BorderLayout.CENTER);
        panel.add(btnEntrar, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel criarPainelSelecao() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel botoesPanel = new JPanel();

        ImageIcon imgBarroco = new ImageIcon("barrocotitulo.jpg");
        ImageIcon imgMinimalismo = new ImageIcon("minimalismotitulo.jpg");

        JButton btnBarroco = new JButton(imgBarroco);
        JButton btnMinimalismo = new JButton(imgMinimalismo);

        btnBarroco.setBorder(BorderFactory.createEmptyBorder());
        btnMinimalismo.setBorder(BorderFactory.createEmptyBorder());

        btnBarroco.addActionListener(e -> {
            fotosAtuais = fotosBarroco;
            indiceAtual = 0;
            atualizarFoto();
            cardLayout.show(cards, "diario");
        });

        btnMinimalismo.addActionListener(e -> {
            fotosAtuais = fotosMinimalismo;
            indiceAtual = 0;
            atualizarFoto();
            cardLayout.show(cards, "diario");
        });

        botoesPanel.add(btnBarroco);
        botoesPanel.add(btnMinimalismo);

        JButton btnSairDoPrograma = new JButton("Sair");
        btnSairDoPrograma.addActionListener(e -> System.exit(0));

        panel.add(botoesPanel, BorderLayout.CENTER);
        panel.add(btnSairDoPrograma, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel criarPainelDiario() {
        fotosBarroco = new ArrayList<>();
        fotosMinimalismo = new ArrayList<>();

        fotosBarroco.add(new ImageIcon("barroco1.png"));
        fotosBarroco.add(new ImageIcon("barroco2.png"));
        fotosBarroco.add(new ImageIcon("barroco3.jpg"));
        fotosBarroco.add(new ImageIcon("barroco4.jpg"));
        fotosBarroco.add(new ImageIcon("barroco5.jpg"));
        fotosBarroco.add(new ImageIcon("barroco6.jpg"));

        fotosMinimalismo.add(new ImageIcon("minima1.jpg"));
        fotosMinimalismo.add(new ImageIcon("minima2.jpg"));
        fotosMinimalismo.add(new ImageIcon("minima3.jpg"));
        fotosMinimalismo.add(new ImageIcon("minima4.jpg"));
        fotosMinimalismo.add(new ImageIcon("minima5.jpg"));
        fotosMinimalismo.add(new ImageIcon("minima6.jpg"));

        indiceAtual = 0;
        fotosAtuais = fotosBarroco;

        JToolBar toolBar = new JToolBar();
        JButton btnVoltarMenu = new JButton("Voltar ao Menu");
        JButton btnTarefas = new JButton("Tarefas");
        JButton btnSalvarTexto = new JButton("Salvar Texto");

        toolBar.add(btnVoltarMenu);
        toolBar.add(btnTarefas);
        toolBar.add(btnSalvarTexto);

        btnVoltarMenu.addActionListener(e -> cardLayout.show(cards, "selecao"));
        btnTarefas.addActionListener(e -> abrirPainelTarefas());
        btnSalvarTexto.addActionListener(e -> salvarTextoEmArquivo());

        JCheckBox chkNegrito = new JCheckBox("Negrito");
        JCheckBox chkItalico = new JCheckBox("Itálico");
        JCheckBox chkSublinhado = new JCheckBox("Sublinhado");

        toolBar.add(chkNegrito);
        toolBar.add(chkItalico);
        toolBar.add(chkSublinhado);

        chkNegrito.addActionListener(e -> atualizarFormatoTexto(chkNegrito, chkItalico, chkSublinhado));
        chkItalico.addActionListener(e -> atualizarFormatoTexto(chkNegrito, chkItalico, chkSublinhado));
        chkSublinhado.addActionListener(e -> atualizarFormatoTexto(chkNegrito, chkItalico, chkSublinhado));

        textPane = new JTextPane();
        JScrollPane scrollTextPane = new JScrollPane(textPane);
        scrollTextPane.setPreferredSize(new Dimension(450, 500));

        JPanel photoPanel = new JPanel();
        photoPanel.setLayout(new BoxLayout(photoPanel, BoxLayout.X_AXIS));

        JButton btnAnterior = new JButton("<");
        btnAnterior.addActionListener(e -> {
            if (indiceAtual > 0) {
                indiceAtual--;
            } else {
                indiceAtual = fotosAtuais.size() - 1;
            }
            atualizarFoto();
        });

        JButton btnProximo = new JButton(">");
        btnProximo.addActionListener(e -> {
            if (indiceAtual < fotosAtuais.size() - 1) {
                indiceAtual++;
            } else {
                indiceAtual = 0;
            }
            atualizarFoto();
        });

        labelFoto = new JLabel();
        atualizarFoto();

        photoPanel.add(btnAnterior);
        photoPanel.add(labelFoto);
        photoPanel.add(btnProximo);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(toolBar, BorderLayout.NORTH);
        mainPanel.add(scrollTextPane, BorderLayout.WEST);
        mainPanel.add(photoPanel, BorderLayout.CENTER);

        return mainPanel;
    }

    private void abrirPainelTarefas() {
        JFrame tarefaFrame = new JFrame("Tarefas");
        tarefaFrame.setSize(400, 300);
        tarefaFrame.setLocationRelativeTo(null);
        tarefaFrame.setLayout(new BorderLayout());

        JPanel tarefasPanel = new JPanel();
        tarefasPanel.setLayout(new BoxLayout(tarefasPanel, BoxLayout.Y_AXIS));

        for (JCheckBox tarefa : tarefas) {
            tarefasPanel.add(tarefa);
        }

        JButton btnAdicionarTarefa = new JButton("Adicionar Tarefa");
        btnAdicionarTarefa.addActionListener(e -> {
            String novaTarefa = JOptionPane.showInputDialog("Digite a nova tarefa:");
            if (novaTarefa != null && !novaTarefa.trim().isEmpty()) {
                JCheckBox checkboxTarefa = new JCheckBox(novaTarefa);
                tarefas.add(checkboxTarefa);
                tarefasPanel.add(checkboxTarefa);
                tarefasPanel.revalidate();
            }
        });

        JButton btnDeletarTarefas = new JButton("Deletar Tarefas Selecionadas");
        btnDeletarTarefas.addActionListener(e -> {
            tarefas.removeIf(tarefa -> {
                if (tarefa.isSelected()) {
                    tarefasPanel.remove(tarefa);
                    return true;
                }
                return false;
            });
            tarefasPanel.revalidate();
            tarefasPanel.repaint();
        });

        JButton btnSalvarESair = new JButton("Sair e Salvar");
        btnSalvarESair.addActionListener(e -> tarefaFrame.dispose());

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(btnAdicionarTarefa);
        botoesPanel.add(btnDeletarTarefas);
        botoesPanel.add(btnSalvarESair);

        tarefaFrame.add(new JScrollPane(tarefasPanel), BorderLayout.CENTER);
        tarefaFrame.add(botoesPanel, BorderLayout.SOUTH);
        tarefaFrame.setVisible(true);
    }

    private void atualizarFormatoTexto(JCheckBox chkNegrito, JCheckBox chkItalico, JCheckBox chkSublinhado) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet atributos = new SimpleAttributeSet();

        StyleConstants.setBold(atributos, chkNegrito.isSelected());
        StyleConstants.setItalic(atributos, chkItalico.isSelected());
        StyleConstants.setUnderline(atributos, chkSublinhado.isSelected());

        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();

        if (start != end) {
            doc.setCharacterAttributes(start, end - start, atributos, false);
        } else {
            textPane.setCharacterAttributes(atributos, false);
        }
    }

    private void salvarTextoEmArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Texto");

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write(textPane.getText());
                JOptionPane.showMessageDialog(this, "Texto salvo com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o texto: " + ex.getMessage());
            }
        }
    }

    private void atualizarFoto() {
        labelFoto.setIcon(fotosAtuais.get(indiceAtual));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DiarioEstudo::new);
    }
}
