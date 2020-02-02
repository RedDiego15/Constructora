/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import static Controller.FXMLMainController.casa;
import static Controller.FXMLMainController.casaCambios;
import Model.Decorator.Decor;
import Model.Decorator.BañosInsonorizados;
import Model.Decorator.GrafiteriaEstandar;
import Model.Decorator.GrafiteriaItaliana;
import Model.Decorator.IluminacionTradicional;
import Model.Decorator.Led;
import Model.Decorator.PisoPorcelanatoImportado;
import Model.Decorator.PisoPorcelanatoNacional;
import Model.Decorator.TechoAislanteTermico;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Diego Rojas
 */
public class FXMLCeldaElementoController implements Initializable {
    
    
    
    public FXMLCeldaElementoController(){

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void agregarDetalle(Button btnAgregar,String nombre){
        casaCambios = this.obtenerElemento(nombre);
        System.out.println(casaCambios.obtenerPresupuesto());
        btnAgregar.setDisable(true);
    
    }
    
    public Decor obtenerElemento(String nombre){
        if(nombre.equals("Techo con aislante térmico ")){
            casaCambios.getCasa().setAislanteTérmicoEnTecho(true);
            return new TechoAislanteTermico(casaCambios);
            
        }else if(nombre.equals("Piso Porcelanato Nacional")){
            casaCambios.getCasa().setPisosPorcelanatoNacional(true);
            return new PisoPorcelanatoNacional(casaCambios);
            
        }else if(nombre.equals("Piso Porcelanato importado")){
            casaCambios.getCasa().setPisosPorcelanatoimportado(true);
            return new PisoPorcelanatoImportado(casaCambios);
            
        }else if(nombre.equals("grifería estándar")){ 
            casaCambios.getCasa().setGriferíaEstándar(true);
            return new GrafiteriaEstandar(casaCambios);
            
        }else if(nombre.equals("grifería Italiana")){
            casaCambios.getCasa().setGriferíaitaliana(true);
            return new GrafiteriaItaliana(casaCambios);
            
        }else if(nombre.equals("iluminación tradicional ")){
            casaCambios.getCasa().setIluminaciónTradicional(true);
            return new IluminacionTradicional(casaCambios);
            
        }else if(nombre.equals("iluminación led ")){
            casaCambios.getCasa().setLed(true);
            return new Led(casaCambios); 
            
        }else if(nombre.equals("baños insonorizados")){
            casaCambios.getCasa().setBañosInsonorizados(true);
            return new BañosInsonorizados(casaCambios);
            
        }else if(nombre.equals("Techo con aislante térmico ")){
            casaCambios.getCasa().setAislanteTérmicoEnTecho(true);
            return new TechoAislanteTermico(casaCambios);
        }
        return null;
    }
}
