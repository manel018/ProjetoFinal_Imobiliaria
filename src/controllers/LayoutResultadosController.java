
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
import javafx.scene.control.TextField;
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

    private ArrayList<Imovel> listaImoveis;
    private int coluna;
    private int linha;
    private int index;

    @FXML
    private GridPane imovelContainer;

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
    private Button bt_Pesquisar;
    
    @FXML
    private Button bt_Voltar;
    
    @FXML
    private Label lb_Nome;
    
    @FXML
    private Label lb_Caminho;

    @FXML
    private TextField txtAreaMaxima;

    @FXML
    private TextField txtAreaMinima;

    @FXML
    private TextField txtPrecoMaximo;

    @FXML
    private TextField txtPrecoMinimo;

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

        //Carrega na janela os cards de cada imovel selecionado 

        cardBoxes = new ArrayList<VBox>();

        try {
            //Carrega uma mini janela do tipo Card_Controller para cada imovel da lista 
            for(Imovel imovel : listaImoveis){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/GUI/fxml/Card_Imovel.fxml"));

                                                //Preenche a lista cardBoxes, por meio do carregamento
                cardBoxes.add(loader.load());   //de uma hierarquia de todos os objetos fxml do arquivo
                
                //Passa os atributos de cada imovel para as componentes fx do controller do Card
                ((Card_ImovelController)loader.getController()).setDadosImovel(imovel);                   
            }       
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
            alert.setTitle("Erro");                       //possível carregar o arquivo
            alert.setHeaderText(null);  
            alert.setContentText("Tivemos problemas ao carregar as informações...");
            alert.showAndWait();
            e.printStackTrace();
        } 
        //Inicialmente, adiciona todos os imóveis (sem critérios) na janela de resultados
        adicionaImoveisPorIndice(filtraImoveis(0, 0, 0, 0,0));


        inicializaBotoes();
        String nome = (String) dados.get(0);    //Atribui o nome fornecido ao label nome
        lb_Nome.setText(nome);
    }

    //Testando a funcionalidade da filtragem de imóveis (Apagar e colocar novos imóveis condizentes com os critérios)
    @FXML
    void clickbtNum(ActionEvent event) {
        //Pega a 7º posição da string do id do botão e converte para inteiro
        int idBotao = Integer.parseInt(((RadioButton)grupoBotoesG.getSelectedToggle()).getText().substring(7)); 
        
        
    
        //Criar método  "public ArrayList<VBox> instanciaCards(int numDorm, int numGarg)" para adicionar os cards filtrados ao conteiner da tela
        

        /* 
        if(event.getSource() == bt_numG1)
            imovelContainer.getChildren().clear();
        if(event.getSource() == bt_numG2){
            imovelContainer.add(cardBoxes.get(2),1,1);
        }*/
    }
    
    @FXML
    void clickBtPesquisar(ActionEvent event) {

    }

    @FXML
    void clickBtVoltar(ActionEvent event) {

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

    /**
     * Aplica na janela um painel com os cards referentes a cada imóvel da lista
     * {@code listaImoveis} (dos imóveis selecionados). Os imóveis a serem
     * adicionados são aqueles cujo índice na lista corresponde aos índices
     * passados como argumento.
     * 
     * @param indiceDosImoveis lista de Índices que referenciam cada um dos imoveis salvos na variável {@code listaImoveis}
     */
    private void adicionaImoveisPorIndice(ArrayList<Integer> indiceDosImoveis ){
        coluna = 0;     //Valor inicial do número de colunas
        linha = 1;      //e linhas para dispor os cards no GridPane

        for (int i : indiceDosImoveis){
            if(coluna == 4){    //Salta de linha ao atingir o limite de cards
                coluna = 0;
                linha++;
            }
            //Adiciona os respectivos imoveis no gridPane da janela
            imovelContainer.add(cardBoxes.get(i),coluna++,linha);    //(objeto VBox, IndexColuna, IndexLinha)
            
            GridPane.setMargin(cardBoxes.get(i), new Insets(10));    //(objeto VBox, Distância entre compontes)
        }
    }

    /**
     * Baseado nos crtérios passados como argumento, realiza uma série de 
     * condições de modo a incluir ou descartá-lo dos índices dos imóveis selecionados
     * <p>
     * Os índices serão os mesmos correspondentes à lista CardBoxes
     * 
     * @param conjuntoImoveis Lista de imóveis a ser filtrada
     * @param numGarg   Número de Garagens
     * @param areaMin   Área Mínima do terreno
     * @param areaMax   Área Máxima do terreno
     * @param precoMin  Valor mínimo pelo imóvel
     * @param precoMax  Valor máximo
     * @return ArrayList com os índices dos imóveis que atendem às condições
     */
    private ArrayList<Integer> filtraImoveis(int numGarg, double areaMin, double areaMax, double precoMin, double precoMax ){
        ArrayList<Integer> indiceImoveisFiltrados = new ArrayList<>();
        boolean criterio1 = true;               
        boolean criterio2 = true;                   //Inicializa todas as flags como true
        boolean criterio3 = true;           
        boolean criterio4 = true;
        boolean criterio5 = true;
        int indice = 0;

        for (Imovel imovel: listaImoveis){              //Testa cada condição dos argumentos
            if(imovel.getVagasGaragem() != numGarg)
                criterio1 = false;
            if(imovel.getArea() < areaMin && areaMin != 0.0)
                criterio2 = false;
            if(imovel.getArea() > areaMax && areaMax != 0.0)
                criterio3 = false;
            if(imovel.getValor() < precoMin && precoMin != 0.0)
                criterio4 = false;
            if(imovel.getValor() > precoMax && precoMax != 0.0)
                criterio5 =  false;

            if(criterio1 && criterio2 && criterio3 && criterio4 && criterio5)   //Faz o teste da intersecção das condições
                indiceImoveisFiltrados.add(indice);
            
            indice++;
        }
        return indiceImoveisFiltrados;      //Retorna a ArrayList
    }

}
