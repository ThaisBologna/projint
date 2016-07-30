package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelAcessoNegado extends JPanel {

    public static final String OK = "oki";
    
    private JButton btnOk;
    private JLabel txtAlerta;
    private Font font = new Font("Impact", Font.PLAIN, 22);

    public PainelAcessoNegado(ActionListener lstConfirma) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 170);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        txtAlerta = new JLabel("Senha ou Login inválidos");
        txtAlerta.setSize(300, 35);
        txtAlerta.setHorizontalAlignment(txtAlerta.CENTER);
        txtAlerta.setForeground(Color.RED);
        txtAlerta.setFont(font);
        txtAlerta.setLocation(this.getWidth() / 2 - txtAlerta.getWidth() / 2, this.getHeight() / 2 - txtAlerta.getHeight() / 2);
        this.add(txtAlerta);

        btnOk = new JButton("OK");
        btnOk.setForeground(Color.YELLOW);
        btnOk.setBackground(Color.DARK_GRAY);
        btnOk.setFont(font);
        btnOk.setBounds(this.getWidth() / 2 - btnOk.getWidth() / 2, txtAlerta.getY() + txtAlerta.getHeight()+5, 155, 30);
        btnOk.setVisible(true);
        btnOk.addActionListener(lstConfirma);
        btnOk.setActionCommand(OK);
        this.add(btnOk);
    }

}
