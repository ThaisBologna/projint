/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelAgenda extends JPanel {

    PainelCalendario pnlCalendario;
    public static final String Avançar = "avança";
    public static final String Retroceder = "retrocede";

    JButton btnAvançar, btnRetro;
    private Font font = new Font("Impact", Font.PLAIN, 22);

    public PainelAgenda(TelaPrincipal controle,AcessoBD acessoBD,int adição,ActionListener lstAvançar,ActionListener lstRetrocede) {
        setLayout(null);
        setSize(680, 340);
        setOpaque(true);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);
        
        btnAvançar = new JButton(">>");
        btnAvançar.setForeground(Color.YELLOW);
        btnAvançar.setBackground(Color.DARK_GRAY);
        btnAvançar.setFont(font);
        btnAvançar.setBounds(600, 20, 60, 300);
        btnAvançar.setVisible(true);
        btnAvançar.addActionListener(lstAvançar);
        btnAvançar.setActionCommand(Avançar);
        this.add(btnAvançar);

        btnRetro = new JButton("<<");
        btnRetro.setForeground(Color.YELLOW);
        btnRetro.setBackground(Color.DARK_GRAY);
        btnRetro.setFont(font);
        btnRetro.setBounds(20, 20, 60, 300);
        btnRetro.setVisible(true);
        btnRetro.addActionListener(lstRetrocede);
        btnRetro.setActionCommand(Retroceder);
        this.add(btnRetro);

        pnlCalendario = new PainelCalendario(controle,acessoBD,adição);
        pnlCalendario.setLocation((this.getWidth()/2)-(pnlCalendario.getWidth()/2), 20);        
        this.add(pnlCalendario);
    }
}
