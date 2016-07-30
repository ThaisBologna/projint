/*
 Projeto interdisciplinar do terceiro semestre.
 O aplicativo será sobre eventos e casas noturnas.
 GRUPO: Pedro, Neide, Thais e Lucas.
 */
package projinter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame implements ActionListener {

    PainelLogin pnlLogin;
    PainelCadastroInicial pnlCadastroInicial;
    PainelCadastroUsuario pnlCadastroUsuario;
    PainelCadastroEmpresa pnlCadastroEmpresa;
    PainelCadastroBanda pnlCadastroBanda;
    PainelControleUsuario pnlControleUsuario;
    PainelControleEmpresa pnlControleEmpresa;
    PainelControleBanda pnlControleBanda;
    PainelAcessoNegado pnlAcessoNegado;
    PainelImagemEvento pnlImagemEmpresa;
    AcessoBD acessoBD;
    Usuario user;
    CriaDataHora listar;
    TelaCriarEvento telaCriarEvento;
    TelaEditarEvento telaEditarEvento;
    TelaPerfil telaPerfil;
    TelaConfirmaDelete telaConfirmaDelete;
    TelaPerfilBanda telaPerfilBanda;
    TelaPerfilEmpresa telaPerfilEmpresa;
    int[] opção = new int[]{0, 0};
    String cod = null;
    int adição = 0;
    Evento evento;

    private JPanel panFundo;
    private JLabel imgFundo;

    public TelaPrincipal() {
        super("Tonight");
        setSize(720, 480);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        user = new Usuario();
        acessoBD = new AcessoBD();
        acessoBD.conecta();
        listar = new CriaDataHora();

        panFundo = new JPanel();
        panFundo.setLayout(null);
        panFundo.setSize(this.getSize());
        add(panFundo);

        ImageIcon img = new ImageIcon("./src/img/balada1.jpg");
        imgFundo = new JLabel(img);
        imgFundo.setSize(img.getIconWidth(), img.getIconHeight());
        panFundo.add(imgFundo);

        pnlLogin = new PainelLogin(this, this, this);
        trocarPainel(pnlLogin);
    }

    public void trocarPainel(JPanel painel) {
        getContentPane().removeAll();
        painel.setLocation((this.getWidth() / 2) - (painel.getWidth() / 2), (this.getHeight() / 2) - (painel.getHeight() / 2));
        getContentPane().add(painel);
        getContentPane().add(panFundo);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        TelaPrincipal start = new TelaPrincipal();
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setVisible(true);
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(PainelLogin.CADASTRAR)) {
            pnlCadastroInicial = new PainelCadastroInicial(this, this);
            trocarPainel(pnlCadastroInicial);
        } else if (e.getActionCommand().equals(PainelLogin.ENTRAR)) {
            user.setLogin(pnlLogin.getLogin());
            user.setSenha(pnlLogin.getSenha());
            if (acessoBD.tentarLogin(user)) {
                user = acessoBD.getUser(user);
                if (user.getTipo().equals("USUARIO")) {
                    pnlControleUsuario = new PainelControleUsuario(user, this, this, acessoBD, opção, adição);
                    trocarPainel(pnlControleUsuario);
                } else if (user.getTipo().equals("EMPRESA")) {
                    pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaTodosAtivos(user));
                    trocarPainel(pnlControleEmpresa);
                } else if (user.getTipo().equals("BANDA")) {
                    pnlControleBanda = new PainelControleBanda(user, this, acessoBD, opção, acessoBD.eventosBandaTodos(user));
                    trocarPainel(pnlControleBanda);
                }
            } else {
                pnlLogin.resetaLoginPass();
                pnlAcessoNegado = new PainelAcessoNegado(this);
                trocarPainel(pnlAcessoNegado);
            }
        } else if (e.getActionCommand().equals(PainelAgenda.Avançar)) {
            adição = adição + 1;
            pnlControleUsuario = new PainelControleUsuario(user, this, this, acessoBD, opção, adição);
            trocarPainel(pnlControleUsuario);
        } else if (e.getActionCommand().equals(PainelAgenda.Retroceder)) {
            if (adição > 0) {
                adição = adição - 1;
                pnlControleUsuario = new PainelControleUsuario(user, this, this, acessoBD, opção, adição);
                trocarPainel(pnlControleUsuario);
            }
        } else if (e.getActionCommand().equals(PainelAcessoNegado.OK)) {
            trocarPainel(pnlLogin);
        } else if (e.getActionCommand().equals(PainelCadastro.VOLTAR)) {
            trocarPainel(pnlLogin);
        } else if (e.getActionCommand().equals(PainelLogin.SAIR)) {
            acessoBD.desconecta();
            this.dispose();
        } else if (e.getActionCommand().equals(PainelCadastroInicial.CONFIRMAR)) {
            user.setLogin(pnlCadastroInicial.getLogin());
            user.setSenha(pnlCadastroInicial.getSenha());
            user.setEmail(pnlCadastroInicial.getEmail());
            user.setTipo(pnlCadastroInicial.getTipo());
            if (user.getTipo().equals("USUARIO")) {
                pnlCadastroUsuario = new PainelCadastroUsuario(this, this, acessoBD);
                trocarPainel(pnlCadastroUsuario);
            } else if (user.getTipo().equals("EMPRESA")) {
                pnlCadastroEmpresa = new PainelCadastroEmpresa(this, this);
                trocarPainel(pnlCadastroEmpresa);
            } else if (user.getTipo().equals("BANDA")) {
                pnlCadastroBanda = new PainelCadastroBanda(this, this);
                trocarPainel(pnlCadastroBanda);
            }
        } else if (e.getActionCommand().equals(PainelCadastroUsuario.CONFIRMAUser)) {
            user.setNome(pnlCadastroUsuario.getNome());
            user.setEndereço(pnlCadastroUsuario.getEndereço());
            user.setTelefone(pnlCadastroUsuario.getTelefone());
            user.setDataNasc(pnlCadastroUsuario.getDataNasc());
            user.setTipo(pnlCadastroInicial.getTipo());
            user.setCidade(pnlCadastroUsuario.getCidade());
            user.setSexo(pnlCadastroUsuario.getSexo());
            if (acessoBD.tentarCadastroUser(user)) {
                pnlLogin.resetaLoginPass();
                trocarPainel(pnlLogin);
            }
        } else if (e.getActionCommand().equals(PainelCadastroUsuario.CANCELAUser)) {
            trocarPainel(pnlCadastroInicial);
        } else if (e.getActionCommand().equals(PainelCadastroEmpresa.CONFIRMAEmp)) {
            user.setNome(pnlCadastroEmpresa.getNome());
            user.setRazao(pnlCadastroEmpresa.getRazao());
            user.setTelefone(pnlCadastroEmpresa.getTelefone());
            user.setEndereço(pnlCadastroEmpresa.getLocalizacao());
            user.setDescricao(pnlCadastroEmpresa.getDescricao());
            user.setNome(pnlCadastroEmpresa.getNome());
            user.setTipoEmp(pnlCadastroEmpresa.getTipoEmp());
            user.setTipoLocal(pnlCadastroEmpresa.getTipoLocal());
            user.setHoraFun(pnlCadastroEmpresa.getHoraFun());
            if (acessoBD.tentarCadastroEmpresa(user)) {
                pnlLogin.resetaLoginPass();
                trocarPainel(pnlLogin);
            }
        } else if (e.getActionCommand().equals(PainelCadastroEmpresa.CANCELAEmp)) {
            trocarPainel(pnlCadastroInicial);
        } else if (e.getActionCommand().equals(PainelCadastroBanda.CONFIRMABanda)) {
            user.setNome(pnlCadastroBanda.getNome());
            user.setTelefone(pnlCadastroBanda.getTelefone());
            user.setEstilo(pnlCadastroBanda.getEstilo());
            user.setDescricao(pnlCadastroBanda.getDescrição());
            if (acessoBD.tentarCadastroBanda(user)) {
                pnlLogin.resetaLoginPass();
                trocarPainel(pnlLogin);
            }
        } else if (e.getActionCommand().equals(PainelCadastroBanda.CANCELABanda)) {
            trocarPainel(pnlCadastroInicial);
        } else if (e.getActionCommand().equals(PainelEvento.VoltaPainel)) {
            pnlControleUsuario = new PainelControleUsuario(user, this, this, acessoBD, opção, adição);
            trocarPainel(pnlControleUsuario);
        } else if (e.getActionCommand().equals(PainelEvento.AbrirBanda)) {
            String banda = evento.getBanda();

        } else if (e.getActionCommand().equals(PainelEvento.AbrirEmpresa)) {
            telaPerfilEmpresa = new TelaPerfilEmpresa(acessoBD.pegaDadosEmpresa(evento.getEmpresa()));
            telaPerfilEmpresa.setVisible(true);
        } else if (e.getActionCommand().equals(PainelBotãoTabelaEmpresa.CRIAEVT)) {
            telaCriarEvento = new TelaCriarEvento(acessoBD, listar, this);
            telaCriarEvento.setVisible(true);
        } else if (e.getActionCommand().equals(PainelBotãoTabelaEmpresa.DELETAEVT)) {
            cod = pnlControleEmpresa.pnlTabelaEmpresa.getCodEvento();
            if (cod != null) {
                telaConfirmaDelete = new TelaConfirmaDelete(this);
                telaConfirmaDelete.setVisible(true);
            }
        } else if (e.getActionCommand().equals(PainelBotãoTabelaEmpresa.EDITAEVT)) {
            cod = pnlControleEmpresa.pnlTabelaEmpresa.getCodEvento();
            System.out.println("" + cod);
            if (cod != null) {
                telaEditarEvento = new TelaEditarEvento(acessoBD.eventosEmpresaEditar(cod), listar, this, acessoBD);
                telaEditarEvento.setVisible(true);
            }
        } else if (e.getActionCommand().equals(PainelEditarEvento.CancEdi)) {
            telaEditarEvento.dispose();
        } else if (e.getActionCommand().equals(PainelEditarEvento.ConfEdi)) {
            if (acessoBD.updateEvento(telaEditarEvento.getEvento(), cod, user)) {
                telaEditarEvento.dispose();
                opção[0] = 0;
                opção[1] = 0;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaTodosAtivos(user));
                trocarPainel(pnlControleEmpresa);
            }
        } else if (e.getActionCommand().equals(PainelConfirmaDelete.CancRem)) {
            telaConfirmaDelete.dispose();
        } else if (e.getActionCommand().equals(PainelConfirmaDelete.ConfRem)) {
            if (acessoBD.deletarEvento(cod)) {
                JOptionPane.showMessageDialog(null, "Evento removido com sucesso", "Resposta do servidor", JOptionPane.INFORMATION_MESSAGE);
                telaConfirmaDelete.dispose();
                opção[0] = 0;
                opção[1] = 0;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaTodosAtivos(user));
                trocarPainel(pnlControleEmpresa);
            }
        } else if (e.getActionCommand().equals(PainelNovoEvento.CONFIR)) {
            Evento evento = null;
            evento = telaCriarEvento.getEvento();
            if (acessoBD.inserirEvento(evento, user)) {
                JOptionPane.showMessageDialog(null, "Evento inserido com sucesso", "Resposta do servidor", JOptionPane.INFORMATION_MESSAGE);
                telaCriarEvento.dispose();
                opção[0] = 0;
                opção[1] = 0;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaTodosAtivos(user));
                trocarPainel(pnlControleEmpresa);
            } else {
                JOptionPane.showMessageDialog(null, "Ops, ocorreu algum erro", "Resposta do servidor", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getActionCommand().equals(PainelNovoEvento.CANCEL)) {
            telaCriarEvento.dispose();
        } else if (e.getActionCommand().equals(PainelPerfilEmpresa.CancPerfEmp)) {
            telaPerfil.dispose();
        } else if (e.getActionCommand().equals(PainelPerfilEmpresa.ConfPerfEmp)) {
            user = telaPerfil.getUsuarioUpdate(user);
            if (acessoBD.updateDadosUser(user)) {
                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso", "Resposta do servidor", JOptionPane.INFORMATION_MESSAGE);
                telaPerfil.dispose();
                opção[0] = 0;
                opção[1] = 0;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção,
                        acessoBD.eventosEmpresaTodosAtivos(user));
                trocarPainel(pnlControleEmpresa);
            } else {
                JOptionPane.showMessageDialog(null, "Ops, ocorreu algum erro", "Resposta do servidor", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getActionCommand().equals(PainelBotãoTabelaBanda.ACEITA)) {
            cod = pnlControleBanda.pnlTabela.getCodEvento();
            System.out.println("" + cod);
            if (cod != null) {
                if (acessoBD.aceitarEventoBanda(cod)) {
                    opção[0] = 0;
                    opção[1] = 0;
                    pnlControleBanda = new PainelControleBanda(user, this, acessoBD, opção, acessoBD.eventosBandaTodos(user));
                    trocarPainel(pnlControleBanda);
                }
            }
        } else if (e.getActionCommand().equals(PainelBotãoTabelaBanda.RECUSA)) {
            cod = pnlControleBanda.pnlTabela.getCodEvento();
            System.out.println("" + cod);
            if (cod != null) {
                if (acessoBD.recusarEventoBanda(cod)) {
                    opção[0] = 0;
                    opção[1] = 0;
                    pnlControleBanda = new PainelControleBanda(user, this, acessoBD, opção, acessoBD.eventosBandaTodos(user));
                    trocarPainel(pnlControleBanda);
                }
            }
        } else if (e.getActionCommand().equals(PainelCabeçaBanda.VaiBanda)) {
            if (pnlControleBanda.pnlCabeçaBanda.getCidade().equals("TODOS")
                    && pnlControleBanda.pnlCabeçaBanda.getOpçãoSel() == 0) {
                opção[0] = 0;
                opção[1] = 0;
                pnlControleBanda = new PainelControleBanda(user, this, acessoBD, opção, acessoBD.eventosBandaTodos(user));
                trocarPainel(pnlControleBanda);
            } else if (pnlControleBanda.pnlCabeçaBanda.getOpçãoSel() == 0) {
                opção[0] = pnlControleBanda.pnlCabeçaBanda.getCidadeSel();
                opção[1] = 0;
                pnlControleBanda = new PainelControleBanda(user, this, acessoBD, opção,
                        acessoBD.eventosBandaCidade(user, pnlControleBanda.pnlCabeçaBanda.getCidade()));
                trocarPainel(pnlControleBanda);
            } else if (pnlControleBanda.pnlCabeçaBanda.getOpção().equals("Sair")) {
                acessoBD.desconecta();
                this.dispose();
            }
        } else if (e.getActionCommand().equals(PainelCabeçaEmpresa.OKemp)) {
            if (pnlControleEmpresa.pnlCabeçaEmpresa.getCidade().equals("TODOS")
                    && pnlControleEmpresa.pnlCabeçaEmpresa.getOpçãoSel() == 0) {
                opção[0] = 0;
                opção[1] = 0;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaTodosAtivos(user));
                trocarPainel(pnlControleEmpresa);
            } else if (pnlControleEmpresa.pnlCabeçaEmpresa.getCidade().equals("TODOS")
                    && pnlControleEmpresa.pnlCabeçaEmpresa.getOpçãoSel() == 1) {
                opção[0] = 0;
                opção[1] = 1;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaTodosPendentes(user));
                trocarPainel(pnlControleEmpresa);
            } else if (pnlControleEmpresa.pnlCabeçaEmpresa.getOpçãoSel() == 0) {
                opção[0] = pnlControleEmpresa.pnlCabeçaEmpresa.getCidadeSel();
                opção[1] = 0;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaCidadeAtivos(user, pnlControleEmpresa.pnlCabeçaEmpresa.getCidade()));
                trocarPainel(pnlControleEmpresa);
            } else if (pnlControleEmpresa.pnlCabeçaEmpresa.getOpçãoSel() == 1) {
                opção[0] = pnlControleEmpresa.pnlCabeçaEmpresa.getCidadeSel();
                opção[1] = 1;
                pnlControleEmpresa = new PainelControleEmpresa(user, this, acessoBD, opção, acessoBD.eventosEmpresaCidadePendente(user, pnlControleEmpresa.pnlCabeçaEmpresa.getCidade()));
                trocarPainel(pnlControleEmpresa);
            } else if (pnlControleEmpresa.pnlCabeçaEmpresa.getOpção().equals("Perfil Empresa")) {
                telaPerfil = new TelaPerfil(this, user);
                telaPerfil.setVisible(true);
            } else if (pnlControleEmpresa.pnlCabeçaEmpresa.getOpção().equals("Sair")) {
                acessoBD.desconecta();
                this.dispose();
            }
        }
    }
}
