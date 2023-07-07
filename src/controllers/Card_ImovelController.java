
package controllers;

import servicos.Casa;
import servicos.Imovel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Esta classe gerencia as informações apresentadas dentro de cada card de
 * um imóvel, tais como {@code ImageView} e {@code Label} de preço 
 * e outros atributos
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class Card_ImovelController {
    // Atributos da classe
    @FXML
    private ImageView img_ImovelImagem;
    @FXML
    private Label lb_ImovelTipo;
    @FXML
    private Label lb_imovelArea;
    @FXML
    private Label lb_imovelDormitorio;
    @FXML
    private Label lb_imovelGaragens;
    @FXML
    private Label lb_imovelLocal;
    @FXML
    private Label lb_imovelPreco;


    /**
     * Passa os dados de um imóvel salvo no programa para
     * os elementos da interface gráfica
     * 
     * @param imovel Imóvel que será apresentado na cena
     * 
     * @author Emanuel Victor
     * @author Lucas Souza
     * @author Caio Lopes
     * @author Gabriel Araujo
     */
    public void setDadosImovel(Imovel imovel){
        /* 
         * Cria uma instância de Image por meio da String do objeto imovel
         * que contém o caminho relativo do arquivo imagem no sistema
         */
        Image imagem = new Image(getClass().getResourceAsStream(imovel.getfonteImagem()));

        /* 
         * Atribui cada atributo do imóvel aos elementos na janela
         */
        //Imagem
        img_ImovelImagem.setImage(imagem);
        if (imovel instanceof Casa)
            lb_ImovelTipo.setText("Casa");
        else{
            lb_ImovelTipo.setText("Apartamento");
        }
        //Local
        lb_imovelLocal.setText("" + imovel.getCidade()+ "/" + imovel.getCidade());
        //Valor
        if(imovel instanceof Casa){
            lb_imovelPreco.setText("" + imovel.getValor());
        }
        else{
            lb_imovelPreco.setText("" + (imovel.getValor()*0.01));
        }
        //Área
        lb_imovelArea.setText("" + imovel.getArea());
    }
}
