/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.Cliente.ClienteDaoImpl;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLItemCustomerController implements Initializable {

    @FXML
    private Label Lname;
    @FXML
    private JFXButton btnVerCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setearLabel(String data){
        Lname.setText(data);
    }
    
    public void verInfoCliente(String cedula){
        ClienteDaoImpl.obtenerDatosCliente(cedula);
        //llamar a otro pane que me añado los metodos a los label 
        // y me retorne ese pane para luego setear el paneCentral de vendedorController
        
    }
}
