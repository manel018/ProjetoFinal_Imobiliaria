package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import servicos.JotaImoveisGerencia;

public class LayoutPrincipalController extends ControllerMaster{
    @FXML
    private Button bt_pesquisar;

    @FXML
    private Button bt_sair;

    @FXML
    private ComboBox<String> cb_estado;

    @FXML
    private ComboBox<String> cb_cidade;

    @FXML
    private ComboBox<String> cb_imovel;

    @FXML
    private ComboBox<String> cb_transacao;

    @FXML
    private ImageView fundo_principal;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    JotaImoveisGerencia gerenciamento;

    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        gerenciamento = new JotaImoveisGerencia();  //Instancia o gerenciador de imóveis

        ObservableList<String> casaApto = FXCollections.observableArrayList();  
        casaApto.add("Apartamento"); casaApto.add("Casa");                  
        cb_imovel.setItems(casaApto);

        ObservableList<String> listaEstados = FXCollections.observableArrayList();
        listaEstados.addAll(Arrays.asList("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", 
        "Distrito Federal", "Espirito Santo", "Goiás", "Maranhão", "Mato Grosso",                       //Segundo info do comboBox
        "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco",
        "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
        "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"));

        cb_estado.setItems(listaEstados);
         
        
        ObservableList<String> oq = FXCollections.observableArrayList();
        oq.add("Alugar"); oq.add("Comprar");
        cb_transacao.setItems(oq);
         
        BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
        Background background = new Background(backgroundFill);
         
        label1.setBackground(background);
        label2.setBackground(background);
        label3.setBackground(background);
        label4.setBackground(background);
    } 
    @FXML
    void clickSair(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void clickPesquisar(ActionEvent event) {
        /*
         * Baseado nos campos que estão preenchidos ou não, fazer uma pesquisa filtrada
        */
        LayoutResultadosController resultadosController = new LayoutResultadosController();
        try {
            chamaProximaCena("/GUI/fxml/LayoutResultados.fxml", resultadosController, dados);

            //Fecha a janela atual
            Stage stageLocal = (Stage) bt_pesquisar.getScene().getWindow();    
            stageLocal.close();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
            alert.setTitle("Erro");                       //possível carregar o arquivo
            alert.setHeaderText(null);  
            alert.setContentText("Tivemos problemas ao carregar as informações...");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
}

