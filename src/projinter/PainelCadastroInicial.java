/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PainelCadastroInicial extends JPanel {

    public static final String CONFIRMAR = "conf";
    public static final String VOLTAR = "volt";

    private JComboBox cmbTipoUser;
    private JButton btnConfirmar, btnVoltar;
    private JTextField txtLogin,txtLogin2, txtSenha,txtSenha2, txtEmail,txtEmail2,txtCadastrar;
    private JPasswordField pwdSenha;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private ActionListener lstVolta, lstConfirma;
    private final Map<JTextField, String> textos;
    private DefaultListCellRenderer dlcr;

    public PainelCadastroInicial(ActionListener lstVoltar, ActionListener lstConfirmar) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 330);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        
        textos = new HashMap<>();

        this.lstVolta = lstVoltar;
        this.lstConfirma = lstConfirmar;

        txtLogin2 = new JTextField("Login");
        txtLogin2.setHorizontalAlignment(txtLogin.CENTER);
        txtLogin2.setForeground(Color.RED);
        txtLogin2.setBackground(Color.DARK_GRAY);
        txtLogin2.setSize(100, 35);
        txtLogin2.setFont(font);
        txtLogin2.setLocation(20, 20);
        txtLogin2.setEditable(false);
        this.add(txtLogin2);
        
        txtLogin = new JTextField();
        txtLogin.setHorizontalAlignment(txtLogin.CENTER);
        txtLogin.setForeground(Color.BLACK);
        txtLogin.setBackground(Color.WHITE);
        txtLogin.setSize(200, 35);
        txtLogin.setFont(font);
        txtLogin.setLocation(140, 20);
        this.add(txtLogin);

        txtSenha2 = new JTextField("Senha");
        txtSenha2.setHorizontalAlignment(txtSenha2.CENTER);
        txtSenha2.setForeground(Color.RED);
        txtSenha2.setBackground(Color.DARK_GRAY);
        txtSenha2.setSize(100, 35);
        txtSenha2.setFont(font);
        txtSenha2.setLocation(20, 70);
        txtSenha2.setEditable(false);
        this.add(txtSenha2);

        pwdSenha = new JPasswordField("");
        pwdSenha.setHorizontalAlignment(pwdSenha.CENTER);
        pwdSenha.setForeground(Color.BLACK);
        pwdSenha.setBackground(Color.WHITE);
        pwdSenha.setSize(200, 35);
        pwdSenha.setFont(font);
        pwdSenha.setLocation(140, 70);
        this.add(pwdSenha);

        txtEmail2 = new JTextField("E-mail");
        txtEmail2.setHorizontalAlignment(txtEmail2.CENTER);
        txtEmail2.setForeground(Color.RED);
        txtEmail2.setBackground(Color.DARK_GRAY);
        txtEmail2.setSize(100, 35);
        txtEmail2.setFont(font);
        txtEmail2.setLocation(20, 120);
        txtEmail2.setEditable(false);
        this.add(txtEmail2);
        
        txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(txtEmail.CENTER);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setBackground(Color.WHITE);
        txtEmail.setSize(200, 35);
        txtEmail.setFont(font);
        txtEmail.setLocation(140, 120);
        this.add(txtEmail);
        
        txtCadastrar = new JTextField("Cadastrar");
        txtCadastrar.setHorizontalAlignment(txtCadastrar.CENTER);
        txtCadastrar.setForeground(Color.RED);
        txtCadastrar.setBackground(Color.DARK_GRAY);
        txtCadastrar.setSize(100, 35);
        txtCadastrar.setFont(font);
        txtCadastrar.setLocation(20, 170);
        this.add(txtCadastrar);
        
        String[] tipoUser = {"USUARIO", "BANDA", "EMPRESA"};

        cmbTipoUser = new JComboBox(tipoUser);
        cmbTipoUser.setAlignmentX(CENTER_ALIGNMENT);
        cmbTipoUser.setForeground(Color.WHITE);
        cmbTipoUser.setBackground(Color.DARK_GRAY);
        cmbTipoUser.setSize(200, 35);
        cmbTipoUser.setFont(font);
        cmbTipoUser.setLocation(140, 170);
        cmbTipoUser.setRenderer(dlcr);
        this.add(cmbTipoUser);

        btnVoltar = new JButton("VOLTAR");
        btnVoltar.setForeground(Color.YELLOW);
        btnVoltar.setBackground(Color.DARK_GRAY);
        btnVoltar.setFont(font);
        btnVoltar.setBounds(20, 250, 155, 50);
        btnVoltar.setVisible(true);
        btnVoltar.addActionListener(lstVoltar);
        btnVoltar.setActionCommand(VOLTAR);
        this.add(btnVoltar);

        btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.setForeground(Color.YELLOW);
        btnConfirmar.setVisible(true);
        btnConfirmar.setBackground(Color.DARK_GRAY);
        btnConfirmar.setFont(font);
        btnConfirmar.setBounds(190, 250, 150, 50);
        btnConfirmar.addActionListener(lstConfirmar);
        btnConfirmar.setActionCommand(CONFIRMAR);
        this.add(btnConfirmar);
    }
    public String getTipo(){
        String tipo = (String)cmbTipoUser.getSelectedItem();
        return tipo;
    }
    
    public String getLogin() {
        String login = txtLogin.getText();
        return login;
    }

    public String getSenha() {
        String senha = new String(pwdSenha.getPassword());
        return senha;
    }

    public String getEmail() {
        String email = txtEmail.getText();
        return email;
    }
}


