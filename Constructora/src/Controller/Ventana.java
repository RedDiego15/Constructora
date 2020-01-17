/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Diego Rojas
 */
public class Ventana {
    
    private static Ventana ventana = new Ventana();

    public Ventana() {
    }

    public static Ventana getVentana() {
        return ventana;
    }
    public Stage nuevaVentana(FXMLLoader fxmlLoader,Parent root){
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Menú Principal");
        stage.setResizable(false);
        stage.show();
        return stage;

    
    }
    
}
