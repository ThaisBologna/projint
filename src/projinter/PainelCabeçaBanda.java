package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCabeçaBanda extends JPanel {

    public static final String VaiBanda = "VaiBandaVai";

    private JTextField txtNome;
    private JComboBox cmbManter, cmbCidade;
    private JButton btnOkBanda;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private DefaultListCellRenderer dlcr;

    public PainelCabeçaBanda(Usuario user, ActionListener lstVaiBanda, AcessoBD acessoBD, int[] opção) {
        setLayout(null);
        setSize(680, 55);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);
        String[] manter = {"Eventos", "Perfil Banda", "Sair"};

        dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        txtNome = new JTextField("Olá " + user.getNome());
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.WHITE);
        txtNome.setBackground(Color.BLACK);
        txtNome.setSize(200, 35);
        txtNome.setFont(font);
        txtNome.setLocation(10, 10);
        this.add(txtNome);

        cmbCidade = new JComboBox(acessoBD.listaCidadesMenu());
        cmbCidade.setBackground(Color.WHITE);
        cmbCidade.setSize(160, 35);
        cmbCidade.setFont(font);
        cmbCidade.setLocation(220, 10);
        cmbCidade.setRenderer(dlcr);
        cmbCidade.setSelectedIndex(opção[0]);
        this.add(cmbCidade);

        cmbManter = new JComboBox(manter);
        cmbManter.setBackground(Color.WHITE);
        cmbManter.setSize(210, 35);
        cmbManter.setFont(font);
        cmbManter.setLocation(390, 10);
        cmbManter.setRenderer(dlcr);
        cmbManter.setSelectedIndex(opção[1]);
        this.add(cmbManter);

        btnOkBanda = new JButton("OK");
        btnOkBanda.setBackground(Color.WHITE);
        btnOkBanda.setBounds(610, 10, 60, 35);
        btnOkBanda.setVisible(true);
        btnOkBanda.setFont(font);
        btnOkBanda.addActionListener(lstVaiBanda);
        btnOkBanda.setActionCommand(VaiBanda);
        this.add(btnOkBanda);
    }

    public String getCidade() {
        String cidade = (String) cmbCidade.getSelectedItem();
        return cidade;
    }

    public int getCidadeSel() {
        int cidade = cmbCidade.getSelectedIndex();
        return cidade;
    }

    public String getOpção() {
        String opção = (String) cmbManter.getSelectedItem();
        return opção;
    }

    public int getOpçãoSel() {
        int opção = cmbManter.getSelectedIndex();
        return opção;
    }
}
