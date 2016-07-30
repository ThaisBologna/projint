package projinter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ControleMouse extends MouseAdapter{
    private TelaPrincipal controle;

        ControleMouse(TelaPrincipal controle) {
            this.controle = controle;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof JLabel) {
                EventoItem evento = (EventoItem) e.getSource();
                PainelEvento pnlEvento = new PainelEvento(evento.getEvento(),controle,controle,controle);
                pnlEvento.setLocation(((controle.getWidth() / 2) - (pnlEvento.getWidth() / 2)), ((controle.getHeight()/ 2) - (pnlEvento.getHeight()/ 2)));
                controle.setEvento(evento.getEvento());
                controle.trocarPainel(pnlEvento);
                System.out.println("Clicou");
            }
        }
}
