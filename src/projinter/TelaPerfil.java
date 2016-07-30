package projinter;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPerfil extends JFrame {

    private JPanel panFundo;
    private JLabel imgFundo;
    private PainelPerfilEmpresa pnlPerfilEmp;

    public TelaPerfil(ActionListener controle, Usuario user) {
        super("EDITAR PERFIL");
        setLayout(null);
        setSize(765, 665);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(false);        
        
        if (user.getTipo().equals("EMPRESA")) {
            pnlPerfilEmp = new PainelPerfilEmpresa(controle,controle, user);
            pnlPerfilEmp.setLocation(((this.getWidth() / 2) - (pnlPerfilEmp.getWidth() / 2)), ((this.getHeight()/ 2) - (pnlPerfilEmp.getHeight()/ 2)));
            this.add(pnlPerfilEmp);
        }

        panFundo = new JPanel();
        panFundo.setLayout(null);
        panFundo.setSize(this.getSize());
        add(panFundo);

        ImageIcon img = new ImageIcon("./src/img/balada2.jpg");
        imgFundo = new JLabel(img);
        imgFundo.setSize(img.getIconWidth(), img.getIconHeight());
        panFundo.add(imgFundo);
    }
    public Usuario getUsuarioUpdate(Usuario user){
        Usuario userUpdate = user;
        if(user.getTipo().equals("EMPRESA")){
            userUpdate = pnlPerfilEmp.getUser(user);
        }
        return userUpdate;
    }
}
