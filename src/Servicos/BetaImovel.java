
package Servicos;

import javafx.scene.image.Image;

/**
 * Classe teste que representa um imóvel
 *
 * @author emanuel
 */
public class BetaImovel {
    /* 
     * Variáveis da classe
     */
    private String fonteImagem;
    private String tipo;
    private String local;
    private Double preco;
    private Integer dormitorios;
    private Double area;

    /* 
     * Métodos da classe
     */
    // Getters
    public String getfonteImagem() {
        return fonteImagem;
    }
    public String getTipo() {
        return tipo;
    }
    public String getLocal() {
        return local;
    }
    public Double getPreco() {
        return preco;
    }
    public Integer getDormitorios() {
        return dormitorios;
    }
    public Double getArea() {
        return area;
    }
    // Setters
    public void setfonteImagem(String fonteImagem) {
        this.fonteImagem = fonteImagem;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public void setDormitorios(Integer dormitorios) {
        this.dormitorios = dormitorios;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    //Construtor
    public BetaImovel(String fonteImagem, String tipo, String local, Double preco, Integer dormitorios, Double area) {
        this.fonteImagem = fonteImagem;
        this.tipo = tipo;
        this.local = local;
        this.preco = preco;
        this.dormitorios = dormitorios;
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


    
    
}
