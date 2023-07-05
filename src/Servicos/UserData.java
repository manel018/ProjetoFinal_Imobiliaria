package Servicos;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe para instanciar novas janelas ao longo do programa.
 * Toda classe {@code Controller} precisa ter esses atributos tanto
 * para receber os dados da cena anterior quanto para invocar e 
 * transmitir os dados para a próxima.
 */
public abstract class UserData{
    protected ArrayList<Object> dados;   //Armazena todos os dados da controller corrente
    protected Stage stage;
    protected Scene scene;
    protected Parent root;
}



