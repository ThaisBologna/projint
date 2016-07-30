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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelCadastroBanda extends JPanel implements FocusListener {

    public static final String CONFIRMABanda = "cnfb";
    public static final String CANCELABanda = "canb";

    
    private JTextArea txaDescricao;
    private JButton btnConfirmaBanda, btnCancelaBanda;
    private JTextField txtNome, txtTelefone, txtEstilo;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private ActionListener lstCancelaBanda, lstConfirmaBanda;
    private final Map<JTextField, String> textos;

    public PainelCadastroBanda(ActionListener lstCan1, ActionListener lstConf1) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 350);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        textos = new HashMap<>();

        this.lstCancelaBanda = lstCan1;
        this.lstConfirmaBanda = lstConf1;

        txtNome = new JTextField("Nome");
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.WHITE);
        txtNome.setBackground(Color.DARK_GRAY);
        txtNome.setSize(320, 35);
        txtNome.setFont(font);
        txtNome.setLocation(20, 20);
        this.add(txtNome);
        txtNome.addFocusListener(this);
        textos.put(txtNome, "txtNome");

        txtTelefone = new JTextField("Telefone");
        txtTelefone.setHorizontalAlignment(txtTelefone.CENTER);
        txtTelefone.setForeground(Color.WHITE);
        txtTelefone.setBackground(Color.DARK_GRAY);
        txtTelefone.setSize(320, 35);
        txtTelefone.setFont(font);
        txtTelefone.setLocation(20, 70);
        this.add(txtTelefone);
        txtTelefone.addFocusListener(this);
        textos.put(txtTelefone, "Telefone");

        txtEstilo = new JTextField("Estilo");
        txtEstilo.setHorizontalAlignment(txtEstilo.CENTER);
        txtEstilo.setForeground(Color.WHITE);
        txtEstilo.setBackground(Color.DARK_GRAY);
        txtEstilo.setSize(320, 35);
        txtEstilo.setFont(font);
        txtEstilo.setLocation(20, 120);
        this.add(txtEstilo);

        txaDescricao = new JTextArea("Descrição");
        txaDescricao.setForeground(Color.WHITE);
        txaDescricao.setBackground(Color.DARK_GRAY);
        txaDescricao.setSize(320, 90);
        txaDescricao.setFont(font);
        txaDescricao.setLocation(20, 170);
        this.add(txaDescricao);
        
        btnCancelaBanda = new JButton("VOLTAR");
        btnCancelaBanda.setForeground(Color.YELLOW);
        btnCancelaBanda.setBackground(Color.DARK_GRAY);
        btnCancelaBanda.setFont(font);
        btnCancelaBanda.setBounds(20, 270, 155, 30);
        btnCancelaBanda.setVisible(true);
        btnCancelaBanda.addActionListener(lstCan1);
        btnCancelaBanda.setActionCommand(CANCELABanda);
        this.add(btnCancelaBanda);

        btnConfirmaBanda = new JButton("CONFIRMAR");
        btnConfirmaBanda.setForeground(Color.YELLOW);
        btnConfirmaBanda.setVisible(true);
        btnConfirmaBanda.setBackground(Color.DARK_GRAY);
        btnConfirmaBanda.setFont(font);
        btnConfirmaBanda.setBounds(190, 270, 150, 30);
        btnConfirmaBanda.addActionListener(lstConf1);
        btnConfirmaBanda.setActionCommand(CONFIRMABanda);
        this.add(btnConfirmaBanda);
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField txt = (JTextField) e.getSource();
        String str = textos.get(txt);
        if (txt.getText().equals(str)) {
            txt.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField txt = (JTextField) e.getSource();
        if (txt.getText().trim().equals("")) {
            String str = textos.get(txt);
            txt.setText(str);
        }
    }

    public String getNome() {
        String Nome = txtNome.getText();
        return Nome;
    }

    public String getTelefone() {
        String telefone = txtTelefone.getText();
        return telefone;
    }
    
    public String getEstilo() {
        String estilo = txtEstilo.getText();
        return estilo;
    }
    
    public String getDescrição() {
        String descrição = txaDescricao.getText();
        return descrição;
    }

}