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
import Model.Decorator.ImplementacionDiego.Decor;
import Model.Decorator.Decorable;
import Model.Decorator.ImplementacionDiego.Decoracion;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diego Rojas
 */
public class FXMLMainController extends Ventana implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    private VBox holderScroll;
    private Stage root;
    private CasaDirector casa;
    public static Decor casaCambios;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
   
    private void crearCeldas(){
        casaCambios =  (Decor) casa;
        ResultSet res = DataBase.getDataB().executeQuery("SELECT * FROM Elementos;");
        holderScroll = new VBox(15); 
        try {
            while(res.next()){
                HBox celda = this.obtenerCelda(res);
                this.holderScroll.getChildren().add(celda);   
            }
            this.scrollPane.setDisable(false);
            this.scrollPane.setContent(holderScroll);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private HBox obtenerCelda(ResultSet res){
        try {
        double precio = Double.parseDouble(res.getString("Precio"));
        String nombre = res.getString("Tipo_de_elemento");
        FXMLCeldaElementoController celda = new  FXMLCeldaElementoController(nombre,res.getString("Precio"),precio);
        
        //Decor decorable = new Decoracion(nombre,casa);
       // celda.setDecorator(decorable);
        
        return celda.getRoot();
        
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public void accionSeleccionCielo(){
        casa = new CasaDirector(new CasaCieloBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
       
        this.crearCeldas();
        
    }
    public void accionSeleccionParaiso(){
        casa = new CasaDirector(new CasaParaisoBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
        this.crearCeldas();
    }
    public void accionSeleccionOasis(){
        casa = new CasaDirector(new CasaOasisBuilder());
        casa.construirCasa();
        System.out.println("en la accion"+casa.getCasa().getPrecioBase());
        this.crearCeldas();
    
    }
    public void accionIniciaSesion(){
        FXMLLoginController login = new FXMLLoginController();
        login.abrirVentana();
    }
    public void accionRegistrarse(){
         FXMLRegisterController register = new FXMLRegisterController();
         register.abrirVentana();
    }
    
    
    public void accionGuardarDiseno(){
        if(casa == null){
            util.Util.mostrarDialogAlert("Debe Seleccionar una Casa Basica");
        }
    }
}
