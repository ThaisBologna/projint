package projinter;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class ItemCalendario extends JPanel {

    private List<EventoItem> eventos;
    private MouseListener listener;

    public ItemCalendario(MouseListener listener, int adição, AcessoBD acessoBD) {
        eventos = new ArrayList<>();
        setLayout(null);
        setOpaque(true);
        setSize(84, 300);
        setBackground(new Color(0, 0, 0, 100));
        this.listener = listener;

        Object[][] dados = acessoBD.eventosUsuario(adição);
        int tamanho = acessoBD.eventosUsuarioTamanho(adição);

        String nomeBanda, codigoBanda, nomeEmpresa, codigoEmpresa;
        int codBanda, codEmpresa;
        for (int i = 0; i < tamanho; i++) {
            codigoEmpresa = (String) dados[i][2];
            codEmpresa = Integer.parseInt(codigoEmpresa);
            nomeEmpresa = acessoBD.pegaEmpresa(codEmpresa);
            if ((String) dados[i][3] != null) {
                codigoBanda = (String) dados[i][3];
                codBanda = Integer.parseInt(codigoBanda);
                nomeBanda = acessoBD.pegaBanda(codBanda);
            } else {
                nomeBanda = " ";
            }
            Evento evento = new Evento(
                    (String) dados[i][0],
                    (String) dados[i][1],
                    nomeEmpresa, 
                    nomeBanda,
                    (String) dados[i][4],
                    (String) dados[i][5],
                    (String) dados[i][6], 
                    (String) dados[i][7], 
                    (String) dados[i][8], 
                    (String) dados[i][9], 
                    (float) dados[i][10]);
            EventoItem eventoItem = new EventoItem(evento);
            eventos.add(eventoItem);
        }
        listarEventos();
    }

    public void listarEventos() {
        if (!eventos.isEmpty()) {
            int espaçamento = 0;
            for (EventoItem label : eventos) {
                label.addMouseListener(listener);
                label.setLocation(0, espaçamento);
                add(label);
                espaçamento = espaçamento + 50;
            }
            revalidate();
            repaint();
        }
    }
}
