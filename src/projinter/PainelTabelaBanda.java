package projinter;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelTabelaBanda extends JPanel {

    private JScrollPane barraRolagem;
    private JTable tabela;

    public PainelTabelaBanda(Object[][] dados) {
        setLayout(new BorderLayout());
        setSize(680, 260);
        setOpaque(true);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);

        String[] colunas = {
            "ID Evento",
            "Nome",
            "Nome Empresa",
            "Cidade",
            "Dia/Hora",
            "Local",
            "Endereço",
            "Preço",
            "Status"
        };

        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        this.add(barraRolagem, BorderLayout.CENTER);
    }

    public String getCodEvento() {
        String cod = null;
        int i = tabela.getSelectedRow();

        if (tabela.isRowSelected(i)) {
            cod = (String) tabela.getValueAt(i, 0);
        }
        return cod;
    }
}
