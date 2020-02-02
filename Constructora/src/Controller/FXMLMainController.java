/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Builder.CasaCieloBuilder;
import Model.Builder.CasaDirector;
import Model.Builder.CasaOasisBuilder;
import Model.Builder.CasaParaisoBuilder;
import Model.Cliente;
import Model.Decorator.Decor;
import View.FXMLCeldaElemento;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import javafx.stage.Stage;
import javax.swing.JLabel;

/**
 * FXML Controller class
 *
 * @author Diego Rojas
 */
public class FXMLMainController extends Ventana implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button btnIniciaSesion;
    @FXML
    private Button btnRegistro;
    
    private VBox holderScroll;
    private Stage root;
    private CasaDirector casa;
    public static Decor casaCambios;
    
    @FXML
    private Label Jempleado;
    
    @FXML
    private Label Jcliente;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        if(Cliente.getInstance()==null){
            
        }
    }
    public Stage getRoot() {
        return root;
    }

    public void setRoot(Stage root) {
        this.root = root;
    }
    @Override
    public void abrirVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLMain.fxml"));
            Parent root = loader.load();
            FXMLMainController main = loader.getController();
            main.setRoot(nuevaVentana(root,"Main"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void llenarElementos(){
        casaCambios =  (Decor) casa;
        FXMLCeldaElemento celdas = new FXMLCeldaElemento();
        celdas.crearCeldas(holderScroll, scrollPane);
        
    }
     public void accionSeleccionCielo(){
        casa = new CasaDirector(new CasaCieloBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
       
        this.llenarElementos();
        
    }
    public void accionSeleccionParaiso(){
        casa = new CasaDirector(new CasaParaisoBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
        this.llenarElementos();
    }
    public void accionSeleccionOasis(){
        casa = new CasaDirector(new CasaOasisBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
        this.llenarElementos();
    
    }
    public void accionIniciaSesion(){

        FXMLLoginController login = new FXMLLoginController();
        login.abrirVentana();
        
       
    }
    public void accionRegistrarse() throws IOException{
         if(Jempleado.isDisable() || Jcliente.isDisable()){
             Jempleado.setDisable(false);
             Jcliente.setDisable(false);
             Jempleado.setOpacity(1);
             Jcliente.setOpacity(1);
         }else{
             Jempleado.setDisable(true);
             Jcliente.setDisable(true);
             Jempleado.setOpacity(0);
             Jcliente.setOpacity(0);
         }
    }
    
    public void accionRegistrarCliente(){
        FXMLRegisterClienteController register = new FXMLRegisterClienteController();
        register.abrirVentana();
    }
    
    public void accionRegistrarEmpleado(){
        FXMLRegisterEmpleadoController register = new FXMLRegisterEmpleadoController();
        register.abrirVentana();
    }
    
    public void accionGuardarDiseno(){
        if(casa == null){
            util.Util.mostrarDialogAlert("Debe Seleccionar una Casa Basica");
        }else if (Cliente.getInstance() == null){
            util.Util.mostrarDialogAlert("Debe iniciar sesion antes de guardar su Diseno");
        }else{
            
            
        
        }
    }
}
