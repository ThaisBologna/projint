package projinter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaCriarEvento extends JFrame {

    private JPanel panFundo;
    private JLabel imgFundo;
    private PainelNovoEvento pnlNovoEvento;

    public TelaCriarEvento(AcessoBD acessoBD, CriaDataHora dataHora, TelaPrincipal controle) {
        super("NOVO EVENTO");
        setSize(720, 690);
        setUndecorated(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        pnlNovoEvento = new PainelNovoEvento(acessoBD, dataHora, controle, controle);
        pnlNovoEvento.setLocation(((this.getWidth() / 2) - (pnlNovoEvento.getWidth() / 2)), 20);
        this.add(pnlNovoEvento);

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
        if (pnlNovoEvento.getBanda().equals(" ")) {
            status = "ativo";
        }else{
            status = "pendente";
        }
        Evento evento = new Evento(
                pnlNovoEvento.getNomeEvento(),
                pnlNovoEvento.getDescrição(),     
                pnlNovoEvento.getBanda(),
                pnlNovoEvento.getHorario(),
                pnlNovoEvento.getLocal(),
                pnlNovoEvento.getEndereço(),
                pnlNovoEvento.getCidade(),
                pnlNovoEvento.getNumImg(),
                status,
                pnlNovoEvento.getPreço()
        );
        return evento;
    }
}
