package projinter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PainelImagemEvento extends JPanel implements ActionListener {

    private JLabel imagem;
    private String seleção = "1";
    private JRadioButton rdoEvt1, rdoEvt2, rdoEvt3, rdoEvt4, rdoEvt5,
            rdoEvt6, rdoEvt7, rdoEvt8, rdoEvt9, rdoEvt10;

    private String evento1 = "1";
    private String evento2 = "2";
    private String evento3 = "3";
    private String evento4 = "4";
    private String evento5 = "5";
    private String evento6 = "6";
    private String evento7 = "7";
    private String evento8 = "8";
    private String evento9 = "9";
    private String evento10 = "10";

    private ButtonGroup grupoBtn;

    public PainelImagemEvento() {
        setLayout(new FlowLayout());
        setOpaque(true);
        setSize(470, 50);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);

        imagem = new JLabel();
        this.add(imagem);
        imagem.setIcon(new ImageIcon("./src/IMG/evento1.jpg"));

        rdoEvt1 = new JRadioButton(evento1);
        rdoEvt1.setActionCommand(evento1);
        rdoEvt1.setLocation(230, 510);
        rdoEvt1.setSelected(true);
        this.add(rdoEvt1);

        rdoEvt2 = new JRadioButton(evento2);
        rdoEvt2.setActionCommand(evento2);
        rdoEvt1.setLocation(250, 510);
        this.add(rdoEvt2);

        rdoEvt3 = new JRadioButton(evento3);
        rdoEvt3.setActionCommand(evento3);
        rdoEvt1.setLocation(270, 510);
        this.add(rdoEvt3);

        rdoEvt4 = new JRadioButton(evento4);
        rdoEvt4.setActionCommand(evento4);
        rdoEvt1.setLocation(290, 510);
        this.add(rdoEvt4);

        rdoEvt5 = new JRadioButton(evento5);
        rdoEvt5.setActionCommand(evento5);
        rdoEvt1.setLocation(310, 510);
        this.add(rdoEvt5);

        rdoEvt6 = new JRadioButton(evento6);
        rdoEvt6.setActionCommand(evento6);
        rdoEvt1.setLocation(330, 510);
        this.add(rdoEvt6);

        rdoEvt7 = new JRadioButton(evento7);
        rdoEvt7.setActionCommand(evento7);
        rdoEvt1.setLocation(350, 510);
        this.add(rdoEvt7);

        rdoEvt8 = new JRadioButton(evento8);
        rdoEvt8.setActionCommand(evento8);
        rdoEvt1.setLocation(370, 510);
        this.add(rdoEvt8);

        rdoEvt9 = new JRadioButton(evento9);
        rdoEvt9.setActionCommand(evento9);
        rdoEvt1.setLocation(390, 510);
        this.add(rdoEvt9);

        rdoEvt10 = new JRadioButton(evento10);
        rdoEvt1.setLocation(410, 510);
        rdoEvt10.setActionCommand(evento10);
        this.add(rdoEvt10);

        grupoBtn = new ButtonGroup();
        grupoBtn.add(rdoEvt1);
        grupoBtn.add(rdoEvt2);
        grupoBtn.add(rdoEvt3);
        grupoBtn.add(rdoEvt4);
        grupoBtn.add(rdoEvt5);
        grupoBtn.add(rdoEvt6);
        grupoBtn.add(rdoEvt7);
        grupoBtn.add(rdoEvt8);
        grupoBtn.add(rdoEvt9);
        grupoBtn.add(rdoEvt10);

        rdoEvt1.addActionListener(this);
        rdoEvt2.addActionListener(this);
        rdoEvt3.addActionListener(this);
        rdoEvt4.addActionListener(this);
        rdoEvt5.addActionListener(this);
        rdoEvt6.addActionListener(this);
        rdoEvt7.addActionListener(this);
        rdoEvt8.addActionListener(this);
        rdoEvt9.addActionListener(this);
        rdoEvt10.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        seleção = "" + e.getActionCommand();
        imagem.setIcon(new ImageIcon("./src/IMG/evento"
                + e.getActionCommand()
                + ".jpg"));
    }

    public String getSeleção() {
        String seleção = this.seleção;
        return seleção;
    }
}
