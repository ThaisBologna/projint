package projinter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcessoBD {

    private Connection con;
    private Statement stm;

    public AcessoBD() {
        con = null;
        stm = null;
    }

    public void conecta() {
        String url = "jdbc:postgresql://localhost:5432/ProjetoBalada";
        String usuario = "postgres";
        String senha = "Time2log";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            stm = con.createStatement();
            System.out.println("Link da balada: Conexão bem sucedida!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Excessão: " + e.toString());
        }
    }

    public void desconecta() {
        try {
            stm.close();
            con.close();
            System.out.println("Link da balada: Conexão Desligada!!");
        } catch (SQLException e) {
            System.err.println("Excessão: " + e.toString());
        }
    }

    public Usuario getUser(Usuario user) {
        try {
            ResultSet rs = rs = stm.executeQuery("select * from login WHERE login.login = '" + user.getLogin() + "'");
            rs.next();
            int idLista = rs.getInt("id");
            user.setId(idLista);
            user.setTipo(rs.getString("tipo"));
            if (user.getTipo().equals("USUARIO")) {
                rs = rs = stm.executeQuery("select * from usuario WHERE usuario.id = '" + idLista + "'");
                rs.next();
                user.setNome(rs.getString("nome_usuario"));
                user.setDataNasc(rs.getString("datanasc"));
                user.setCidade(rs.getString("cidade"));
                user.setSexo(rs.getString("sexo"));
                user.setTelefone(rs.getString("telefone"));
            }
            if (user.getTipo().equals("EMPRESA")) {
                rs = rs = stm.executeQuery("select * from empresa WHERE empresa.id = '" + idLista + "'");
                rs.next();
                user.setId(rs.getInt("id_empresa"));
                user.setNome(rs.getString("nome_empresa"));
                user.setRazao(rs.getString("razao"));
                user.setDescricao(rs.getString("descricao"));
                user.setTelefone(rs.getString("telefone"));
                user.setEndereço(rs.getString("localizacao"));
                user.setHoraFun(rs.getString("horafunc"));
                user.setTipoEmp(rs.getString("tipoemp"));
                user.setTipoLocal(rs.getString("tipolocal"));
            }
            if (user.getTipo().equals("BANDA")) {
                rs = rs = stm.executeQuery("select * from banda WHERE banda.id = '" + idLista + "'");
                rs.next();
                user.setId(rs.getInt("id_banda"));
                user.setNome(rs.getString("nome_banda"));
                user.setDescricao(rs.getString("descricao"));
                user.setTelefone(rs.getString("telefone"));
                user.setEndereço(rs.getString("estilo"));
            }
        } catch (Exception e) {
            System.err.println("Excessão: " + e.toString());
        }
        return user;
    }

    public String pegaData(int adição) {
        String data = null;

        try {
            ResultSet rs = stm.executeQuery("select current_date+"
                    + adição);
            rs.next();
            data = rs.getString("?column?");
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public String pegaBanda(int cod) {
        String nomeBanda = null;
        try {
            ResultSet rs = stm.executeQuery("SELECT nome_banda FROM banda WHERE id_banda = " + cod);
            rs.next();
            nomeBanda = rs.getString("nome_banda");
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("" + nomeBanda);
        return nomeBanda;
    }

    public String pegaEmpresa(int cod) {
        String nomeEmpresa = null;
        try {
            ResultSet rs = stm.executeQuery("SELECT nome_empresa FROM empresa WHERE id_empresa = " + cod);
            rs.next();
            nomeEmpresa = rs.getString("nome_empresa");
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomeEmpresa;
    }

    public String[] listaCidades() {
        String[] listaFinal = null;
        int i = 0;
        int tamanho = 0;
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT cidade FROM cidades");
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            String[] lista = new String[tamanho];
            while (rs.next()) {
                lista[i] = rs.getString("Cidade");
                i = i + 1;
            }
            listaFinal = lista;
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFinal;
    }

    public String[] listaCidadesMenu() {
        String[] listaFinal = null;
        int i = 0;
        int tamanho = 0;
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT cidade FROM cidades");
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            String[] lista = new String[tamanho + 1];
            lista[0] = "TODOS";
            while (rs.next()) {
                lista[i + 1] = rs.getString("Cidade");
                i = i + 1;
            }
            listaFinal = lista;
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFinal;
    }

    public String[] listaBandas() {
        String[] listaFinal = null;
        int i = 0;
        int tamanho = 0;
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT nome_banda FROM banda");
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            String[] lista = new String[tamanho + 1];
            lista[0] = " ";
            while (rs.next()) {
                lista[i + 1] = rs.getString("nome_banda");
                i = i + 1;
            }
            listaFinal = lista;
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaFinal;
    }

    public int eventosUsuarioTamanho(int adição) {
        int tamanho;
        tamanho = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select *"
                    + " from evento"
                    + " where horario::date = current_date+"
                    + adição
                    + " and status = 'ativo'");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tamanho;
    }

    public Object[][] eventosUsuario(int adição) {
        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;
        System.out.println("" + adição);
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select *"
                    + " from evento"
                    + " where horario::date = current_date+"
                    + adição
                    + " and status = 'ativo'");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][11];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("nome_evento");
                    dados[i][1] = rs.getString("descricao");
                    dados[i][2] = rs.getString("id_empresa");
                    dados[i][3] = rs.getString("id_banda");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("regiao");
                    dados[i][6] = rs.getString("endereço");
                    dados[i][7] = rs.getString("cidade");
                    dados[i][8] = rs.getString("imagem");
                    dados[i][9] = rs.getString("status");
                    dados[i][10] = rs.getFloat("preco");
                    i = i + 1;
                }
                dadosFinal = dados;
            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;

    }

    public Object[][] pegaDadosBanda(String nome) {
        Object[][] dados = new Object[1][4];

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select *"
                    + " from banda"
                    + " where nome_banda = '" + nome + "'");
            rs.next();
            dados[0][0] = rs.getString("nome_banda");
            dados[0][1] = rs.getString("descricao");
            dados[0][2] = rs.getString("telefone");
            dados[0][3] = rs.getString("estilo");
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    public Object[][] pegaDadosEmpresa(String nome) {
        Object[][] dados = new Object[1][8];

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("select *"
                    + " from empresa"
                    + " where nome_empresa = '" + nome + "'");
            rs.next();
            dados[0][0] = rs.getString("nome_empresa");
            dados[0][1] = rs.getString("razao");
            dados[0][2] = rs.getString("descricao");
            dados[0][3] = rs.getString("telefone");
            dados[0][4] = rs.getString("localizacao");
            dados[0][5] = rs.getString("horafunc");
            dados[0][6] = rs.getString("tipoemp");
            dados[0][7] = rs.getString("tipolocal");
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    public Object[][] eventosEmpresaTodosAtivos(Usuario user) {

        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM evento WHERE id_empresa = "
                    + user.getId()
                    + "and status = 'ativo'");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][10];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("id_evento");
                    dados[i][1] = rs.getString("nome_evento");
                    dados[i][2] = rs.getString("id_banda");
                    dados[i][3] = rs.getString("cidade");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("descricao");
                    dados[i][6] = rs.getString("regiao");
                    dados[i][7] = rs.getFloat("preco");
                    dados[i][8] = rs.getString("status");
                    dados[i][9] = rs.getString("imagem");
                    i = i + 1;
                }
                dadosFinal = dados;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;
    }

    public Object[][] eventosEmpresaEditar(String cod) {
        int i = 0, tamanho = 11;
        Object[][] dados = new Object[1][tamanho];
        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM evento WHERE id_evento = " + cod);
            rs.next();
            dados[i][0] = rs.getString("id_evento");
            dados[i][1] = rs.getString("nome_evento");
            dados[i][2] = rs.getString("id_banda");
            dados[i][3] = rs.getString("cidade");
            dados[i][4] = rs.getString("horario");
            dados[i][5] = rs.getString("descricao");
            dados[i][6] = rs.getString("regiao");
            dados[i][7] = rs.getFloat("preco");
            dados[i][8] = rs.getString("status");
            dados[i][9] = rs.getString("imagem");
            dados[i][10] = rs.getString("endereço");

        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return dados;
    }

    public Object[][] eventosEmpresaCidadeAtivos(Usuario user, String cidade) {

        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM evento WHERE id_empresa = "
                    + user.getId()
                    + "and status = 'ativo'"
                    + "and cidade = '"
                    + cidade
                    + "'");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][10];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("id_evento");
                    dados[i][1] = rs.getString("nome_evento");
                    dados[i][2] = rs.getString("id_banda");
                    dados[i][3] = rs.getString("cidade");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("descricao");
                    dados[i][6] = rs.getString("regiao");
                    dados[i][7] = rs.getFloat("preco");
                    dados[i][8] = rs.getString("status");
                    dados[i][9] = rs.getString("imagem");
                    i = i + 1;
                }
                dadosFinal = dados;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;
    }

    public Object[][] eventosEmpresaCidadePendente(Usuario user, String cidade) {

        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM evento WHERE id_empresa = "
                    + user.getId()
                    + "and status = 'pendente'"
                    + "and cidade = '"
                    + cidade
                    + "'");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][10];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("id_evento");
                    dados[i][1] = rs.getString("nome_evento");
                    dados[i][2] = rs.getString("id_banda");
                    dados[i][3] = rs.getString("cidade");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("descricao");
                    dados[i][6] = rs.getString("regiao");
                    dados[i][7] = rs.getFloat("preco");
                    dados[i][8] = rs.getString("status");
                    dados[i][9] = rs.getString("imagem");
                    i = i + 1;
                }
                dadosFinal = dados;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;
    }

    public Object[][] eventosEmpresaTodosPendentes(Usuario user) {

        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM evento WHERE id_empresa = "
                    + user.getId()
                    + "and status = 'pendente' or status = 'recusado'");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][10];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("id_evento");
                    dados[i][1] = rs.getString("nome_evento");
                    dados[i][2] = rs.getString("id_banda");
                    dados[i][3] = rs.getString("cidade");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("descricao");
                    dados[i][6] = rs.getString("regiao");
                    dados[i][7] = rs.getFloat("preco");
                    dados[i][8] = rs.getString("status");
                    dados[i][9] = rs.getString("imagem");
                    i = i + 1;
                }
                dadosFinal = dados;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;
    }

    public Object[][] eventosBandaCidade(Usuario user, String cidade) {

        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT *,empresa.nome_empresa"
                    + " FROM evento,empresa"
                    + " WHERE id_banda = "
                    + user.getId()
                    + " and cidade = '"
                    + cidade
                    + "' and evento.id_empresa=empresa.id_empresa");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][10];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("id_evento");
                    dados[i][1] = rs.getString("nome_evento");
                    dados[i][2] = rs.getString("nome_empresa");
                    dados[i][3] = rs.getString("cidade");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("descricao");
                    dados[i][6] = rs.getString("regiao");
                    dados[i][7] = rs.getFloat("preco");
                    dados[i][8] = rs.getString("status");
                    dados[i][9] = rs.getString("imagem");
                    i = i + 1;
                }
                dadosFinal = dados;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;
    }

    public Object[][] eventosBandaTodos(Usuario user) {

        Object[][] dadosFinal = null;
        int tamanho, i;
        tamanho = 0;
        i = 0;

        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT *,empresa.nome_empresa"
                    + " FROM evento,empresa "
                    + " WHERE id_banda = "
                    + user.getId()
                    + " and evento.id_empresa=empresa.id_empresa");
            rs.beforeFirst();
            while (rs.next()) {
                tamanho = tamanho + 1;
            }
            rs.beforeFirst();
            Object[][] dados = new Object[tamanho][10];
            try {
                while (rs.next()) {
                    dados[i][0] = rs.getString("id_evento");
                    dados[i][1] = rs.getString("nome_evento");
                    dados[i][2] = rs.getString("nome_empresa");
                    dados[i][3] = rs.getString("cidade");
                    dados[i][4] = rs.getString("horario");
                    dados[i][5] = rs.getString("descricao");
                    dados[i][6] = rs.getString("regiao");
                    dados[i][7] = rs.getFloat("preco");
                    dados[i][8] = rs.getString("status");
                    dados[i][9] = rs.getString("imagem");
                    i = i + 1;
                }
                dadosFinal = dados;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosFinal;
    }

    public boolean updateDadosUser(Usuario user) {
        boolean sucesso = false;
        if (user.getTipo().equals("EMPRESA")) {
            try {
                stm.executeUpdate("UPDATE empresa SET "
                        + "nome_empresa = '" + user.getNome() + "',"
                        + "razao = '" + user.getRazao() + "',"
                        + "descricao = '" + user.getDescricao() + "',"
                        + "telefone = '" + user.getTelefone() + "',"
                        + "localizacao = '" + user.getEndereço() + "',"
                        + "horafunc = '" + user.getHoraFun() + "',"
                        + "tipoemp = '" + user.getTipoEmp() + "',"
                        + "tipolocal = '" + user.getTipoLocal() + "'"
                        + "where id_empresa = '"
                        + user.getId() + "'");
                sucesso = true;

            } catch (SQLException ex) {
                Logger.getLogger(AcessoBD.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sucesso;
    }

    public boolean updateEvento(Evento evento, String cod, Usuario user) {
        boolean sucesso = false;
        int codi = Integer.parseInt(cod);
        try {
            stm.executeUpdate("UPDATE evento SET"
                    + " id_empresa = " + user.getId()
                    + ", id_banda = (select id_banda from banda where nome_banda = '" + evento.getBanda() + "')"
                    + ", nome_evento = '" + evento.getNome() + "'"
                    + ", cidade = '" + evento.getCidade() + "'"
                    + ", horario = '" + evento.getHorario() + "'"
                    + ", descricao = '" + evento.getDescricao() + "'"
                    + ", regiao = '" + evento.getLocal() + "'"
                    + ", endereço = '" + evento.getEndereco() + "'"
                    + ", preco = " + evento.getPreço()
                    + ", status = '" + evento.getStatus() + "'"
                    + ", imagem = '" + evento.getNumImagem() + "'"
                    + " where id_evento = " + codi);
            sucesso = true;
        } catch (SQLException ex) {
            sucesso = false;
            Logger
                    .getLogger(AcessoBD.class
                            .getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean inserirEvento(Evento evento, Usuario user) {
        boolean sucesso = false;
        try {
            stm.executeUpdate("INSERT INTO evento(id_empresa,id_banda,nome_evento,cidade,horario,descricao,regiao,endereço,preco,status,imagem) "
                    + "values('"
                    + user.getId()
                    + "',(select id_banda from banda where nome_banda = '"
                    + evento.getBanda() + "'),'"
                    + evento.getNome() + "','"
                    + evento.getCidade() + "','"
                    + evento.getHorario() + "','"
                    + evento.getDescricao() + "','"
                    + evento.getLocal() + "','"
                    + evento.getEndereco() + "','"
                    + evento.getPreço() + "','"
                    + evento.getStatus() + "','"
                    + evento.getNumImagem() + "')");
            sucesso = true;
        } catch (SQLException e4) {
            System.err.println("Excessão: " + e4.toString());
        }
        return sucesso;
    }

    public boolean deletarEvento(String codEvento) {
        boolean sucesso = false;
        try {
            stm.executeUpdate("delete from evento where id_evento = "
                    + codEvento);
            sucesso = true;

        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean aceitarEventoBanda(String cod) {
        boolean sucesso = false;

        try {
            stm.executeUpdate("UPDATE evento SET status = 'ativo' where id_evento = '"
                    + cod + "'");
            sucesso = true;

        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean recusarEventoBanda(String cod) {
        boolean sucesso = false;

        try {
            stm.executeUpdate("UPDATE evento SET status = 'recusado' where id_evento = '"
                    + cod + "'");
            sucesso = true;

        } catch (SQLException ex) {
            Logger.getLogger(AcessoBD.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return sucesso;
    }

    public boolean tentarCadastroEmpresa(Usuario user) {
        boolean resultadoCadEmp = false, resultadoParcial = false;

        try {
            stm.executeUpdate("INSERT INTO login(login,senha,email,tipo) "
                    + "values('" + user.getLogin() + "','" + user.getSenha() + "','" + user.getEmail() + "','" + user.getTipo() + "')");
            resultadoParcial = true;
        } catch (SQLException e4) {
            System.err.println("Excessão: " + e4.toString());
        }
        if (resultadoParcial) {
            try {
                ResultSet rs = stm.executeQuery("SELECT * FROM login WHERE login.login = '" + user.getLogin() + "'");
                rs.next();
                String idLista = rs.getString("id");
                stm.executeUpdate("INSERT INTO empresa(id,nome_empresa,razao,descricao,telefone,localizacao,horafunc,tipoemp,tipolocal) "
                        + "values('" + idLista + "','" + user.getNome() + "','" + user.getRazao() + "','" + user.getDescricao() + "','" + user.getTelefone() + "','" + user.getEndereço() + "','" + user.getHoraFun() + "','" + user.getTipoEmp() + "','" + user.getTipoLocal() + "')");
                resultadoCadEmp = true;
            } catch (SQLException e5) {
                System.err.println("Excessão: asds " + e5.toString());
            }
        }
        return resultadoCadEmp;
    }

    public boolean tentarCadastroUser(Usuario user) {
        boolean resultadoCadUser = false, resultadoParcial = false;
        try {
            stm.executeUpdate("INSERT INTO login(login,senha,email,tipo) "
                    + "values('" + user.getLogin() + "','"
                    + user.getSenha() + "','"
                    + user.getEmail() + "','"
                    + user.getTipo() + "')");
            resultadoParcial = true;
        } catch (SQLException e2) {
            System.err.println("Excessão: " + e2.toString());
        }
        if (resultadoParcial) {
            try {
                ResultSet rs = stm.executeQuery("SELECT * FROM login WHERE login.login = '" + user.getLogin() + "'");
                rs.next();
                String idLista = rs.getString("id");
                stm.executeUpdate("INSERT INTO usuario(id,nome_usuario,dataNasc,cidade,sexo,telefone) "
                        + "values('"
                        + idLista + "','"
                        + user.getNome() + "','"
                        + user.getDataNasc() + "','"
                        + user.getCidade() + "','"
                        + user.getSexo() + "','"
                        + user.getTelefone() + "')");
                resultadoCadUser = true;
            } catch (SQLException e3) {
                System.err.println("Excessão: " + e3.toString());
            }
        }
        return resultadoCadUser;
    }

    public boolean tentarCadastroBanda(Usuario user) {
        boolean resultadoCadBanda = false, resultadoParcial = false;

        try {
            stm.executeUpdate("INSERT INTO login(login,senha,email,tipo) "
                    + "values('"
                    + user.getLogin() + "','"
                    + user.getSenha() + "','"
                    + user.getEmail() + "','"
                    + user.getTipo() + "')");
            resultadoParcial = true;
        } catch (SQLException e4) {
            System.err.println("Excessão: " + e4.toString());
        }
        if (resultadoParcial) {
            try {
                ResultSet rs = stm.executeQuery("SELECT * FROM login WHERE login.login = '"
                        + user.getLogin() + "'");
                rs.next();
                String idLista = rs.getString("id");
                stm.executeUpdate("INSERT INTO banda(id,nome_banda,descricao,telefone,estilo) "
                        + "values('"
                        + idLista + "','"
                        + user.getNome() + "','"
                        + user.getDescricao() + "','"
                        + user.getTelefone() + "','"
                        + user.getEstilo() + "')");
                resultadoCadBanda = true;
            } catch (SQLException e5) {
                System.err.println("Excessão: asds " + e5.toString());
            }
        }
        return resultadoCadBanda;
    }

    public boolean tentarLogin(Usuario user) {
        ResultSet rs = null;
        boolean resultadoLogin = false;

        try {
            rs = stm.executeQuery("SELECT * FROM login");
            String senhaLista, loginLista;
            while (rs.next()) {
                loginLista = rs.getString("login");
                senhaLista = rs.getString("senha");
                if (loginLista.equals(user.getLogin()) && senhaLista.equals(user.getSenha())) {
                    System.out.println("Login Status: " + loginLista + " encontrado e senha correta");
                    resultadoLogin = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Excessão: " + e.toString());
        }
        return resultadoLogin;
    }

}
