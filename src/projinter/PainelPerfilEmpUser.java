package projinter;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelPerfilEmpUser extends JPanel {

    private JTextArea fldDesc;
    private JTextField txtTipoEmp, txtTipoLocal, txtNome, txtRazao, txtContato, txtLocal, txtFunciona;
    private Font font = new Font("Impact", Font.PLAIN, 20);

    public PainelPerfilEmpUser(Object[][] empresa) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 460);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        txtNome = new JTextField((String)empresa[0][0]);
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.WHITE);
        txtNome.setBackground(Color.DARK_GRAY);
        txtNome.setSize(320, 35);
        txtNome.setFont(font);
        txtNome.setLocation(20, 15);
        this.add(txtNome);

        txtRazao = new JTextField((String)empresa[0][1]);
        txtRazao.setHorizontalAlignment(txtRazao.CENTER);
        txtRazao.setForeground(Color.WHITE);
        txtRazao.setBackground(Color.DARK_GRAY);
        txtRazao.setSize(320, 35);
        txtRazao.setFont(font);
        txtRazao.setLocation(20, 65);
        this.add(txtRazao);

        txtContato = new JTextField((String)empresa[0][3]);
        txtContato.setHorizontalAlignment(txtContato.CENTER);
        txtContato.setForeground(Color.WHITE);
        txtContato.setBackground(Color.DARK_GRAY);
        txtContato.setSize(320, 35);
        txtContato.setFont(font);
        txtContato.setLocation(20, 115);
        this.add(txtContato);

        txtLocal = new JTextField((String)empresa[0][4]);
        txtLocal.setHorizontalAlignment(txtLocal.CENTER);
        txtLocal.setForeground(Color.WHITE);
        txtLocal.setBackground(Color.DARK_GRAY);
        txtLocal.setSize(320, 35);
        txtLocal.setFont(font);
        txtLocal.setLocation(20, 165);
        this.add(txtLocal);

        txtFunciona = new JTextField((String)empresa[0][5]);
        txtFunciona.setHorizontalAlignment(txtFunciona.CENTER);
        txtFunciona.setForeground(Color.WHITE);
        txtFunciona.setBackground(Color.DARK_GRAY);
        txtFunciona.setSize(320, 35);
        txtFunciona.setFont(font);
        txtFunciona.setLocation(20, 215);
        this.add(txtFunciona);

        txtTipoEmp = new JTextField((String)empresa[0][6]);
        txtTipoEmp.setHorizontalAlignment(txtTipoEmp.CENTER);
        txtTipoEmp.setForeground(Color.WHITE);
        txtTipoEmp.setBackground(Color.DARK_GRAY);
        txtTipoEmp.setSize(150, 35);
        txtTipoEmp.setFont(font);
        txtTipoEmp.setLocation(20, 265);
        this.add(txtTipoEmp);

        txtTipoLocal = new JTextField((String)empresa[0][7]);
        txtTipoLocal.setHorizontalAlignment(txtTipoLocal.CENTER);
        txtTipoLocal.setForeground(Color.WHITE);
        txtTipoLocal.setBackground(Color.DARK_GRAY);
        txtTipoLocal.setSize(150, 35);
        txtTipoLocal.setFont(font);
        txtTipoLocal.setLocation(190, 265);
        this.add(txtTipoLocal);

        fldDesc = new JTextArea((String)empresa[0][2]);
        fldDesc.setForeground(Color.WHITE);
        fldDesc.setBackground(Color.DARK_GRAY);
        fldDesc.setSize(320, 85);
        fldDesc.setFont(font);
        fldDesc.setLocation(20, 315);
        this.add(fldDesc);
    }
}
