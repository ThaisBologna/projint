/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projinter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastro extends JPanel implements FocusListener{     
    
    public static final String CONFIRMAR = "conf";
    public static final String VOLTAR = "volt";

    private JButton btnConfirmar, btnVoltar;
    private JTextField txtLogin, txtSenha,txtSexo,txtTelefone,txtEnd,txtCpf;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private ActionListener lstVolta, lstConfirma;
    private final Map<JTextField, String> textos;
    
    public PainelCadastro(ActionListener lstVoltar, ActionListener lstConfirmar) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 370);        
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);
        
        textos = new HashMap<>();
        
        this.lstVolta = lstVoltar;
        this.lstConfirma = lstConfirmar;
 
        txtLogin = new JTextField("Login");
        txtLogin.setHorizontalAlignment(txtLogin.CENTER);
        txtLogin.setForeground(Color.WHITE);
        txtLogin.setBackground(Color.DARK_GRAY);
        txtLogin.setSize(320, 35);
        txtLogin.setFont(font);
        txtLogin.setLocation(20, 20);
        this.add(txtLogin);
        txtLogin.addFocusListener(this);
        textos.put(txtLogin, "Login");

        txtSenha = new JTextField("Senha");
        txtSenha.setHorizontalAlignment(txtSenha.CENTER);
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setBackground(Color.DARK_GRAY);
        txtSenha.setSize(320, 35);
        txtSenha.setFont(font);
        txtSenha.setLocation(20, 70);
        this.add(txtSenha);
        txtSenha.addFocusListener(this);
        textos.put(txtSenha, "Senha");

        txtSexo = new JTextField("Sexo");
        txtSexo.setHorizontalAlignment(txtSexo.CENTER);
        txtSexo.setForeground(Color.WHITE);
        txtSexo.setBackground(Color.DARK_GRAY);
        txtSexo.setSize(320, 35);
        txtSexo.setFont(font);
        txtSexo.setLocation(20, 120);
        this.add(txtSexo);
        txtSexo.addFocusListener(this);
        textos.put(txtSexo, "Sexo");

        txtTelefone = new JTextField("Telefone");
        txtTelefone.setHorizontalAlignment(txtTelefone.CENTER);
        txtTelefone.setForeground(Color.WHITE);
        txtTelefone.setBackground(Color.DARK_GRAY);
        txtTelefone.setSize(320, 35);
        txtTelefone.setFont(font);
        txtTelefone.setLocation(20, 170);
        this.add(txtTelefone);
        txtTelefone.addFocusListener(this);
        textos.put(txtTelefone, "Telefone");

        txtEnd = new JTextField("Endereço");
        txtEnd.setHorizontalAlignment(txtEnd.CENTER);
        txtEnd.setForeground(Color.WHITE);
        txtEnd.setBackground(Color.DARK_GRAY);
        txtEnd.setSize(320, 35);
        txtEnd.setFont(font);
        txtEnd.setLocation(20, 220);
        this.add(txtEnd);
        txtEnd.addFocusListener(this);
        textos.put(txtEnd, "Endereço");

        txtCpf = new JTextField("CPF");
        txtCpf.setHorizontalAlignment(txtCpf.CENTER);
        txtCpf.setForeground(Color.WHITE);
        txtCpf.setBackground(Color.DARK_GRAY);
        txtCpf.setSize(320, 35);
        txtCpf.setFont(font);
        txtCpf.setLocation(20, 270);
        this.add(txtCpf);
        txtCpf.addFocusListener(this);
        textos.put(txtCpf, "CPF");

        btnVoltar = new JButton("VOLTAR");
        btnVoltar.setForeground(Color.YELLOW);
        btnVoltar.setBackground(Color.DARK_GRAY);
        btnVoltar.setFont(font);
        btnVoltar.setBounds(20, 320, 155, 30);
        btnVoltar.setVisible(true);
        btnVoltar.addActionListener(lstVoltar);
        btnVoltar.setActionCommand(VOLTAR);
        this.add(btnVoltar);

        btnConfirmar = new JButton("CONFIRMAR");
        btnConfirmar.setForeground(Color.YELLOW);
        btnConfirmar.setVisible(true);
        btnConfirmar.setBackground(Color.DARK_GRAY);
        btnConfirmar.setFont(font);
        btnConfirmar.setBounds(190, 320, 150, 30);
        btnConfirmar.addActionListener(lstConfirmar);
        btnConfirmar.setActionCommand(CONFIRMAR);
        this.add(btnConfirmar);
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField txt = (JTextField) e.getSource();
        String str = textos.get(txt);
        
        if (txt.getText().equals(str)){
            txt.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField txt = (JTextField)e.getSource();        
        
        if (txt.getText().trim().equals("")){
            String str = textos.get(txt);
            txt.setText(str);
        }
    }
    public String getLogin(){
        String login = txtLogin.getText();
        return login;
    }
    public String getSenha(){
        String senha = txtSenha.getText();
        return senha;
    }

}
