
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import servicos.Imovel;
import servicos.JotaImoveisGerencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Esta classe é responsável por administrar os componentes da janela <b>LayoutPrincipal.fxml</b>. <p>Nesta classe
 * estão todos os métodos de tratamento dos eventos que são gerados pela interação do usuário com os
 * componentes da janela.
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public class LayoutResultadosController extends ControllerMaster {
    //Aqui vai o gerenciador de imóveis...

    @FXML
    private GridPane imovelContainer;
    private ArrayList<Imovel> listaImoveis;
    private int coluna;
    private int linha;
    private int index;
    private Random gerador = new Random();

    @FXML
    private ToggleButton bt_numD1;

    @FXML
    private ToggleButton bt_numD2;

    @FXML
    private ToggleButton bt_numD3;

    @FXML
    private ToggleButton bt_numD4;

    @FXML
    private ToggleButton bt_numD5;

    @FXML
    private ToggleButton bt_numG1;

    @FXML
    private ToggleButton bt_numG2;

    @FXML
    private ToggleButton bt_numG3;

    @FXML
    private ToggleButton bt_numG4;

    @FXML
    private ToggleButton bt_numG5;

    @FXML
    private Label lb_nome;

    private Card_ImovelController cardController;

    private ArrayList<VBox> cardBoxes; 

    private ToggleGroup grupoBotoesD;
    private ToggleGroup grupoBotoesG;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Atribui a lista de imóveis filtrados vindos da janela anterior à variável listaImoveis
        JotaImoveisGerencia gerenciador = (JotaImoveisGerencia)dados.get(1);
        //Atribui a lista de imóveis filtrados vindos da janela anterior à variável listaImoveis
        listaImoveis = gerenciador.getImoveisSelecionados();

        inicializaBotoes();
        
        coluna = 0;     //Valor inicial do número de colunas
        linha = 1;      //e linhas para dispor os cards no GridPane
        index = 0;
        cardBoxes = new ArrayList<VBox>();

        try {

            for(Imovel imovel : listaImoveis){
                cardController = new Card_ImovelController();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/GUI/fxml/Card_Imovel.fxml"));
                cardBoxes.add(loader.load());
                
                cardController = loader.getController();  //Intancia um controller do card

                cardController.setDadosImovel(imovel);      //Passa os atributos do Imovel atual para os componentes fx do controller

                if(coluna == 4){    //Salta de linha ao atingir o limite de cards
                    coluna = 0;
                    linha++;
                }
                imovelContainer.add(cardBoxes.get(index),coluna++,linha);    //(objeto CardImovel, IndexColuna, IndexLinha)

                GridPane.setMargin(cardBoxes.get(index), new Insets(10));    //(objeto CardImovel, Distância entre compontes)
                index++;       
            }       
                     
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
            alert.setTitle("Erro");                       //possível carregar o arquivo
            alert.setHeaderText(null);  
            alert.setContentText("Tivemos problemas ao carregar as informações...");
            alert.showAndWait();
            e.printStackTrace();
        } 
        String nome = (String) dados.get(0);    //Atribui o nome fornecido ao label nome
        lb_nome.setText(nome);
    }

    //Testando a funcionalidade da filtragem de imóveis (Apagar e colocar novos imóveis condizentes com os critérios)
    @FXML
    void clickbtNum(ActionEvent event) {
        String idBotao = ((RadioButton)grupoBotoesG.getSelectedToggle()).getText().substring(7); //Pega a 7º posição da string id
        Integer numDormitorios = Integer.parseInt(idBotao);
    
        //Criar método  "public ArrayList<VBox> instanciaCards(int numDorm, int numGarg)" para adicionar os cards filtrados ao conteiner da tela
        

        /* 
        if(event.getSource() == bt_numG1)
            imovelContainer.getChildren().clear();
        if(event.getSource() == bt_numG2){
            imovelContainer.add(cardBoxes.get(2),1,1);
        }*/
    }

    /**
     * Aplica os grupos de botões dentro de um ToggleGroup
     */
    private void inicializaBotoes(){
        //Botões nº Dormitório
        grupoBotoesD = new ToggleGroup();
        bt_numG1.setToggleGroup(grupoBotoesD);
        bt_numG2.setToggleGroup(grupoBotoesD);
        bt_numG3.setToggleGroup(grupoBotoesD);
        bt_numG4.setToggleGroup(grupoBotoesD);
        bt_numG5.setToggleGroup(grupoBotoesD);

        //Botões nº Garagem
        grupoBotoesG = new ToggleGroup();
        bt_numG1.setToggleGroup(grupoBotoesG);
        bt_numG2.setToggleGroup(grupoBotoesG);
        bt_numG3.setToggleGroup(grupoBotoesG);
        bt_numG4.setToggleGroup(grupoBotoesG);
        bt_numG5.setToggleGroup(grupoBotoesG);
    }
}
