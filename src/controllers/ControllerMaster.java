package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe para instanciar novas janelas ao longo do programa.
 * Toda classe {@code ControllerMaster}, com tais atributos, pode
 * tanto receber os dados da cena anterior quanto invocar e 
 * transmitir os dados para a próxima.
 * 
 * @author Emanuel Victor
 * @author Lucas Souza
 * @author Caio Lopes
 * @author Gabriel Araujo
 */
public abstract class ControllerMaster{
    protected ArrayList<Object> dados;   //Armazena todos os dados da controller corrente
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    //Getter de dados
    public ArrayList<Object> getDados() {
        return dados;
    }
    //Setter de dados
    public void setDados(ArrayList<Object> dados) {
        this.dados = dados;
    }

    /**
     * Invoca uma janela do tipo <b>.fxml</b> e guarda 
     * uma coleção de objetos com as informações da janela atual para serem usadas 
     * na classe controller da nova janela.
     * 
     * @param caminhoFXML   Link do arquivo FXML que se deseja carregar
     * @param controller Controlador da janela seguinte
     * @param dados Coleção de objetos de dados para transmitir para a próxima janela
     */
    public void chamaProximaCena(String caminhoFXML, ControllerMaster controller, ArrayList<Object> dados) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
    
        controller.setDados(dados);     //Salva os dados no controller
        
        loader.setController((ControllerMaster)controller);  //Atribui o controller instanciado ao loader
        root = loader.load();               
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();        //Invoca a cena
    }
}






