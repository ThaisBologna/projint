package projinter;

import java.awt.Color;
import javax.swing.JPanel;

public class PainelControleEmpresa extends JPanel {

    PainelTabelaEmpresa pnlTabelaEmpresa;
    PainelCabeçaEmpresa pnlCabeçaEmpresa;
    PainelBotãoTabelaEmpresa pnlBtnEmp;

    public PainelControleEmpresa(Usuario user, TelaPrincipal controle, AcessoBD acessoBD, int[] opção, Object[][] dados) {
        setLayout(null);
        setOpaque(true);
        setSize(680, 440);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);

        pnlCabeçaEmpresa = new PainelCabeçaEmpresa(user, controle, acessoBD, opção);
        pnlCabeçaEmpresa.setLocation(((this.getWidth() / 2) - (pnlCabeçaEmpresa.getWidth() / 2)), 0);
        this.add(pnlCabeçaEmpresa);

        pnlTabelaEmpresa = new PainelTabelaEmpresa(dados);
        pnlTabelaEmpresa.setLocation(((this.getWidth() / 2) - (pnlTabelaEmpresa.getWidth() / 2)), 75);
        this.add(pnlTabelaEmpresa);

        pnlBtnEmp = new PainelBotãoTabelaEmpresa(controle, controle, controle);
        pnlBtnEmp.setLocation(((this.getWidth() / 2) - (pnlBtnEmp.getWidth() / 2)), 380);
        this.add(pnlBtnEmp);
    }
}
