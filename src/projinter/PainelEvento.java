package projinter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelEvento extends JPanel {

    public static final String AbrirBanda = "abreBanda";
    public static final String VoltaPainel = "voltPainel";
    public static final String AbrirEmpresa = "abreEmpresa";
    public static final String Comparecer = "comparecer";

    private Font font = new Font("Impact", Font.PLAIN, 22);

    private Evento evento;
    private JTextField txtNome, txtHorario, txtLocal, txtEndereço, txtCidade, txtPreço;
    private JTextField txtNome2, txtHorario2, txtLocal2, txtEndereço2, txtCidade2, txtPreço2;
    private JTextArea jarDescrição;
    private JScrollPane barraRolagem;
    private JButton btnVoltarPainel, btnIrBanda, btnIrEmpresa,btnComparecer;

    public PainelEvento(Evento evento, ActionListener lstVoltarPainel, ActionListener lstIrBanda, ActionListener lstIrEmpresa) {
        super();
        setSize(680, 440);
        setLayout(null);
        setOpaque(true);
        setBackground(new Color(255, 255, 255, 100));
        this.evento = evento;

        btnVoltarPainel = new JButton("<< VOLTAR <<");
        btnVoltarPainel.setForeground(Color.YELLOW);
        btnVoltarPainel.setBackground(Color.DARK_GRAY);
        btnVoltarPainel.setFont(font);
        btnVoltarPainel.setBounds(20, 20, 210, 85);
        btnVoltarPainel.setVisible(true);
        btnVoltarPainel.addActionListener(lstVoltarPainel);
        btnVoltarPainel.setActionCommand(VoltaPainel);
        this.add(btnVoltarPainel);
/*
        btnComparecer = new JButton(evento.getEmpresa());
        btnComparecer.setForeground(Color.YELLOW);
        btnComparecer.setBackground(Color.DARK_GRAY);
        btnComparecer.setFont(font);
        btnComparecer.setBounds(20, 120, 210, 85);
        btnComparecer.setVisible(true);
        btnComparecer.addActionListener(lstComparecer);
        btnComparecer.setActionCommand(Comparecer);
        this.add(btnComparecer);
*/
        btnIrEmpresa = new JButton(evento.getEmpresa());
        btnIrEmpresa.setForeground(Color.YELLOW);
        btnIrEmpresa.setBackground(Color.DARK_GRAY);
        btnIrEmpresa.setFont(font);
        btnIrEmpresa.setBounds(20, 120, 210, 85);
        btnIrEmpresa.setVisible(true);
        btnIrEmpresa.addActionListener(lstIrEmpresa);
        btnIrEmpresa.setActionCommand(AbrirEmpresa);
        this.add(btnIrEmpresa);

        if (evento.getBanda() != " ") {
            btnIrBanda = new JButton(evento.getBanda());
            btnIrBanda.setForeground(Color.YELLOW);
            btnIrBanda.setBackground(Color.DARK_GRAY);
            btnIrBanda.setFont(font);
            btnIrBanda.setBounds(20, 220, 210, 85);
            btnIrBanda.setVisible(true);
            btnIrBanda.addActionListener(lstIrBanda);
            btnIrBanda.setActionCommand(AbrirBanda);
            this.add(btnIrBanda);
        }

        txtNome2 = new JTextField("Nome");
        txtNome2.setHorizontalAlignment(txtNome2.CENTER);
        txtNome2.setForeground(Color.YELLOW);
        txtNome2.setBackground(Color.DARK_GRAY);
        txtNome2.setSize(150, 35);
        txtNome2.setFont(font);
        txtNome2.setLocation(250, 20);
        txtNome2.setEditable(false);
        this.add(txtNome2);

        txtNome = new JTextField(evento.getNome());
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.YELLOW);
        txtNome.setBackground(Color.DARK_GRAY);
        txtNome.setSize(250, 35);
        txtNome.setFont(font);
        txtNome.setLocation(410, 20);
        txtNome.setEditable(false);
        this.add(txtNome);

        txtHorario2 = new JTextField("Data e Hora");
        txtHorario2.setHorizontalAlignment(txtHorario2.CENTER);
        txtHorario2.setForeground(Color.WHITE);
        txtHorario2.setBackground(Color.DARK_GRAY);
        txtHorario2.setSize(150, 35);
        txtHorario2.setFont(font);
        txtHorario2.setLocation(250, 70);
        txtHorario2.setEditable(false);
        this.add(txtHorario2);

        txtHorario = new JTextField(evento.getHorario());
        txtHorario.setHorizontalAlignment(txtHorario.CENTER);
        txtHorario.setForeground(Color.WHITE);
        txtHorario.setBackground(Color.DARK_GRAY);
        txtHorario.setSize(250, 35);
        txtHorario.setFont(font);
        txtHorario.setLocation(410, 70);
        txtHorario.setEditable(false);
        this.add(txtHorario);

        txtLocal2 = new JTextField("Local");
        txtLocal2.setHorizontalAlignment(txtLocal2.CENTER);
        txtLocal2.setForeground(Color.WHITE);
        txtLocal2.setBackground(Color.DARK_GRAY);
        txtLocal2.setSize(150, 35);
        txtLocal2.setFont(font);
        txtLocal2.setLocation(250, 120);
        txtLocal2.setEditable(false);
        this.add(txtLocal2);

        txtLocal = new JTextField(evento.getLocal());
        txtLocal.setHorizontalAlignment(txtLocal.CENTER);
        txtLocal.setForeground(Color.WHITE);
        txtLocal.setBackground(Color.DARK_GRAY);
        txtLocal.setSize(250, 35);
        txtLocal.setFont(font);
        txtLocal.setLocation(410, 120);
        txtLocal.setEditable(false);
        this.add(txtLocal);

        txtEndereço2 = new JTextField("Endereço");
        txtEndereço2.setHorizontalAlignment(txtEndereço2.CENTER);
        txtEndereço2.setForeground(Color.WHITE);
        txtEndereço2.setBackground(Color.DARK_GRAY);
        txtEndereço2.setSize(150, 35);
        txtEndereço2.setFont(font);
        txtEndereço2.setLocation(250, 170);
        txtEndereço2.setEditable(false);
        this.add(txtEndereço2);

        txtEndereço = new JTextField(evento.getEndereco());
        txtEndereço.setHorizontalAlignment(txtEndereço.CENTER);
        txtEndereço.setForeground(Color.WHITE);
        txtEndereço.setBackground(Color.DARK_GRAY);
        txtEndereço.setSize(250, 35);
        txtEndereço.setFont(font);
        txtEndereço.setLocation(410, 170);
        txtEndereço.setEditable(false);
        this.add(txtEndereço);

        txtCidade2 = new JTextField("Cidade");
        txtCidade2.setHorizontalAlignment(txtCidade2.CENTER);
        txtCidade2.setForeground(Color.WHITE);
        txtCidade2.setBackground(Color.DARK_GRAY);
        txtCidade2.setSize(150, 35);
        txtCidade2.setFont(font);
        txtCidade2.setLocation(250, 220);
        txtCidade2.setEditable(false);
        this.add(txtCidade2);

        txtCidade = new JTextField(evento.getCidade());
        txtCidade.setHorizontalAlignment(txtCidade.CENTER);
        txtCidade.setForeground(Color.WHITE);
        txtCidade.setBackground(Color.DARK_GRAY);
        txtCidade.setSize(250, 35);
        txtCidade.setFont(font);
        txtCidade.setLocation(410, 220);
        txtCidade.setEditable(false);
        this.add(txtCidade);

        txtPreço2 = new JTextField("Preço");
        txtPreço2.setHorizontalAlignment(txtPreço2.CENTER);
        txtPreço2.setForeground(Color.WHITE);
        txtPreço2.setBackground(Color.DARK_GRAY);
        txtPreço2.setSize(150, 35);
        txtPreço2.setFont(font);
        txtPreço2.setLocation(250, 270);
        txtPreço2.setEditable(false);
        this.add(txtPreço2);

        txtPreço = new JTextField("" + evento.getPreço());
        txtPreço.setHorizontalAlignment(txtPreço.CENTER);
        txtPreço.setForeground(Color.WHITE);
        txtPreço.setBackground(Color.DARK_GRAY);
        txtPreço.setSize(250, 35);
        txtPreço.setFont(font);
        txtPreço.setLocation(410, 270);
        txtPreço.setEditable(false);
        this.add(txtPreço);

        jarDescrição = new JTextArea(evento.getDescricao());
        jarDescrição.setForeground(Color.BLACK);
        jarDescrição.setBackground(Color.WHITE);
        jarDescrição.setFont(font);
        jarDescrição.setEditable(false);
        jarDescrição.setLineWrap(true);
        jarDescrição.setWrapStyleWord(true);

        barraRolagem = new JScrollPane(jarDescrição);
        barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        barraRolagem.setBounds(20, 320, 640, 90);
        this.add(barraRolagem, BorderLayout.CENTER);
    }
    public Evento getEvento(){
        Evento evento = this.evento;
        return evento;
    }
}
