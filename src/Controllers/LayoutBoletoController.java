package Controllers;

import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


  

public class LayoutBoletoController implements Initializable {
     @FXML
    private Button btnSairBoleto;
    private Button btnInicioBoleto;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void clickBtnSairBoleto(ActionEvent event) {
        exit(1);
     /**
     * Função do Botao para Sair do programa
     */

    }
    @FXML
    void clickBtnInicioBoleto(ActionEvent event) {
     /**
     * Função do Botao para Voltar a tela inicial
     */
      }
    
    
}
