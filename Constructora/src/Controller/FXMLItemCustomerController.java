/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.Cliente.ClienteDaoImpl;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLItemCustomerController implements Initializable {
    private String cedula;
    @FXML
    private Label Lname;
    private BorderPane bPCliente;
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
    
    public void cedulaCliente(String cedula){
        this.cedula = cedula;
        
    }
    
    public void verInfoCliente(){
        List<String> dataCliente = ClienteDaoImpl.obtenerDatosCliente(cedula);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLInfoCliente.fxml"));
        try {
            Node node = loader.load();
            FXMLInfoClienteController ctr = loader.getController();
            ctr.setearCamposCliente(dataCliente);
            bPCliente.setCenter(node);
        } catch (IOException ex) {
            Logger.getLogger(FXMLItemCustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void setbPCliente(BorderPane bPCliente) {
        this.bPCliente = bPCliente;
    }
    
    
    
}
