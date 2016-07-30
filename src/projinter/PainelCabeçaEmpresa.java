package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCabeçaEmpresa extends JPanel {

    public static final String OKemp = "vai";

    private JTextField txtNome;
    private JComboBox cmbManter, cmbCidade;
    private JButton btnOkEmp;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private DefaultListCellRenderer dlcr;

    public PainelCabeçaEmpresa(Usuario user, ActionListener lstVai, AcessoBD acessoBD, int[] opção) {
        setLayout(null);
        setSize(680, 55);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);
        String[] manter = {"Eventos Ativos", "Eventos Inativos", "Perfil Empresa", "Sair"};

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

        btnOkEmp = new JButton("OK");
        btnOkEmp.setBackground(Color.WHITE);
        btnOkEmp.setBounds(610, 10, 60, 35);
        btnOkEmp.setVisible(true);
        btnOkEmp.setFont(font);
        btnOkEmp.addActionListener(lstVai);
        btnOkEmp.setActionCommand(OKemp);
        this.add(btnOkEmp);
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
