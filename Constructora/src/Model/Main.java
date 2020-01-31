/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.FXMLLoginController;
import Model.Builder.CasaCieloBuilder;
import Model.Builder.CasaDirector;
import Model.Decorator.ImplementacionDiego.Decor;
import Model.Decorator.ImplementacionDiego.Decoracion;
import Model.Decorator.ImplementacionDiego.Led;
import Model.Decorator.ImplementacionDiego.TechoAislanteTermico;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author Diego Rojas
 */
public class Main extends Application{
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        CasaDirector casa = new CasaDirector(new CasaCieloBuilder());
        casa.construirCasa();
        
        Decor decorable = new Decoracion("Techo con aislante térmico ",casa);
        Decor decorable2 = new Decoracion("baños insonorizados",casa);
        
        Decor casaCambios =  (Decor) casa;
        casaCambios =  new Led(casaCambios);
        casaCambios = new TechoAislanteTermico(casaCambios);
        
        
        
       
        /*
        decoration = (Decoracion) decorable2;
        
        decorable = decoration.obtenerElemento();
        */
        
        System.out.println("casa Cambios 1 "+casaCambios.obtenerPresupuesto());
        //System.out.println("decorable 2 "+decorable2.obtenerPresupuesto());
        System.out.println("Casa"+casa.getCasa().getPrecioBase());

        
        
        
        
        
        
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLLogin.fxml"));
        Parent root = loader.load();
        FXMLLoginController login = loader.getController();
        login.abrirVentana();
        /*login.setRoot(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sistema Constructora");
        stage.setResizable(false);
        stage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
