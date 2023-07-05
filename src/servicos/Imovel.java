package servicos;

/**
 * Classe abstrata responsável por definir uma entidade padrão (imóvel) para que seja herdado pela classe casa ou apartamento
 * @author lucas
 */
public abstract class Imovel {
  
    private int numeroDoAnuncio;
    private String descricao;
    private double valor;
    private String cidade;
    private String estado;
    private int vagasGaragem;
    private double area;

    public Imovel(int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area) {
        this.numeroDoAnuncio = numeroDoAnuncio;
        this.descricao = descricao;
        this.valor = valor;
        this.cidade = cidade;
        this.estado = estado;
        this.vagasGaragem = vagasGaragem;
        this.area = area;
    }

    /**
     * Método abstrato para o cadastro de um imóvel no sistema
     * @return
     */
    abstract public boolean cadastraImovel();
    
/*Getters e setters */
    public int getNumeroDoAnuncio() {
        return numeroDoAnuncio;
    }

    public void setNumeroDoAnuncio(int numeroDoAnuncio) {
        this.numeroDoAnuncio = numeroDoAnuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
/*Getters e setters */
    
}
