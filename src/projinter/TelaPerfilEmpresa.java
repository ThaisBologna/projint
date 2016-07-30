package projinter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPerfilEmpresa extends JFrame {

    private JPanel panFundo;
    private JLabel imgFundo;
    PainelPerfilEmpUser pnlPerfilEmpUser;

    public TelaPerfilEmpresa(Object[][] empresa) {
        super("PERFIL DA EMPRESA "+(String)empresa[0][0]);
        setLayout(null);
        setSize(765, 665);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(false);
        
        pnlPerfilEmpUser = new PainelPerfilEmpUser(empresa);
        pnlPerfilEmpUser.setLocation(((this.getWidth() / 2) - (pnlPerfilEmpUser.getWidth() / 2)), ((this.getHeight()/ 2) - (pnlPerfilEmpUser.getHeight()/ 2)));
        this.add(pnlPerfilEmpUser);

        panFundo = new JPanel();
        panFundo.setLayout(null);
        panFundo.setSize(this.getSize());
        add(panFundo);

        ImageIcon img = new ImageIcon("./src/img/balada2.jpg");
        imgFundo = new JLabel(img);
        imgFundo.setSize(img.getIconWidth(), img.getIconHeight());
        panFundo.add(imgFundo);
    }
}
