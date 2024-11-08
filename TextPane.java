import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/*
 * 
 * @author Augusto
 */
public class TextPane {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTextPane");
        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();

        Style boldStyle = textPane.addStyle("BoldStyle", null);
        StyleConstants.setBold(boldStyle, true);
        try {
            doc.insertString(doc.getLength(), "Texto em NEGRITO.\n", boldStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Style italicStyle = textPane.addStyle("ItalicStyle", null);
        StyleConstants.setItalic(italicStyle, true);
        try {
            doc.insertString(doc.getLength(), "Texto em ITÁLICO.\n", italicStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Style colorStyle = textPane.addStyle("ColorStyle", null);
        StyleConstants.setForeground(colorStyle, Color.GREEN);
        try {
            doc.insertString(doc.getLength(), "Texto em VERDE.\n", colorStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Style largeFontStyle = textPane.addStyle("LargeFontStyle", null);
        StyleConstants.setFontSize(largeFontStyle, 32);
        try {
            doc.insertString(doc.getLength(), "Texto com FONTE GRANDE.\n", largeFontStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Style backgroundUnderlineStyle = textPane.addStyle("BackgroundUnderlineStyle", null);
        StyleConstants.setBackground(backgroundUnderlineStyle, Color.YELLOW);
        StyleConstants.setUnderline(backgroundUnderlineStyle, true);
        try {
            doc.insertString(doc.getLength(), "Texto SUBLINHADO com fundo AMARELO.\n", backgroundUnderlineStyle);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.add(new JScrollPane(textPane), BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
