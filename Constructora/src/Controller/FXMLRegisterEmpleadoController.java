/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author GaryBarzola
 */
public class FXMLRegisterEmpleadoController extends Ventana  implements Initializable{
    private Stage root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setRoot(Stage root) {
        this.root = root;
    }

    @Override
    public void abrirVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLRegisterEmpleado.fxml"));
            Parent root = loader.load();
            FXMLRegisterEmpleadoController main = loader.getController();
            main.setRoot(nuevaVentana(root,"RegistroEmpleado"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
