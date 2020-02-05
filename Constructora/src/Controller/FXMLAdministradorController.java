/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Empleado;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLAdministradorController extends Ventana implements Initializable {

    @FXML
    private BorderPane borderPaneAdmin;
    @FXML
    private VBox vBoxClientes;
    @FXML
    private Label titlePaneAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarListadoVendedores();
    }    

    @FXML
    private void mostrarClientes() {
        titlePaneAdmin.setText("Clientes");
        cargarListadoClientes();
        borderPaneAdmin.setCenter(vBoxClientes);
    }
    
    @FXML
    private void mostrarVendedores() {
        titlePaneAdmin.setText("Vendedores");
        cargarListadoVendedores();
        borderPaneAdmin.setCenter(vBoxClientes);
    }
    
    
    private void cargarListadoClientes(){
        vBoxClientes.getChildren().clear();
        List<String> datoCliente = Empleado.obtenerDatosClientes();
        datoCliente.forEach((dC) -> {
            try {
                String[] data = dC.split(",");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLItemCustomer.fxml"));
                Node node = loader.load();
                FXMLItemCustomerController customer = loader.getController();
                customer.setbPCliente(borderPaneAdmin,titlePaneAdmin);
                customer.setearLabel(data[0]);
                customer.cedulaCliente(data[1]);
                vBoxClientes.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(FXMLVendedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void cargarListadoVendedores(){
        vBoxClientes.getChildren().clear();
        List<String> datoCliente = Empleado.obtenerDatosVendedores();
        datoCliente.forEach((dC) -> {
            try {
                String[] data = dC.split(",");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLItemCustomer.fxml"));
                Node node = loader.load();
                FXMLItemCustomerController customer = loader.getController();
                customer.setbPCliente(borderPaneAdmin,titlePaneAdmin);
                customer.setearLabel(data[2].toUpperCase()+" "+data[3].toUpperCase());
                customer.setCargo("Vendedor");
                vBoxClientes.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(FXMLVendedorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void mostrarLogin() {
        FXMLLoginController login = new FXMLLoginController();
        login.abrirVentana();
        this.cerrarVentana();
    }

    @Override
    public void abrirVentana(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLAdministrador.fxml"));
            Parent root = loader.load();
            FXMLAdministradorController main = loader.getController();
            main.setRoot(nuevaVentana(root,"ViewAdmin"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setRoot(Stage root){
        this.root = root;
    }
    
    @FXML
    public void accionRegistrarEmpleado(){
        FXMLRegisterEmpleadoController register = new FXMLRegisterEmpleadoController();
        register.abrirVentana();
    }
    
}
