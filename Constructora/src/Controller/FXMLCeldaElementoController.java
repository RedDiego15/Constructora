/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
    
    private double precio;
    
    
    

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

    public double getPrecio() {
        return precio;
    }

    public void setRoot(HBox root) {
        this.root = root;
    }
    
 

    public HBox getRoot() {
        return root;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
    
}
