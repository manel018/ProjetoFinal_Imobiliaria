
package Controllers;

import Servicos.BetaImovel;
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
    public void setDadosImovel(BetaImovel imovel){    //NAO ESQUECER DE TROCAR PARA O TIPO CORRETO CRIADO PELO LUCAS
        
        //IMPLEMENTAR MÉTODO get() DE CADA DADO DO TIPO IMOVEL

        /* 
         * Cria uma instância de Image por meio da String do objeto imovel
         * que contém o caminho relativo do arquivo imagem no sistema
         */
        Image imagem = new Image(getClass().getResourceAsStream(imovel.getfonteImagem()));

        /* 
         * Atribui cada propriedade aos elementos na janela
         */
        img_ImovelImagem.setImage(imagem);
        lb_ImovelTipo.setText(imovel.getTipo());
        lb_imovelLocal.setText(imovel.getLocal());
        lb_imovelPreco.setText(imovel.getPreco().toString());
        lb_imovelDormitorio.setText(imovel.getDormitorios().toString());
        lb_imovelArea.setText(imovel.getArea().toString());
    }
}
