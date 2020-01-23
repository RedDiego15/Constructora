/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Casa;
import Model.Builder.CasaCieloBuilder;
import Model.Builder.CasaDirector;
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
            main.setRoot(nuevaVentana(root));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void accionSeleccionCielo(){
        casa = new CasaDirector(new CasaCieloBuilder());
        casa.construirCasa();
        ResultSet res = DataBase.getDataB().executeQuery("SELECT * FROM Elementos;");
        holderScroll = new VBox(15); 
        try {
            while(res.next()){
                HBox celda = obtenerCelda(res.getString("Tipo_de_elemento"),res.getString("Precio"),Double.parseDouble(res.getString("Precio")));
                this.holderScroll.getChildren().add(celda);
                this.scrollPane.setDisable(false);
            }
            this.scrollPane.setContent(holderScroll);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private HBox obtenerCelda(String nombre,String precio,double valor){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLCeldaElemento.fxml"));
            HBox raiz = loader.load();
            System.out.println(raiz);
            Label lb = (Label) raiz.getChildren().get(0);
            //System.out.println(raiz.getChildren().get(0));
            lb.setText(nombre+" ");
            Label lb2 = (Label) raiz.getChildren().get(1);
            lb2.setText("Precio: "+precio+" ");
            return raiz;
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //FXMLCeldaElementoController celda = new  FXMLCeldaElementoController(res.getString("Tipo_de_elemento"),res.getString("Precio"),Double.parseDouble(res.getString("Precio")));
        return null;
    }
}
