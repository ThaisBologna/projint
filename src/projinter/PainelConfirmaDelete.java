package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelConfirmaDelete extends JPanel {

    public static final String ConfRem = "confDel";
    public static final String CancRem = "cancDel";

    private Font font = new Font("Impact", Font.PLAIN, 22);

    private JButton btnCancelar, btnRemover;
    private JTextField txtConfirmação;

    public PainelConfirmaDelete(ActionListener lstConfRem, ActionListener lstCanRem) {
        setLayout(null);
        setOpaque(true);
        setSize(400, 200);
        setBackground(new Color(0, 0, 0, 0));

        txtConfirmação = new JTextField("Deletar item selecionado?");
        txtConfirmação.setHorizontalAlignment(txtConfirmação.CENTER);
        txtConfirmação.setForeground(Color.WHITE);
        txtConfirmação.setBackground(new Color(0, 0, 0, 150));
        txtConfirmação.setSize(300, 75);
        txtConfirmação.setFont(font);
        txtConfirmação.setLocation(((this.getWidth() / 2) - (txtConfirmação.getWidth() / 2)), 10);
        txtConfirmação.setEditable(false);
        this.add(txtConfirmação);

        btnCancelar = new JButton("NÃO");
        btnCancelar.setForeground(Color.YELLOW);
        btnCancelar.setBackground(Color.DARK_GRAY);
        btnCancelar.setBounds(20, 120, 160, 50);
        btnCancelar.setVisible(true);
        btnCancelar.setFont(font);
        btnCancelar.addActionListener(lstCanRem);
        btnCancelar.setActionCommand(CancRem);
        this.add(btnCancelar);

        btnRemover = new JButton("SIM");
        btnRemover.setForeground(Color.YELLOW);
        btnRemover.setBackground(Color.DARK_GRAY);
        btnRemover.setBounds(220, 120, 160, 50);
        btnRemover.setVisible(true);
        btnRemover.setFont(font);
        btnRemover.addActionListener(lstConfRem);
        btnRemover.setActionCommand(ConfRem);
        this.add(btnRemover);
    }
}
