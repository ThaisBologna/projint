package projinter;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelTabelaEmpresa extends JPanel {

    private JScrollPane barraRolagem;
    private JTable tabela;
    Object[][] dadosTabela;

    public PainelTabelaEmpresa(Object[][] dados) {
        setLayout(new BorderLayout());
        setSize(680, 285);
        setOpaque(true);
        setBackground(new Color(255, 255, 255, 100));
        setVisible(true);
        dadosTabela = dados;
        String[] colunas = {
            "ID Evento",
            "Nome",
            "id_banda",
            "Cidade",
            "Dia/Hora",
            "Local",
            "Endereço",
            "Preço",
            "Status"
        };

        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(0, 0, 680, 285);
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
