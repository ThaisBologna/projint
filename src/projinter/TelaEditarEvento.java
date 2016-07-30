package projinter;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaEditarEvento extends JFrame {

    private JPanel panFundo;
    private JLabel imgFundo;
    private PainelEditarEvento pnlEditarEvento;

    public TelaEditarEvento(Object[][] evento, CriaDataHora listar, ActionListener controle, AcessoBD acessoBD) {
        super("EDITAR EVENTO");
        setSize(720, 690);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        pnlEditarEvento = new PainelEditarEvento(evento, listar, controle, controle, acessoBD);
        pnlEditarEvento.setLocation(((this.getWidth() / 2) - (pnlEditarEvento.getWidth() / 2)), 20);
        this.add(pnlEditarEvento);

        panFundo = new JPanel();
        panFundo.setLayout(null);
        panFundo.setSize(this.getSize());
        add(panFundo);

        ImageIcon img = new ImageIcon("./src/img/novoevento.jpg");
        imgFundo = new JLabel(img);
        imgFundo.setSize(img.getIconWidth(), img.getIconHeight());
        panFundo.add(imgFundo);

    }

    public Evento getEvento() {
        String status;
        if (pnlEditarEvento.getBanda().equals(" ")) {
            status = "ativo";
        } else {
            status = "pendente";
        }
        Evento newEvento = new Evento(
                pnlEditarEvento.getNomeEvento(),
                pnlEditarEvento.getDescrição(),
                pnlEditarEvento.getBanda(),
                pnlEditarEvento.getHorario(),
                pnlEditarEvento.getLocal(),
                pnlEditarEvento.getEndereço(),
                pnlEditarEvento.getCidade(),
                pnlEditarEvento.getNumImg(),
                status,
                pnlEditarEvento.getPreço()
        );
        return newEvento;
    }
}
