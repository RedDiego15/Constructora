/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.FXMLLoginController;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * #00918e verde ,  #110133 lila 
 * @author Diego Rojas
 */
public class Main extends Application{
    
    
    @Override
    public void start(Stage stage) throws Exception {
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLLogin.fxml"));
        Parent root = loader.load();
        FXMLLoginController login = loader.getController();*/
        FXMLLoginController login = new FXMLLoginController();
        login.abrirVentana();
 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
