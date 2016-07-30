package projinter;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelEditarEvento extends JPanel {

    public static final String ConfEdi = "confEdiEvento";
    public static final String CancEdi = "cancEdiEvento";

    private Font font = new Font("Impact", Font.PLAIN, 22);

    private PainelImagemEvento pnlImagem;

    private JTextField txtNome2, txtDescrição2, txtData, txtHora, txtAvatarEvt,
            txtLocal2, txtEndereço2, txtCidade2, txtPreço2;

    private JTextField txtNome, txtLocal, txtEndereço, txtPreço, txtBanda;
    private JTextArea jarDescrição;
    private JComboBox cmbCidade, cmbBanda, cmbDia, cmbMes, cmbAno, cmbHora, cmbMinuto;
    private JScrollPane barraRolagem;
    private JButton btnConfirmar, btnCancelar;
    private DefaultListCellRenderer dlcr;

    public PainelEditarEvento(Object[][] dado,CriaDataHora listar, ActionListener lstConfUpdt, ActionListener lstCancUpdt, AcessoBD acessoBD) {
        setLayout(null);
        setOpaque(true);
        setSize(680, 620);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        txtNome2 = new JTextField("Nome");
        txtNome2.setHorizontalAlignment(txtNome2.CENTER);
        txtNome2.setForeground(Color.WHITE);
        txtNome2.setBackground(Color.DARK_GRAY);
        txtNome2.setSize(250, 35);
        txtNome2.setFont(font);
        txtNome2.setLocation(20, 20);
        txtNome2.setEditable(false);
        this.add(txtNome2);

        txtNome = new JTextField((String) dado[0][1]);
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.DARK_GRAY);
        txtNome.setBackground(Color.WHITE);
        txtNome.setSize(380, 35);
        txtNome.setFont(font);
        txtNome.setLocation(280, 20);
        this.add(txtNome);

        txtPreço2 = new JTextField("Preço");
        txtPreço2.setHorizontalAlignment(txtPreço2.CENTER);
        txtPreço2.setForeground(Color.WHITE);
        txtPreço2.setBackground(Color.DARK_GRAY);
        txtPreço2.setSize(250, 35);
        txtPreço2.setFont(font);
        txtPreço2.setLocation(20, 70);
        txtPreço2.setEditable(false);
        this.add(txtPreço2);

        txtPreço = new JTextField("" + (float) dado[0][7]);
        txtPreço.setHorizontalAlignment(txtPreço.CENTER);
        txtPreço.setForeground(Color.BLACK);
        txtPreço.setBackground(Color.WHITE);
        txtPreço.setSize(380, 35);
        txtPreço.setFont(font);
        txtPreço.setLocation(280, 70);
        this.add(txtPreço);

        txtLocal2 = new JTextField("Local");
        txtLocal2.setHorizontalAlignment(txtLocal2.CENTER);
        txtLocal2.setForeground(Color.WHITE);
        txtLocal2.setBackground(Color.DARK_GRAY);
        txtLocal2.setSize(250, 35);
        txtLocal2.setFont(font);
        txtLocal2.setLocation(20, 120);
        txtLocal2.setEditable(false);
        this.add(txtLocal2);

        txtLocal = new JTextField((String) dado[0][6]);
        txtLocal.setHorizontalAlignment(txtLocal.CENTER);
        txtLocal.setForeground(Color.BLACK);
        txtLocal.setBackground(Color.WHITE);
        txtLocal.setSize(380, 35);;
        txtLocal.setFont(font);
        txtLocal.setLocation(280, 120);
        this.add(txtLocal);

        txtEndereço2 = new JTextField("Endereço");
        txtEndereço2.setHorizontalAlignment(txtEndereço2.CENTER);
        txtEndereço2.setForeground(Color.WHITE);
        txtEndereço2.setBackground(Color.DARK_GRAY);
        txtEndereço2.setSize(250, 35);
        txtEndereço2.setFont(font);
        txtEndereço2.setLocation(20, 170);
        txtEndereço2.setEditable(false);
        this.add(txtEndereço2);

        txtEndereço = new JTextField((String) dado[0][10]);
        txtEndereço.setHorizontalAlignment(txtEndereço.CENTER);
        txtEndereço.setForeground(Color.BLACK);
        txtEndereço.setBackground(Color.WHITE);
        txtEndereço.setSize(380, 35);
        txtEndereço.setFont(font);
        txtEndereço.setLocation(280, 170);
        this.add(txtEndereço);

        txtCidade2 = new JTextField("Cidade");
        txtCidade2.setHorizontalAlignment(txtCidade2.CENTER);
        txtCidade2.setForeground(Color.WHITE);
        txtCidade2.setBackground(Color.DARK_GRAY);
        txtCidade2.setSize(250, 35);
        txtCidade2.setFont(font);
        txtCidade2.setLocation(20, 220);
        txtCidade2.setEditable(false);
        this.add(txtCidade2);

        cmbCidade = new JComboBox(acessoBD.listaCidades());
        cmbCidade.setAlignmentX(CENTER_ALIGNMENT);
        cmbCidade.setForeground(Color.BLACK);
        cmbCidade.setBackground(Color.WHITE);
        cmbCidade.setSize(380, 35);
        cmbCidade.setFont(font);
        cmbCidade.setLocation(280, 220);
        cmbCidade.setRenderer(dlcr);
        cmbCidade.setSelectedItem(dado[0][3]);
        this.add(cmbCidade);

        txtBanda = new JTextField("Banda");
        txtBanda.setHorizontalAlignment(txtBanda.CENTER);
        txtBanda.setForeground(Color.WHITE);
        txtBanda.setBackground(Color.DARK_GRAY);
        txtBanda.setSize(250, 35);
        txtBanda.setFont(font);
        txtBanda.setLocation(20, 270);
        txtBanda.setEditable(false);
        this.add(txtBanda);

        cmbBanda = new JComboBox(acessoBD.listaBandas());
        cmbBanda.setAlignmentX(CENTER_ALIGNMENT);
        cmbBanda.setForeground(Color.BLACK);
        cmbBanda.setBackground(Color.WHITE);
        cmbBanda.setSize(380, 35);
        cmbBanda.setFont(font);
        cmbBanda.setLocation(280, 270);
        cmbBanda.setRenderer(dlcr);
        cmbBanda.setSelectedItem(dado[0][2]);
        this.add(cmbBanda);

        txtData = new JTextField("Data");
        txtData.setHorizontalAlignment(txtData.CENTER);
        txtData.setForeground(Color.WHITE);
        txtData.setBackground(Color.DARK_GRAY);
        txtData.setSize(105, 35);
        txtData.setFont(font);
        txtData.setLocation(20, 320);
        txtData.setEditable(false);
        this.add(txtData);

        cmbDia = new JComboBox(listar.dia());
        cmbDia.setAlignmentX(CENTER_ALIGNMENT);
        cmbDia.setForeground(Color.BLACK);
        cmbDia.setBackground(Color.WHITE);
        cmbDia.setSize(56, 35);
        cmbDia.setFont(font);
        cmbDia.setLocation(135, 320);
        cmbDia.setRenderer(dlcr);
        this.add(cmbDia);

        cmbMes = new JComboBox(listar.mes());
        cmbMes.setAlignmentX(CENTER_ALIGNMENT);
        cmbMes.setForeground(Color.BLACK);
        cmbMes.setBackground(Color.WHITE);
        cmbMes.setSize(56, 35);
        cmbMes.setFont(font);
        cmbMes.setLocation(201, 320);
        cmbMes.setRenderer(dlcr);
        this.add(cmbMes);

        cmbAno = new JComboBox(listar.anoEvento());
        cmbAno.setRenderer(dlcr);
        cmbAno.setForeground(Color.BLACK);
        cmbAno.setBackground(Color.WHITE);
        cmbAno.setSize(86, 35);
        cmbAno.setFont(font);
        cmbAno.setLocation(267, 320);
        this.add(cmbAno);

        txtHora = new JTextField("Horário");
        txtHora.setHorizontalAlignment(txtHora.CENTER);
        txtHora.setForeground(Color.WHITE);
        txtHora.setBackground(Color.DARK_GRAY);
        txtHora.setSize(105, 35);
        txtHora.setFont(font);
        txtHora.setLocation(363, 320);
        txtHora.setEditable(false);
        this.add(txtHora);

        cmbHora = new JComboBox(listar.horas());
        cmbHora.setAlignmentX(CENTER_ALIGNMENT);
        cmbHora.setForeground(Color.BLACK);
        cmbHora.setBackground(Color.WHITE);
        cmbHora.setSize(86, 35);
        cmbHora.setFont(font);
        cmbHora.setLocation(478, 320);
        cmbHora.setRenderer(dlcr);
        this.add(cmbHora);

        cmbMinuto = new JComboBox(listar.minutos());
        cmbMinuto.setAlignmentX(CENTER_ALIGNMENT);
        cmbMinuto.setForeground(Color.BLACK);
        cmbMinuto.setBackground(Color.WHITE);
        cmbMinuto.setSize(86, 35);
        cmbMinuto.setFont(font);
        cmbMinuto.setLocation(573, 320);
        cmbMinuto.setRenderer(dlcr);
        this.add(cmbMinuto);

        txtDescrição2 = new JTextField("Descrição");
        txtDescrição2.setHorizontalAlignment(txtDescrição2.CENTER);
        txtDescrição2.setForeground(Color.WHITE);
        txtDescrição2.setBackground(Color.DARK_GRAY);
        txtDescrição2.setSize(640, 35);
        txtDescrição2.setFont(font);
        txtDescrição2.setLocation(20, 370);
        txtDescrição2.setEditable(false);
        this.add(txtDescrição2);

        jarDescrição = new JTextArea((String) dado[0][5]);
        jarDescrição.setForeground(Color.BLACK);
        jarDescrição.setBackground(Color.WHITE);
        jarDescrição.setFont(font);
        jarDescrição.setLineWrap(true);
        jarDescrição.setWrapStyleWord(true);

        barraRolagem = new JScrollPane(jarDescrição);
        barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        barraRolagem.setBounds(20, 405, 640, 90);
        this.add(barraRolagem, BorderLayout.CENTER);

        txtAvatarEvt = new JTextField("Imagem do Evento");
        txtAvatarEvt.setHorizontalAlignment(txtAvatarEvt.CENTER);
        txtAvatarEvt.setForeground(Color.WHITE);
        txtAvatarEvt.setBackground(Color.DARK_GRAY);
        txtAvatarEvt.setSize(190, 35);
        txtAvatarEvt.setFont(font);
        txtAvatarEvt.setLocation(20, 510);
        txtAvatarEvt.setEditable(false);
        this.add(txtAvatarEvt);

        pnlImagem = new PainelImagemEvento();
        pnlImagem.setLocation(210, 505);
        this.add(pnlImagem);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setForeground(Color.YELLOW);
        btnCancelar.setBackground(Color.DARK_GRAY);
        btnCancelar.setBounds(20, 565, 320, 35);
        btnCancelar.setVisible(true);
        btnCancelar.setFont(font);
        btnCancelar.addActionListener(lstCancUpdt);
        btnCancelar.setActionCommand(CancEdi);
        this.add(btnCancelar);

        btnConfirmar = new JButton("CONFIRMAR MUDANÇAS");
        btnConfirmar.setForeground(Color.YELLOW);
        btnConfirmar.setBackground(Color.DARK_GRAY);
        btnConfirmar.setBounds(345, 565, 320, 35);
        btnConfirmar.setVisible(true);
        btnConfirmar.setFont(font);
        btnConfirmar.addActionListener(lstConfUpdt);
        btnConfirmar.setActionCommand(ConfEdi);
        this.add(btnConfirmar);
    }

    public String getNumImg() {
        String numImg = pnlImagem.getSeleção();
        return numImg;
    }

    public String getNomeEvento() {
        String nome = txtNome.getText();
        return nome;
    }

    public String getResponsavel() {
        String responsavel = txtPreço.getText();
        return responsavel;
    }

    public String getLocal() {
        String local = txtLocal.getText();
        return local;
    }

    public String getEndereço() {
        String endereço = txtEndereço.getText();
        return endereço;
    }

    public String getCidade() {
        String cidade = (String) cmbCidade.getSelectedItem();
        return cidade;
    }

    public String getBanda() {
        String banda = (String) cmbBanda.getSelectedItem();
        return banda;
    }

    public String getDescrição() {
        String descrição = jarDescrição.getText();
        return descrição;
    }

    public float getPreço() {
        float preço = Float.parseFloat(txtPreço.getText());
        return preço;
    }

    public String getHorario() {
        String dia = (String) cmbDia.getSelectedItem();
        String mes = (String) cmbMes.getSelectedItem();
        String ano = (String) cmbAno.getSelectedItem();
        String hora = (String) cmbHora.getSelectedItem();
        String minuto = (String) cmbMinuto.getSelectedItem();

        String horario = ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + "00";
        return horario;
    }
}
