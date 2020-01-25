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
 * @author Lenovo comp
 */
public abstract class Ventana{
    protected Stage root;
    
    
    public void cerrarVentana(){
        this.root.close();
    }
    
    protected Stage nuevaVentana(Parent root,String nombre) {
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(nombre);
     //   stage.setResizable(false);
        stage.show();
        return stage;
    }
    
    public abstract void abrirVentana();

}
