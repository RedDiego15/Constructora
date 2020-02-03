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
import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.AnchorPane;

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
    private Button btnDiseno;
    
    private VBox holderScroll;
    private CasaDirector casa;
    public static Decor casaCambios;
    
    @FXML
    private Label Jempleado;
    @FXML
    private Label Jcliente;
    @FXML
    private AnchorPane raiz;
    @FXML
    private JFXButton btnRegistro;
    @FXML
    private JFXButton btnCerrarSesion;
    
    public FXMLMainController(){
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Cliente.estaInstanciado()){
            btnIniciaSesion.setDisable(true);
            btnRegistro.setDisable(true);
            btnIniciaSesion.setOpacity(0);
            btnRegistro.setOpacity(0);
            btnCerrarSesion.setDisable(false);
            btnCerrarSesion.setOpacity(1);
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
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void llenarElementos(){
        casaCambios =  (Decor) casa;
        FXMLCeldaElemento celdas = new FXMLCeldaElemento();
        celdas.crearCeldas(holderScroll, scrollPane);
        
    }
    @FXML
     public void accionSeleccionCielo(){
         this.btnDiseno.setDisable(false);
        casa = new CasaDirector(new CasaCieloBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
       
        this.llenarElementos();
        
    }
    @FXML
    public void accionSeleccionParaiso(){
        this.btnDiseno.setDisable(false);
        casa = new CasaDirector(new CasaParaisoBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
        this.llenarElementos();
    }
    @FXML
    public void accionSeleccionOasis(){
        this.btnDiseno.setDisable(false);
        casa = new CasaDirector(new CasaOasisBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
        this.llenarElementos();
    
    }
    @FXML
    public void accionIniciaSesion(){
        FXMLLoginController login = new FXMLLoginController();
        login.abrirVentana();
    }
    
    @FXML
    public void accionCerrarSesion(){
        accionIniciaSesion();
        this.cerrarVentana();
        Cliente.sacarInstanciaCliente();
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
    
    @FXML
    public void accionRegistrarCliente(){
        FXMLRegisterClienteController register = new FXMLRegisterClienteController();
        register.abrirVentana();
    }
    
    @FXML
    public void accionRegistrarEmpleado(){
        FXMLRegisterEmpleadoController register = new FXMLRegisterEmpleadoController();
        register.abrirVentana();
    }
    
    @FXML
    public void accionGuardarDiseno(){
        if(casa == null){
            util.Util.mostrarDialogAlert("Debe Seleccionar una Casa Basica");
        }else if (!Cliente.estaInstanciado()){
            util.Util.mostrarDialogAlert("Debe iniciar sesion antes de guardar su Diseno");
        }else{
            
            DataBase.getDataB().executeHouseInsert("insert into Casas "+
                            "(Metros_cuadrados,cliente,NumPlantas,Esquinera,Orientacion,TmnPatio,NumHabitaciones,NumBanios,Precio)"+
                            "values(?,?,?,?,?,?,?,?,?);");
            this.btnDiseno.setDisable(true);
            
            
        }
    }

    public Button getBtnIniciaSesion() {
        return btnIniciaSesion;
    }
    
}
