package controllers;

import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;




public class LayoutPixController implements Initializable {
     @FXML
    private Button btnSairPix;
     @FXML
    private Button btnInicioPix;

   

    @FXML
    void clickBtnInicioPix(ActionEvent event) {
     /**
     * Função do Botao para Voltar a tela inicial
     */

    }
    @FXML
    void clickBtnSairPix(ActionEvent event) {
     /**
     * Função do Botao para Sair do programa
     */
        exit(1);

    }
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
