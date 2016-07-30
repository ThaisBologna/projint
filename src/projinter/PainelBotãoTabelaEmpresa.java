package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelBotãoTabelaEmpresa extends JPanel {
    
    public static final String CRIAEVT = "cria";
    public static final String EDITAEVT = "edita";
    public static final String DELETAEVT = "deleta";

    private Font font = new Font("Impact", Font.PLAIN, 22);
    private JButton btnCriarEvento, btnDeletarEvento, btnEditarEvento;

    public PainelBotãoTabelaEmpresa(ActionListener lstCriarEvento, ActionListener lstEditaEvento, ActionListener lstDeletaEvento) {
        setLayout(null);
        setSize(680, 60);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        btnCriarEvento = new JButton("CRIAR EVENTO");
        btnCriarEvento.setBackground(Color.DARK_GRAY);
        btnCriarEvento.setForeground(Color.WHITE);
        btnCriarEvento.setBounds(10, 10, 213, 40);
        btnCriarEvento.setFont(font);
        btnCriarEvento.setVisible(true);
        btnCriarEvento.addActionListener(lstCriarEvento);
        btnCriarEvento.setActionCommand(CRIAEVT);
        this.add(btnCriarEvento);

        btnEditarEvento = new JButton("EDITAR EVENTO");
        btnEditarEvento.setBackground(Color.DARK_GRAY);
        btnEditarEvento.setForeground(Color.WHITE);
        btnEditarEvento.setBounds(233, 10, 213, 40);
        btnEditarEvento.setFont(font);
        btnEditarEvento.setVisible(true);
        btnEditarEvento.addActionListener(lstEditaEvento);
        btnEditarEvento.setActionCommand(EDITAEVT);
        this.add(btnEditarEvento);

        btnDeletarEvento = new JButton("REMOVER EVENTO");
        btnDeletarEvento.setBackground(Color.DARK_GRAY);
        btnDeletarEvento.setForeground(Color.WHITE);
        btnDeletarEvento.setBounds(456, 10, 213, 40);
        btnDeletarEvento.setFont(font);
        btnDeletarEvento.setVisible(true);
        btnDeletarEvento.addActionListener(lstDeletaEvento);
        btnDeletarEvento.setActionCommand(DELETAEVT);
        this.add(btnDeletarEvento);
    }

}
