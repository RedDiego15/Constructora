/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.User;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diego Rojas
 * 
 */
public class FXMLLoginController extends Ventana implements Initializable{
    @FXML
    private TextField txtCedula;
    @FXML
    private PasswordField txtPass;
    
    private final FXMLMainController main = new FXMLMainController();
    private Login login;
    private ResultSet res;
   
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     public void accionIngresar() {
        if(validaCampos() && login.accionIngresar()){
            int n = login.obtenerRol();
            switch (n) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    //Cliente.getInstance().cargarDatosCliente(txtCedula.getText());
                    break;
            }
            this.abrir();
            
        } 
    }
     public void accionAbrirVentana(){
             this.abrir();
    }
   
    @Override
     public void abrirVentana(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLLogin.fxml"));
            Parent root = loader.load();
            FXMLLoginController main = loader.getController();
            main.setRoot(nuevaVentana(root,"Login"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    private boolean validaCampos(){
        if(!txtCedula.getText().equals("") && !txtPass.getText().equals("")){ 
            login = new Login(txtCedula.getText(),txtPass.getText());
            return true;
        }else{
             util.Util.mostrarDialogAlert("Debe llenar los datos de cedula y contrasenia");
        }
        return false;
    }
    private void abrir(){
        main.abrirVentana();
        this.cerrarVentana();
    }
    public void setRoot(Stage root) {
        this.root = root;
    }

}
