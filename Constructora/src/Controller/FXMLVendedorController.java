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
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLVendedorController extends Ventana implements Initializable{

    @FXML
    private VBox vBoxClientes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Node[] nodo = new Node[10];
        
        for(int i=0; i<nodo.length; i++){
            try {
                nodo[i] = FXMLLoader.load(getClass().getResource("/view/itemCliente.fxml"));
                vBoxClientes.getChildren().add(nodo[i]);
            } catch (IOException ex) {
                Logger.getLogger(FXMLVendedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }    
    
    public void setRoot(Stage root){
        this.root = root;
    }
    
    @Override
     public void abrirVentana(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLVendedor.fxml"));
            FXMLVendedorController main = loader.getController();
            main.setRoot(nuevaVentana((Parent)loader.load(),"ViewVendedor"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
