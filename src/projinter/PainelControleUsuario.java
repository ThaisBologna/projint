package projinter;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class PainelControleUsuario extends JPanel {

    PainelAgenda pnlAgenda;
    PainelCabeçaUsuario pnlCabeçaUsuario;

    public PainelControleUsuario(Usuario user, TelaPrincipal controle, ActionListener lstVai, AcessoBD acessoBD, int[] opção, int adição) {
        setLayout(null);
        setOpaque(true);
        setSize(680, 440);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);

        pnlCabeçaUsuario = new PainelCabeçaUsuario(user, lstVai, acessoBD, opção);
        pnlCabeçaUsuario.setLocation(((this.getWidth() / 2) - (pnlCabeçaUsuario.getWidth() / 2)), 0);
        this.add(pnlCabeçaUsuario);
        
        pnlAgenda = new PainelAgenda(controle, acessoBD, adição,controle,controle);
        pnlAgenda.setLocation(((this.getWidth() / 2) - (pnlAgenda.getWidth() / 2)), 75);
        this.add(pnlAgenda);
    }
}
