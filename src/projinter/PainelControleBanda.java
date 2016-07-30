package projinter;

import java.awt.Color;
import javax.swing.JPanel;

public class PainelControleBanda extends JPanel{

    PainelTabelaBanda pnlTabela;
    PainelCabeçaBanda pnlCabeçaBanda;

    PainelBotãoTabelaBanda pnlBtnBanda;
    public PainelControleBanda() {
    }

    public PainelControleBanda(Usuario user, TelaPrincipal controle, AcessoBD acessoBD, int[] opção, Object[][] dados) {
        setLayout(null);
        setOpaque(true);
        setSize(680, 440);
        setBackground(new Color(0, 0, 0, 0));
        setVisible(true);

        pnlCabeçaBanda = new PainelCabeçaBanda(user, controle, acessoBD, opção);
        pnlCabeçaBanda.setLocation(((this.getWidth() / 2) - (pnlCabeçaBanda.getWidth() / 2)), 0);
        this.add(pnlCabeçaBanda);

        pnlTabela = new PainelTabelaBanda(dados);
        pnlTabela.setLocation(((this.getWidth() / 2) - (pnlTabela.getWidth() / 2)), 100);
        this.add(pnlTabela);
        
        
        pnlBtnBanda = new PainelBotãoTabelaBanda(controle, controle);
        pnlBtnBanda.setLocation(((this.getWidth() / 2) - (pnlBtnBanda.getWidth() / 2)), 380);
        this.add(pnlBtnBanda);

    }
}
