package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelBotãoTabelaBanda extends JPanel {
    
    public static final String ACEITA = "aceitar";
    public static final String RECUSA = "recusar";

    private Font font = new Font("Impact", Font.PLAIN, 22);
    private JButton btnRecusarEvt, btnAceitarEvt;

    public PainelBotãoTabelaBanda(ActionListener lstCriarEvento, ActionListener lstEditaEvento) {
        setLayout(null);
        setSize(680, 60);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        btnRecusarEvt = new JButton("RECUSAR EVENTO");
        btnRecusarEvt.setBackground(Color.DARK_GRAY);
        btnRecusarEvt.setForeground(Color.WHITE);
        btnRecusarEvt.setBounds(10, 10, 325, 40);
        btnRecusarEvt.setFont(font);
        btnRecusarEvt.setVisible(true);
        btnRecusarEvt.addActionListener(lstCriarEvento);
        btnRecusarEvt.setActionCommand(RECUSA);
        this.add(btnRecusarEvt);

        btnAceitarEvt = new JButton("ACEITAR EVENTO");
        btnAceitarEvt.setBackground(Color.DARK_GRAY);
        btnAceitarEvt.setForeground(Color.WHITE);
        btnAceitarEvt.setBounds(345, 10, 325, 40);
        btnAceitarEvt.setFont(font);
        btnAceitarEvt.setVisible(true);
        btnAceitarEvt.addActionListener(lstEditaEvento);
        btnAceitarEvt.setActionCommand(ACEITA);
        this.add(btnAceitarEvt);
    }

}
