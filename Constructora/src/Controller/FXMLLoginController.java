/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diego Rojas
 * 
 */
public class FXMLLoginController implements Initializable {
    @FXML
    private TextField txtCedula;
    @FXML
    private Button btnIngresar;
    @FXML
    private PasswordField txtPass;
  
    private Stage root;
    private User user;
    private Login login;
   
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     public void accionIngresar() {
        if(!txtCedula.getText().equals("") && !txtPass.getText().equals("")){ 
            System.out.println("entro");
            System.out.println(txtCedula.getText());
            System.out.println(txtPass.getText());
            login = new Login(txtCedula.getText(),txtPass.getText());
            if(login.accionIngresar())
                nuevaVentana();  
        }else{
             util.Util.mostrarDialogAlert("Debe llenar los datos de cedula y contrasenia");
        }
           

    }
     public void accionIngresarSinInicio(){
         this.nuevaVentana();
     }
    //
     private void nuevaVentana() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/FXMLMain.fxml"));
            Parent root = fxmlLoader.load();
            FXMLMainController menu = fxmlLoader.getController();
            menu.setRoot(stage);
            
            /*
            menu.setUser(this.user);
           
            menu.setActual(stage);
            menu.cargarDatos();*/
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Menú Principal");
            stage.setResizable(false);
            stage.show();
        } catch (IOException i) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", i);
        }
    }
    
    public void setRoot(Stage root) {
        this.root = root;
    }

   
    
}
