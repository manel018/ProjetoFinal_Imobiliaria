package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class LayoutPagamentoController implements Initializable {

    
    @FXML
    private Button btnConcluirPagamento;

    @FXML
    private RadioButton btnRdBoleto;

    @FXML
    private RadioButton btnRdPix;

    @FXML
    private TextField txtPagamento;
                

    
    @FXML
    void clickBtnConcluirPagamento(ActionEvent event) {
     /**
     * Função do Botao para concluir o pagamento
     */
     
    }
    @FXML
    void btnRdBoleto(ActionEvent event) {
     /**
     * Função do RadionButton do Boleto
     */
     if (btnRdPix.isSelected()== true){
         btnRdPix.setSelected(false);
     
     }
    }

    

    @FXML
    void clickBtnRdPix(ActionEvent event) {
     /**
     * Função do RadionButton do Pix
     */
     if (btnRdBoleto.isSelected()== true){
         btnRdBoleto.setSelected(false);
     
     }
    }
    /**
    * Initializes the controller class.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
