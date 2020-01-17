/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.net.URL;
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
    private Login login;
   
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     public void accionIngresar() {
        if(validaCampos() && login.accionIngresar()){
            this.abrirVentana();
            
        }else{
             util.Util.mostrarDialogAlert("No existe usuario con esa Informacion");
        }
          
    }
     public void accionAbrirVentana(){
         abrirVentana();
     }
    //
     
     private void abrirVentana(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMain.fxml"));
            Parent root = loader.load();
            FXMLMainController main = loader.getController();
            main.setRoot(Ventana.getVentana().nuevaVentana(loader,root));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     /*
     private void accionAbrirVentana() throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMain.fxml"));
        Parent root = loader.load();
        FXMLMainController login = loader.getController();
        login.setRoot(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sistema Constructora");
        stage.setResizable(false);
        stage.show();
     
     }*/
    private boolean validaCampos(){
        if(!txtCedula.getText().equals("") && !txtPass.getText().equals("")){ 
            login = new Login(txtCedula.getText(),txtPass.getText());
            return true;
        }else{
             util.Util.mostrarDialogAlert("Debe llenar los datos de cedula y contrasenia");
        }
        return false;
    }
    
    public void setRoot(Stage root) {
        this.root = root;
    }

   
    
}
