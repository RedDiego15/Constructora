/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLinfoCasaController implements Initializable {

    @FXML
    private Label txtNomCasa;
    @FXML
    private JFXTextField txtM2;
    @FXML
    private JFXTextField txtPisos;
    @FXML
    private JFXTextField txtOrient;
    @FXML
    private JFXTextField txtEsquinera;
    @FXML
    private JFXTextField txtPatio;
    @FXML
    private JFXTextField txtHabitaciones;
    @FXML
    private JFXTextField txtPrecio;
    @FXML
    private JFXTextField txtBaños;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setearCamposCasa(List<String> dataCasa){
        System.out.println(dataCasa.size());
        txtM2.setText(dataCasa.get(0));
        txtPisos.setText(dataCasa.get(1));
        if(dataCasa.get(2).equals("0"))
            txtEsquinera.setText("No");
        else
            txtEsquinera.setText("Si");
        txtOrient.setText(dataCasa.get(3));
        txtPatio.setText(dataCasa.get(4));
        txtHabitaciones.setText(dataCasa.get(5));
        txtBaños.setText(dataCasa.get(6));
        txtPrecio.setText(dataCasa.get(7));
    }
    
}
