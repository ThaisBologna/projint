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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastroUsuario extends JPanel implements FocusListener {

    public static final String CONFIRMAUser = "cnfu";
    public static final String CANCELAUser = "canu";

    private JComboBox cmbSexo,cmbCidade;
    private JButton btnConfirmarUser, btnCancelaUser;
    private JTextField txtNome2, txtEndereço2, txtTelefone2, txtDia2, txtMes2, txtAno2;
    private JTextField txtNome, txtEndereço, txtTelefone, txtDia, txtMes, txtAno;
    private Font font = new Font("Impact", Font.PLAIN, 22);
    private ActionListener lstCancelaUser, lstConfirmaUser;
    private final Map<JTextField, String> textos;
    private DefaultListCellRenderer dlcr;

    public PainelCadastroUsuario(ActionListener lstCan1, ActionListener lstConf1,AcessoBD acessoBD) {
        setLayout(null);
        setOpaque(true);
        setSize(360, 320);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        textos = new HashMap<>();
        
        dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        this.lstCancelaUser = lstCan1;
        this.lstConfirmaUser = lstConf1;

        txtNome2 = new JTextField("Nome");
        txtNome2.setHorizontalAlignment(txtNome2.CENTER);
        txtNome2.setForeground(Color.RED);
        txtNome2.setBackground(Color.DARK_GRAY);
        txtNome2.setSize(100, 35);
        txtNome2.setFont(font);
        txtNome2.setLocation(20, 20);
        this.add(txtNome2);
        
        txtNome = new JTextField();
        txtNome.setHorizontalAlignment(txtNome.CENTER);
        txtNome.setForeground(Color.BLACK);
        txtNome.setBackground(Color.WHITE);
        txtNome.setSize(200, 35);
        txtNome.setFont(font);
        txtNome.setLocation(140, 20);
        this.add(txtNome);

        txtEndereço2 = new JTextField("Endereço");
        txtEndereço2.setHorizontalAlignment(txtEndereço2.CENTER);
        txtEndereço2.setForeground(Color.RED);
        txtEndereço2.setBackground(Color.DARK_GRAY);
        txtEndereço2.setSize(100, 35);
        txtEndereço2.setFont(font);
        txtEndereço2.setLocation(20, 70);
        this.add(txtEndereço2);

        txtEndereço = new JTextField();
        txtEndereço.setHorizontalAlignment(txtEndereço.CENTER);
        txtEndereço.setForeground(Color.BLACK);
        txtEndereço.setBackground(Color.WHITE);
        txtEndereço.setSize(200, 35);
        txtEndereço.setFont(font);
        txtEndereço.setLocation(140, 70);
        this.add(txtEndereço);

        txtTelefone2 = new JTextField("Telefone");
        txtTelefone2.setHorizontalAlignment(txtTelefone2.CENTER);
        txtTelefone2.setForeground(Color.RED);
        txtTelefone2.setBackground(Color.DARK_GRAY);
        txtTelefone2.setSize(100, 35);
        txtTelefone2.setFont(font);
        txtTelefone2.setLocation(20, 120);
        this.add(txtTelefone2);
        
        txtTelefone = new JTextField();
        txtTelefone.setHorizontalAlignment(txtTelefone.CENTER);
        txtTelefone.setForeground(Color.BLACK);
        txtTelefone.setBackground(Color.WHITE);
        txtTelefone.setSize(200, 35);
        txtTelefone.setFont(font);
        txtTelefone.setLocation(140, 120);
        this.add(txtTelefone);

        txtDia = new JTextField("DD");
        txtDia.setHorizontalAlignment(txtDia.CENTER);
        txtDia.setForeground(Color.WHITE);
        txtDia.setBackground(Color.DARK_GRAY);
        txtDia.setSize(92, 35);
        txtDia.setFont(font);
        txtDia.setLocation(20, 170);
        this.add(txtDia);

        txtMes = new JTextField("MM");
        txtMes.setHorizontalAlignment(txtMes.CENTER);
        txtMes.setForeground(Color.WHITE);
        txtMes.setBackground(Color.DARK_GRAY);
        txtMes.setSize(92, 35);
        txtMes.setFont(font);
        txtMes.setLocation(132, 170);
        this.add(txtMes);

        txtAno = new JTextField("AAAA");
        txtAno.setHorizontalAlignment(txtAno.CENTER);
        txtAno.setForeground(Color.WHITE);
        txtAno.setBackground(Color.DARK_GRAY);
        txtAno.setSize(94, 35);
        txtAno.setFont(font);
        txtAno.setLocation(244, 170);
        this.add(txtAno);

        //cmbCidade = new JComboBox(acessoBD.listaCidades());
        String strt = new String("Cidade");
        
        String[] city = {"Cidade", "", ""};
        cmbCidade = new JComboBox(city);
        cmbCidade.setAlignmentX(CENTER_ALIGNMENT);
        cmbCidade.setForeground(Color.WHITE);
        cmbCidade.setBackground(Color.DARK_GRAY);
        cmbCidade.setSize(155, 35);
        cmbCidade.setFont(font);
        cmbCidade.setLocation(20, 220);
        cmbCidade.setRenderer(dlcr);
        this.add(cmbCidade);

  

        String[] sexo = {"SEXO", "Masculino", "Feminino"};

        cmbSexo = new JComboBox(sexo);
        cmbSexo.setAlignmentX(CENTER_ALIGNMENT);
        cmbSexo.setForeground(Color.WHITE);
        cmbSexo.setBackground(Color.DARK_GRAY);
        cmbSexo.setSize(150, 35);
        cmbSexo.setFont(font);
        cmbSexo.setLocation(190, 220);
        cmbSexo.setRenderer(dlcr);
        this.add(cmbSexo);

        btnCancelaUser = new JButton("VOLTAR");
        btnCancelaUser.setForeground(Color.YELLOW);
        btnCancelaUser.setBackground(Color.DARK_GRAY);
        btnCancelaUser.setFont(font);
        btnCancelaUser.setBounds(20, 270, 155, 30);
        btnCancelaUser.setVisible(true);
        btnCancelaUser.addActionListener(lstCan1);
        btnCancelaUser.setActionCommand(CANCELAUser);
        this.add(btnCancelaUser);

        btnConfirmarUser = new JButton("CADASTRAR");
        btnConfirmarUser.setForeground(Color.YELLOW);
        btnConfirmarUser.setVisible(true);
        btnConfirmarUser.setBackground(Color.DARK_GRAY);
        btnConfirmarUser.setFont(font);
        btnConfirmarUser.setBounds(190, 270, 150, 30);
        btnConfirmarUser.addActionListener(lstConf1);
        btnConfirmarUser.setActionCommand(CONFIRMAUser);
        this.add(btnConfirmarUser);
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

    public String getEndereço() {
        String endereço = txtEndereço.getText();
        return endereço;
    }

    public String getTelefone() {
        String telefone = txtTelefone.getText();
        return telefone;
    }

    public String getDataNasc() {
        String dia = txtDia.getText();
        String mes = txtMes.getText();
        String ano = txtAno.getText();
        String dataNasc = ano + "-" + mes + "-" + dia;
        return dataNasc;
    }

    public String getSexo() {
        String sexo = (String) cmbSexo.getSelectedItem();
        return sexo;
    }

    public String getCidade() {
        String cidade = (String)cmbCidade.getSelectedItem();
        return cidade;
    }

}
