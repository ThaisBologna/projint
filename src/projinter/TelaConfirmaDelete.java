package projinter;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaConfirmaDelete extends JFrame {

    private JPanel panFundo;
    private JLabel imgFundo;
    private PainelConfirmaDelete pnlConfirmaDel;
    
    public TelaConfirmaDelete(ActionListener controle) {
        super("CONFIRMAÇÃO");
        setSize(400, 200);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        pnlConfirmaDel = new PainelConfirmaDelete(controle, controle);
        pnlConfirmaDel.setLocation(0, 0);
        this.add(pnlConfirmaDel);
        
        panFundo = new JPanel();
        panFundo.setLayout(null);
        panFundo.setSize(this.getSize());
        add(panFundo);

        ImageIcon img = new ImageIcon("./src/img/balada3.jpg");
        imgFundo = new JLabel(img);
        imgFundo.setSize(img.getIconWidth(), img.getIconHeight());
        panFundo.add(imgFundo);
    }
}
