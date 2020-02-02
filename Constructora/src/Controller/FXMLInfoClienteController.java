/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.Cliente.ClienteDaoImpl;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author GaryBarzola
 */
public class FXMLInfoClienteController implements Initializable {

    private String cedula;
    @FXML
    private HBox HboxCasasCliente;
    @FXML
    private JFXTextField txtNombre;
    @FXML
    private JFXTextField txtPasaporte;
    @FXML
    private JFXTextField txtCorreo;
    @FXML
    private JFXTextField txtNameEmpresa;
    @FXML
    private JFXTextField txtApellido;
    @FXML
    private JFXTextField txtCelular;
    @FXML
    private JFXTextField txtDireccion;
    @FXML
    private JFXTextField txtNumHijos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setearCamposCliente(List<String> dataCliente){
        for(String dC: dataCliente){
            String[] data= dC.split(",");
            txtNombre.setText(data[3]);
            txtPasaporte.setText(data[2]);
            txtCorreo.setText(data[6]);
            txtNameEmpresa.setText(data[1]); //Llamar al procedure que me retorne el nombre de la empresa por id
            txtApellido.setText(data[4]);
            txtCelular.setText(data[5]);
            txtDireccion.setText(data[7]);
            txtNumHijos.setText(data[10]);
            cedula=data[0];
        }
    }
    
    public void actualizarCliente(){
        ClienteDaoImpl.actualizarCliente(cedula,txtNombre.getText().trim(),txtApellido.getText().trim(),txtPasaporte.getText().trim(),
                                        txtCorreo.getText().trim(),txtCelular.getText().trim(),txtDireccion.getText().trim(),txtNumHijos.getText().trim());
    }
    
}
