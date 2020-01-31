/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.FXMLMainController.casaCambios;
import Model.Decorator.ImplementacionDiego.Decor;
import Model.Decorator.ImplementacionDiego.BañosInsonorizados;
import Model.Decorator.ImplementacionDiego.GrafiteriaEstandar;
import Model.Decorator.ImplementacionDiego.GrafiteriaItaliana;
import Model.Decorator.ImplementacionDiego.IluminacionTradicional;
import Model.Decorator.ImplementacionDiego.Led;
import Model.Decorator.ImplementacionDiego.PisoPorcelanatoImportado;
import Model.Decorator.ImplementacionDiego.PisoPorcelanatoNacional;
import Model.Decorator.ImplementacionDiego.TechoAislanteTermico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button btnAgregar;
    
    private String nombre;
    
    private double precio;
    
   // private CasaDirector casa;
   // private Decorable decoracion;
    
    //public  Decor decoracion;
    
    
    
    
    public FXMLCeldaElementoController(String nombre,String precio,double valor){
        root = new HBox(15);
        this.nombre = nombre;
       // this.decoracion = decoracion;
        //this.casa = casa;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void agregarDetalle(){
        casaCambios = this.obtenerElemento();
        
        System.out.println(casaCambios.obtenerPresupuesto());
        this.btnAgregar.setDisable(true);
    
    }
    
    private Decor obtenerElemento(){
        if(nombre.equals("Techo con aislante térmico ")){
            return new TechoAislanteTermico(casaCambios);
        }else if(nombre.equals("Piso Porcelanato Nacional")){
            return new PisoPorcelanatoNacional(casaCambios);
        }else if(nombre.equals("Piso Porcelanato importado")){
            return new PisoPorcelanatoImportado(casaCambios);
        }else if(nombre.equals("grifería estándar")){ 
            return new GrafiteriaEstandar(casaCambios);
        }else if(nombre.equals("grifería Italiana")){
            return new GrafiteriaItaliana(casaCambios);
        }else if(nombre.equals("iluminación tradicional ")){
            return new IluminacionTradicional(casaCambios);
        }else if(nombre.equals("iluminación led ")){
            return new Led(casaCambios);       
        }else if(nombre.equals("baños insonorizados")){
            return new BañosInsonorizados(casaCambios);
        }else if(nombre.equals("Techo con aislante térmico ")){
            return new TechoAislanteTermico(casaCambios);
        }
        return null;
    }  
    
}
