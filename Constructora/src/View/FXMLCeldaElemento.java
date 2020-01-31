/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DataBase;
import Controller.FXMLCeldaElementoController;
import Controller.FXMLMainController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Lenovo comp
 */
public class FXMLCeldaElemento {
    
    private HBox root;
    private Label lblNombreE;
    private Label lblPrecio;
    private Button btnAgregar;
    
    private String nombre;
    
    private final FXMLCeldaElementoController controller= new FXMLCeldaElementoController();
    
    public  FXMLCeldaElemento(){}
    
    public FXMLCeldaElemento(String nombre,String precio,double valor){
       root = new HBox(15);
       this.nombre = nombre;
       this.btnAgregar = new Button("AGREGAR");
       this.btnAgregar.setOnAction(e -> controller.agregarDetalle(btnAgregar,nombre));
       this.lblNombreE = new Label(nombre);
       this.lblPrecio = new Label(precio);
       organice();
   }
    
    private void organice(){
        this.lblNombreE.setId("label-informacion-Elemento");
        this.lblPrecio.setId("label-informacion-precio");
        this.lblNombreE.getStylesheets().add("styles/styles.css");
        this.lblPrecio.getStylesheets().add("styles/styles.css");
        root.getChildren().addAll(this.lblNombreE,this.lblPrecio,this.btnAgregar);
    
    }
    
    public void crearCeldas(VBox holderScroll,ScrollPane scrollPane){
        ResultSet res = DataBase.getDataB().executeQuery("SELECT * FROM Elementos limit 8;");
        holderScroll = new VBox(15); 
        try {
            while(res.next()){
                HBox celda = this.obtenerCelda(res);
                holderScroll.getChildren().add(celda);   
            }
            scrollPane.setDisable(false);
            scrollPane.setContent(holderScroll);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    private HBox obtenerCelda(ResultSet res){
        try {
        double precio = Double.parseDouble(res.getString("Precio"));
        String nombre = res.getString("Tipo_de_elemento");
        FXMLCeldaElemento celda = new  FXMLCeldaElemento(nombre,res.getString("Precio"),precio);
        return celda.getRoot();
        
        } catch (SQLException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public HBox getRoot() {
        return root;
    }
    
    
    
    
    
}
