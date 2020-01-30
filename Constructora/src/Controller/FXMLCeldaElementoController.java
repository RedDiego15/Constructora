/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Builder.CasaDirector;
import Model.Decorator.ImplementacionDiego.Decor;
import Model.Decorator.Decorable;
import Model.Decorator.ImplementacionDiego.Decoracion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Diego Rojas
 */
public class FXMLCeldaElementoController implements Initializable {
    @FXML
    private HBox root;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label lblNombreE;
    @FXML
    private Label lblPrecio;
    @FXML
    private Button btnAgregar;
    
    private double precio;
    
    private CasaDirector casa;
   // private Decorable decoracion;
    
    private Decor decoracion;
    
    
    
    
    public FXMLCeldaElementoController(String nombre,String precio,double valor,CasaDirector casa){
        root = new HBox(15);
        this.casa = casa;
        this.btnAgregar = new Button("AGREGAR");
        this.btnAgregar.setOnAction(e -> agregarDetalle());
        this.lblNombreE = new Label(nombre);
        this.lblPrecio = new Label(precio);
        this.precio = valor;
        organice();
    }
    
    private void organice(){
        this.lblNombreE.setId("label-informacion-Elemento");
        this.lblPrecio.setId("label-informacion-precio");
        this.lblNombreE.getStylesheets().add("styles/styles.css");
        this.lblPrecio.getStylesheets().add("styles/styles.css");
        root.getChildren().addAll(this.lblNombreE,this.lblPrecio,this.btnAgregar);
    
    }
    
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public Label getLblNombreE() {
        return lblNombreE;
    }

    public Label getLblPrecio() {
        return lblPrecio;
    }
    public void setRoot(HBox root) {
        this.root = root;
    }
    
    public HBox getRoot() {
        return root;
    }

    public void setDecorator(Decor decorator) {
        this.decoracion = decorator;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void agregarDetalle(){
        Decoracion decoration = (Decoracion) decoracion;
        
        decoracion = decoration.obtenerElemento();
        
        System.out.println(decoracion.obtenerPresupuesto());
        
        this.btnAgregar.setDisable(true);
    
    }
    
    
    
    
}
