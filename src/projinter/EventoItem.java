package projinter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author pedro
 */
public class EventoItem extends JLabel {

    private Evento evento;
    private ImageIcon img;

    public EventoItem(Evento e) {
        super();
        evento = e;
        init();
    }

    public void init() {
        this.setSize(80, 40);
        String strImg = evento.getNumImagem();
        img = new ImageIcon("./src/IMG/evento"
                + strImg
                + ".jpg");
        setIcon(img);
        setToolTipText(evento.getNome() + " " + evento.getHorario());
        revalidate();
        repaint();
    }

    public Evento getEvento() {
        return evento;
    }
}
