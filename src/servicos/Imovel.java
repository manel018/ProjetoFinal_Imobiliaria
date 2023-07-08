package servicos;

import javafx.scene.image.Image;

/**
 * Classe abstrata responsável por definir uma entidade padrão (imóvel) para que seja herdado pela classe casa ou apartamento
 * 
 * @author Lucas Henrique
 */
public abstract class Imovel {
  
    private int numeroDoAnuncio;
    private String fonteImagem;
    private String cidade;
    private String estado;
    private String descricao;
    private Double valor;
    private Integer vagasGaragem;
    private double area;
    
    /**
     * Construtor da classe
     */
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
    
    /* Getters e setters */
    public int getNumeroDoAnuncio() {
        return numeroDoAnuncio;
    }

    public String getfonteImagem() {
        return fonteImagem;
    }

    public void setfonteImagem(String fonteImagem) {
        this.fonteImagem = fonteImagem;
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

    public Double getValor() {
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

    /**
     * Converte uma {@code String} com o caminho de uma imagem para 
     * o objeto do tipo {@code Image}.
     * 
     * @param fonteImagem Caminho relativo de um arquivo imagem
     * @return Instância de {@code Image} associada ao argumento.
     * 
     * @author Emanuel Victor
     * @author Lucas Souza
     * @author Caio Lopes
     * @author Gabriel Araujo
     */
    private Image instanciarImagem(String fonteImagem){
        Image imagem = new Image(getClass().getResourceAsStream(fonteImagem));
        return imagem;
    }

    /**
     * Indica se algum outro imóvel é igual a este.
     * <p>Para isto, compara os atributos {@code cidade} e {@code estado}, além de 
     * verificar se ambos são instâncias das subclasses {@code Casa} ou {@code Apartamento}
     * 
     * @param imovelComparado objeto {@code Imovel} que se deseja comparar
     * @return {@code true} se respectivos atributos do imóvel coincide com os do Imóvel do argumento; {@code false} caso contrário. 
     
    public boolean igualA(Imovel imovelComparado){
        if(imovelComparado.getCidade().equalsIgnoreCase(cidade) && imovelComparado.getEstado().equalsIgnoreCase(estado))
            return true;
        else
            return false;
        }*/
}
