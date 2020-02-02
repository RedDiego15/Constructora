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
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
    @FXML
    private BorderPane borderPaneVendedor;

    
   // private final FXMLVendedorController main = ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> datoCliente = ClienteDaoImpl.obtenerDatosClientes();
        datoCliente.forEach((dC) -> {
            try {
                String[] data = dC.split(",");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLItemCustomer.fxml"));
                Node node = loader.load();
                FXMLItemCustomerController customer = loader.getController();
                customer.setbPCliente(borderPaneVendedor);
                customer.setearLabel(data[0]);
                customer.cedulaCliente(data[1]);
                vBoxClientes.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(FXMLVendedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }    
    
    public void mostrarClientes(){
        borderPaneVendedor.setCenter(vBoxClientes);
    }
    
    public void setRoot(Stage root){
        this.root = root;
    }
    
    
    
    @Override
     public void abrirVentana(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLVendedor.fxml"));
            Parent root = loader.load();
            FXMLVendedorController main = loader.getController();
            main.setRoot(nuevaVentana(root,"ViewVendedor"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
