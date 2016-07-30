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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PainelLogin extends JPanel {

    public static final String CADASTRAR = "cad";
    public static final String ENTRAR = "ent";
    public static final String SAIR = "sai";

    private JButton btnCadastrar, btnLogar, btnSair;
    private JTextField txtLogin, txtLogin2, txtSenha,txtSenhaErrada;
    private JPasswordField pwdSenha;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private ActionListener lstCadastro, lstLogar, lstSair;
    private final Map<JTextField, String> textos;

    public PainelLogin(ActionListener lstCadastrar, ActionListener lstLoga, ActionListener lstSai) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 280);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        textos = new HashMap<>();

        this.lstCadastro = lstCadastrar;
        this.lstLogar = lstLoga;
        this.lstSair = lstSai;

        txtLogin = new JTextField("");
        txtLogin.setHorizontalAlignment(txtLogin.CENTER);
        txtLogin.setForeground(Color.BLACK);
        txtLogin.setBackground(Color.WHITE);
        txtLogin.setSize(200, 35);
        txtLogin.setFont(font);
        txtLogin.setLocation(140, 20);
        this.add(txtLogin);
        
        txtLogin2 = new JTextField("LOGIN");
        txtLogin2.setHorizontalAlignment(txtLogin2.CENTER);
        txtLogin2.setForeground(Color.RED);
        txtLogin2.setBackground(Color.DARK_GRAY);
        txtLogin2.setSize(100, 35);
        txtLogin2.setFont(font);
        txtLogin2.setLocation(20, 20);
        txtLogin2.setEditable(false);
        this.add(txtLogin2);
        
        txtSenha = new JTextField("SENHA");
        txtSenha.setHorizontalAlignment(txtSenha.CENTER);
        txtSenha.setForeground(Color.RED);
        txtSenha.setBackground(Color.DARK_GRAY);
        txtSenha.setSize(100, 35);
        txtSenha.setFont(font);
        txtSenha.setEditable(false);
        txtSenha.setLocation(20, 70);
        this.add(txtSenha);

        pwdSenha = new JPasswordField("");
        pwdSenha.setHorizontalAlignment(pwdSenha.CENTER);
        pwdSenha.setForeground(Color.BLACK);
        pwdSenha.setBackground(Color.WHITE);
        pwdSenha.setSize(200, 35);
        pwdSenha.setFont(font);
        pwdSenha.setLocation(140, 70);
        this.add(pwdSenha);

        
        txtSenhaErrada = new JTextField("Senha ou Login incorreto");
        txtSenhaErrada.setHorizontalAlignment(txtSenhaErrada.CENTER);
        txtSenhaErrada.setForeground(Color.BLACK);
        txtSenhaErrada.setBackground(Color.RED);
        txtSenhaErrada.setSize(250, 35);
        txtSenhaErrada.setFont(font);
        txtSenhaErrada.setEditable(false);
        txtSenhaErrada.setLocation((this.getWidth() / 2) - (txtSenhaErrada.getWidth() / 2), (this.getHeight() / 2) - (txtSenhaErrada.getHeight() / 2));
        this.add(txtSenhaErrada);

        btnLogar = new JButton("LOGAR");
        btnLogar.setForeground(Color.YELLOW);
        btnLogar.setVisible(true);
        btnLogar.setBackground(Color.DARK_GRAY);
        btnLogar.setFont(font);
        btnLogar.setBounds(20, 170, 320, 30);
        btnLogar.addActionListener(lstLoga);
        btnLogar.setActionCommand(ENTRAR);
        this.add(btnLogar);

        btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setForeground(Color.YELLOW);
        btnCadastrar.setBackground(Color.DARK_GRAY);
        btnCadastrar.setFont(font);
        btnCadastrar.setBounds(20, 220, 150, 30);
        btnCadastrar.setVisible(true);
        btnCadastrar.addActionListener(lstCadastro);
        btnCadastrar.setActionCommand(CADASTRAR);
        this.add(btnCadastrar);

        btnSair = new JButton("SAIR");
        btnSair.setForeground(Color.RED);
        btnSair.setVisible(true);
        btnSair.setBackground(Color.DARK_GRAY);
        btnSair.setFont(font);
        btnSair.setBounds(190, 220, 150, 30);
        btnSair.addActionListener(lstLoga);
        btnSair.setActionCommand(SAIR);
        this.add(btnSair);

    }
    public String getLogin() {
        String login = txtLogin.getText();
        return login;
    }

    public String getSenha() {
        String senha = pwdSenha.getText();
        return senha;
    }

    public void resetaLoginPass() {
        txtLogin.setText("");
        pwdSenha.setText("");
    }


}
