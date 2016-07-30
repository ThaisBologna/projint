package projinter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PainelCalendario extends JPanel {

    private ItemCalendario pnlEven1, pnlEven2, pnlEven3, pnlEven4, pnlEven5;
    private JLabel dia1, dia2, dia3, dia4, dia5;
    private Font font = new Font("Impact", Font.PLAIN, 20);
    private JScrollPane barra1, barra2, barra3, barra4, barra5;

    public PainelCalendario(TelaPrincipal controle, AcessoBD acessoBD,int adição) {
        setLayout(null);
        setSize(480, 300);
        setOpaque(true);
        setBackground(new Color(0, 0, 0, 50));
        setVisible(true);

        dia1 = new JLabel(acessoBD.pegaData(adição));
        dia1.setSize(84, 30);
        dia1.setLocation(10, 10);
        dia1.setHorizontalAlignment(dia1.CENTER);
        dia1.setOpaque(true);
        dia1.setBackground(Color.WHITE);
        this.add(dia1);

        dia2 = new JLabel(acessoBD.pegaData(adição+1));
        dia2.setSize(84, 30);
        dia2.setLocation(104, 10);
        dia2.setHorizontalAlignment(dia2.CENTER);
        dia2.setOpaque(true);
        dia2.setBackground(Color.WHITE);
        this.add(dia2);

        dia3 = new JLabel(acessoBD.pegaData(adição+2));
        dia3.setSize(80, 30);
        dia3.setLocation(198, 10);
        dia3.setHorizontalAlignment(dia3.CENTER);
        dia3.setOpaque(true);
        dia3.setBackground(Color.WHITE);
        this.add(dia3);

        dia4 = new JLabel(acessoBD.pegaData(adição+3));
        dia4.setSize(84, 30);
        dia4.setLocation(292, 10);
        dia4.setHorizontalAlignment(dia4.CENTER);
        dia4.setOpaque(true);
        dia4.setBackground(Color.WHITE);
        this.add(dia4);

        dia5 = new JLabel(acessoBD.pegaData(adição+4));
        dia5.setSize(84, 30);
        dia5.setLocation(386, 10);
        dia5.setHorizontalAlignment(dia5.CENTER);
        dia5.setOpaque(true);
        dia5.setBackground(Color.WHITE);
        this.add(dia5);

        pnlEven1 = new ItemCalendario(new ControleMouse(controle),adição,acessoBD);
        barra1 = new JScrollPane();
        barra1.setViewportView(pnlEven1);
        barra1.setBounds(10, 50, 84, 240);
        barra1.setOpaque(false);
        barra1.setBackground(new Color(0, 0, 0, 100));
        barra1.setVerticalScrollBarPolicy(barra1.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(barra1);
        
        pnlEven2 = new ItemCalendario(new ControleMouse(controle),adição+1,acessoBD);
        barra2 = new JScrollPane();
        barra2.setViewportView(pnlEven2);
        barra2.setBounds(104, 50, 84, 240);
        barra2.setOpaque(false);
        barra2.setBackground(new Color(0, 0, 0, 100));
        barra2.setVerticalScrollBarPolicy(barra2.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(barra2);

        pnlEven3 = new ItemCalendario(new ControleMouse(controle),adição+2,acessoBD);
        barra3 = new JScrollPane();
        barra3.setViewportView(pnlEven3);
        barra3.setBounds(198, 50, 84, 240);
        barra3.setOpaque(false);
        barra3.setBackground(new Color(0, 0, 0, 100));
        barra3.setVerticalScrollBarPolicy(barra3.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(barra3);

        pnlEven4 = new ItemCalendario(new ControleMouse(controle),adição+3,acessoBD);
        barra4 = new JScrollPane();
        barra4.setViewportView(pnlEven4);
        barra4.setBounds(292, 50, 84, 240);
        barra4.setOpaque(false);
        barra4.setBackground(new Color(0, 0, 0, 0));
        barra4.setVerticalScrollBarPolicy(barra4.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(barra4);
        
        pnlEven5 = new ItemCalendario(new ControleMouse(controle),adição+4,acessoBD);
        barra5 = new JScrollPane();
        barra5.setViewportView(pnlEven5);
        barra5.setBounds(386, 50, 84, 240);
        barra5.setOpaque(false);
        barra5.setBackground(new Color(0, 0, 0, 100));
        barra5.setVerticalScrollBarPolicy(barra5.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(barra5);
    }
}
