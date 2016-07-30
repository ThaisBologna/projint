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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelCadastroEmpresa extends JPanel implements FocusListener {

    public static final String CONFIRMAEmp = "swsws";
    public static final String CANCELAEmp = "wsws";

    private JTextArea fldDesc;
    private JComboBox cmbMatriz, cmbLocFix;
    private JButton btnConfirmarEmp, btnCancelaEmp;
    private JTextField txtNome,txtRazao, txtContato, txtLocal, txtFunciona;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private ActionListener lstCancelaEmp, lstConfirmaEmp;
    private final Map<JTextField, String> textos;

    public PainelCadastroEmpresa(ActionListener lstCanEmp, ActionListener lstConfEmp) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 460);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        textos = new HashMap<>();

        String[] local = {"Fixo", "Itinerante"};
        String[] matriz = {"Filial", "Matriz"};

        this.lstCancelaEmp = lstCanEmp;
        this.lstConfirmaEmp = lstConfEmp;

        txtNome = new JTextField("Nome");
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.WHITE);
        txtNome.setBackground(Color.DARK_GRAY);
        txtNome.setSize(320, 35);
        txtNome.setFont(font);
        txtNome.setLocation(20, 15);
        this.add(txtNome);
        
        txtRazao = new JTextField("Razao");
        txtRazao.setHorizontalAlignment(txtRazao.CENTER);
        txtRazao.setForeground(Color.WHITE);
        txtRazao.setBackground(Color.DARK_GRAY);
        txtRazao.setSize(320, 35);
        txtRazao.setFont(font);
        txtRazao.setLocation(20, 65);
        this.add(txtRazao);

        txtContato = new JTextField("Telefone");
        txtContato.setHorizontalAlignment(txtContato.CENTER);
        txtContato.setForeground(Color.WHITE);
        txtContato.setBackground(Color.DARK_GRAY);
        txtContato.setSize(320, 35);
        txtContato.setFont(font);
        txtContato.setLocation(20, 115);
        this.add(txtContato);

        txtLocal = new JTextField("Endereço");
        txtLocal.setHorizontalAlignment(txtLocal.CENTER);
        txtLocal.setForeground(Color.WHITE);
        txtLocal.setBackground(Color.DARK_GRAY);
        txtLocal.setSize(320, 35);
        txtLocal.setFont(font);
        txtLocal.setLocation(20, 165);
        this.add(txtLocal);

        txtFunciona = new JTextField("Horário de Funcionamento");
        txtFunciona.setHorizontalAlignment(txtFunciona.CENTER);
        txtFunciona.setForeground(Color.WHITE);
        txtFunciona.setBackground(Color.DARK_GRAY);
        txtFunciona.setSize(320, 35);
        txtFunciona.setFont(font);
        txtFunciona.setLocation(20, 215);
        this.add(txtFunciona);

        fldDesc = new JTextArea("Descrição");
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
        this.add(cmbLocFix);

        cmbMatriz = new JComboBox(matriz);
        cmbMatriz.setAlignmentX(CENTER_ALIGNMENT);
        cmbMatriz.setForeground(Color.WHITE);
        cmbMatriz.setBackground(Color.DARK_GRAY);
        cmbMatriz.setSize(150, 35);
        cmbMatriz.setFont(font);
        cmbMatriz.setLocation(190, 365);
        this.add(cmbMatriz);

        btnCancelaEmp = new JButton("VOLTAR");
        btnCancelaEmp.setForeground(Color.YELLOW);
        btnCancelaEmp.setBackground(Color.DARK_GRAY);
        btnCancelaEmp.setFont(font);
        btnCancelaEmp.setBounds(20, 415, 155, 30);
        btnCancelaEmp.setVisible(true);
        btnCancelaEmp.addActionListener(lstCanEmp);
        btnCancelaEmp.setActionCommand(CANCELAEmp);
        this.add(btnCancelaEmp);

        btnConfirmarEmp = new JButton("CONFIRMAR");
        btnConfirmarEmp.setForeground(Color.YELLOW);
        btnConfirmarEmp.setVisible(true);
        btnConfirmarEmp.setBackground(Color.DARK_GRAY);
        btnConfirmarEmp.setFont(font);
        btnConfirmarEmp.setBounds(190, 415, 150, 30);
        btnConfirmarEmp.addActionListener(lstConfEmp);
        btnConfirmarEmp.setActionCommand(CONFIRMAEmp);
        this.add(btnConfirmarEmp);
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
}
