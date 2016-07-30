package projinter;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelPerfilEmpresa extends JPanel {

    public static final String ConfPerfEmp = "CONFIR";
    public static final String CancPerfEmp = "CANCEL";

    private Font font = new Font("Impact", Font.PLAIN, 22);
    private JTextArea fldDesc;
    private JComboBox cmbMatriz, cmbLocFix;
    private JButton btnConfirmarEmp, btnCancelaEmp;
    private JTextField txtNome, txtRazao, txtContato, txtLocal, txtFunciona;

    public PainelPerfilEmpresa(ActionListener lstCan, ActionListener lstConf, Usuario user) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 460);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        String[] local = {"Fixo", "Itinerante"};
        String[] matriz = {"Filial", "Matriz"};

        txtNome = new JTextField(user.getNome());
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.WHITE);
        txtNome.setBackground(Color.DARK_GRAY);
        txtNome.setSize(320, 35);
        txtNome.setFont(font);
        txtNome.setLocation(20, 15);
        this.add(txtNome);

        txtRazao = new JTextField(user.getRazao());
        txtRazao.setHorizontalAlignment(txtRazao.CENTER);
        txtRazao.setForeground(Color.WHITE);
        txtRazao.setBackground(Color.DARK_GRAY);
        txtRazao.setSize(320, 35);
        txtRazao.setFont(font);
        txtRazao.setLocation(20, 65);
        this.add(txtRazao);

        txtContato = new JTextField(user.getTelefone());
        txtContato.setHorizontalAlignment(txtContato.CENTER);
        txtContato.setForeground(Color.WHITE);
        txtContato.setBackground(Color.DARK_GRAY);
        txtContato.setSize(320, 35);
        txtContato.setFont(font);
        txtContato.setLocation(20, 115);
        this.add(txtContato);

        txtLocal = new JTextField(user.getEndereço());
        txtLocal.setHorizontalAlignment(txtLocal.CENTER);
        txtLocal.setForeground(Color.WHITE);
        txtLocal.setBackground(Color.DARK_GRAY);
        txtLocal.setSize(320, 35);
        txtLocal.setFont(font);
        txtLocal.setLocation(20, 165);
        this.add(txtLocal);

        txtFunciona = new JTextField(user.getHoraFun());
        txtFunciona.setHorizontalAlignment(txtFunciona.CENTER);
        txtFunciona.setForeground(Color.WHITE);
        txtFunciona.setBackground(Color.DARK_GRAY);
        txtFunciona.setSize(320, 35);
        txtFunciona.setFont(font);
        txtFunciona.setLocation(20, 215);
        this.add(txtFunciona);

        fldDesc = new JTextArea(user.getDescricao());
        fldDesc.setForeground(Color.WHITE);
        fldDesc.setBackground(Color.DARK_GRAY);
        fldDesc.setSize(320, 85);
        fldDesc.setFont(font);
        fldDesc.setLocation(20, 265);
        this.add(fldDesc);

        cmbLocFix = new JComboBox(local);
        cmbLocFix.setAlignmentX(CENTER_ALIGNMENT);
        cmbLocFix.setForeground(Color.WHITE);
        cmbLocFix.setBackground(Color.DARK_GRAY);
        cmbLocFix.setSize(155, 35);
        cmbLocFix.setFont(font);
        cmbLocFix.setLocation(20, 365);
        Object seleção1 = user.getTipoEmp();
        cmbLocFix.setSelectedItem(seleção1);
        this.add(cmbLocFix);

        cmbMatriz = new JComboBox(matriz);
        cmbMatriz.setAlignmentX(CENTER_ALIGNMENT);
        cmbMatriz.setForeground(Color.WHITE);
        cmbMatriz.setBackground(Color.DARK_GRAY);
        cmbMatriz.setSize(150, 35);
        cmbMatriz.setFont(font);
        cmbMatriz.setLocation(190, 365);
        Object seleção2 = user.getTipoEmp();
        cmbMatriz.setSelectedItem(seleção2);
        this.add(cmbMatriz);

        btnCancelaEmp = new JButton("VOLTAR");
        btnCancelaEmp.setForeground(Color.YELLOW);
        btnCancelaEmp.setBackground(Color.DARK_GRAY);
        btnCancelaEmp.setFont(font);
        btnCancelaEmp.setBounds(20, 415, 155, 30);
        btnCancelaEmp.setVisible(true);
        btnCancelaEmp.addActionListener(lstCan);
        btnCancelaEmp.setActionCommand(CancPerfEmp);
        this.add(btnCancelaEmp);

        btnConfirmarEmp = new JButton("CONFIRMAR");
        btnConfirmarEmp.setForeground(Color.YELLOW);
        btnConfirmarEmp.setVisible(true);
        btnConfirmarEmp.setBackground(Color.DARK_GRAY);
        btnConfirmarEmp.setFont(font);
        btnConfirmarEmp.setBounds(190, 415, 150, 30);
        btnConfirmarEmp.addActionListener(lstConf);
        btnConfirmarEmp.setActionCommand(ConfPerfEmp);
        this.add(btnConfirmarEmp);
    }

    public Usuario getUser(Usuario user) {
        Usuario novoUsuario = user;
        novoUsuario.setNome(this.getNome());
        novoUsuario.setTelefone(this.getTelefone());
        novoUsuario.setRazao(this.getRazao());
        novoUsuario.setHoraFun(this.getHoraFun());
        novoUsuario.setEndereço(this.getLocalizacao());
        novoUsuario.setDescricao(this.getDescricao());
        novoUsuario.setTipoLocal(this.getTipoLocal());
        novoUsuario.setTipoEmp(this.getTipoEmp());
        return novoUsuario;
    }

    public String getNome() {
        String nome = txtNome.getText();
        return nome;
    }

    public String getTelefone() {
        String telefone = txtContato.getText();
        return telefone;
    }

    public String getRazao() {
        String razao = txtRazao.getText();
        return razao;
    }

    public String getHoraFun() {
        String horario = txtFunciona.getText();
        return horario;
    }

    public String getLocalizacao() {
        String localiza = txtLocal.getText();
        return localiza;
    }

    public String getDescricao() {
        String desc = fldDesc.getText();
        return desc;
    }

    public String getTipoLocal() {
        String tipoL = (String) cmbLocFix.getSelectedItem();
        return tipoL;
    }

    public String getTipoEmp() {
        String tipoE = (String) cmbMatriz.getSelectedItem();
        return tipoE;
    }
}
