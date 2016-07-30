package projinter;

public class Evento {

    private String nome;
    private String descricao;
    private String empresa;    
    private String banda;
    private String horario;
    private String local;
    private String endereco;
    private String cidade;
    private String numImagem;
    private String status;
    private float preço;

    public Evento(String nome, String descricao, String banda, String horario, String local, String endereco, String cidade, String numImagem, String status, float preço) {
        this.nome = nome;
        this.descricao = descricao;
        this.banda = banda;
        this.horario = horario;
        this.local = local;
        this.endereco = endereco;
        this.cidade = cidade;
        this.numImagem = numImagem;
        this.status = status;
        this.preço = preço;
    }

    public Evento(String nome, String descricao, String empresa, String banda, String horario, String local, String endereco, String cidade, String numImagem, String status, float preço) {
        this.nome = nome;
        this.descricao = descricao;
        this.empresa = empresa;
        this.banda = banda;
        this.horario = horario;
        this.local = local;
        this.endereco = endereco;
        this.cidade = cidade;
        this.numImagem = numImagem;
        this.status = status;
        this.preço = preço;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public float getPreço() {
        return preço;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNumImagem() {
        return numImagem;
    }

    public void setNumImagem(String numImagem) {
        this.numImagem = numImagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
