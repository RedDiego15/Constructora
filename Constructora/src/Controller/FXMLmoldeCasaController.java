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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLmoldeCasaController implements Initializable {
    private String idCasa;
    @FXML
    private Label nameCasa;
    private BorderPane bPCliente;
    private Label title;
    private String nombreCliente;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setCasa(String nombre, String id){
        nameCasa.setText(nombre);
        this.idCasa=id;
    }

    @FXML
    private void verInfoCasa() {
        //List<String> datosCasa= obtenerLosdatosCasa(idCasa);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLinfoCasa.fxml"));
            try {
                Node node = loader.load();
                FXMLinfoCasaController mCasa = loader.getController();
                
                //mCasa.setearCamposCasa(datosCasa);
                
                title.setText("Cliente: "+nombreCliente);
                bPCliente.setCenter(node);
            } catch (IOException ex) {
                Logger.getLogger(FXMLItemCustomerController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void setbPCliente(BorderPane bPCliente,Label titlePaneVendedor) {
        this.bPCliente = bPCliente;
        this.title=titlePaneVendedor;
    }
    
    public void setCliente(String name){
        this.nombreCliente=name;
    }
    
    
}
