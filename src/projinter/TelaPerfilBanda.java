
package projinter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPerfilBanda extends JFrame{
    
    private JPanel panFundo;
    private JLabel imgFundo;

    public TelaPerfilBanda(){
         super("EDITAR PERFIL");
        setLayout(null);
        setSize(765, 665);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(false);        

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
