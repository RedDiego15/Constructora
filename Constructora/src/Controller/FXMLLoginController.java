/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField txtCedula;
   
    private ResultSet res;
    private Stage root;
    private User user;
    private Login login;
    @FXML
    private Button btnIngresar;
    @FXML
    private PasswordField txtPass;
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

   
    
}
