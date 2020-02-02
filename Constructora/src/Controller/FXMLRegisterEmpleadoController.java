/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.Cliente.EmpleadoDaoImpl;
import Model.DAO.Cliente.ICRUDDao;
import Model.Empleado;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import util.Util;

/**
 *
 * @author GaryBarzola
 */
public class FXMLRegisterEmpleadoController extends Ventana  implements Initializable{
    private Empleado empleado;
    @FXML
    private JFXComboBox<String> eCargo;
    @FXML
    private JFXTextField eName;
    @FXML
    private JFXPasswordField ePassword;
    @FXML
    private JFXTextField eCedula;
    @FXML
    private JFXTextField eCorreo;
    @FXML
    private JFXTextField eCelular;
    @FXML
    private JFXTextField eLastName;
    @FXML
    private JFXTextField ePasaporte;
    @FXML
    private JFXComboBox<String> eEstadoCivil;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eEstadoCivil.getItems().removeAll(eEstadoCivil.getItems());
        eEstadoCivil.getItems().addAll("Soltero", "Casado");
        eEstadoCivil.getSelectionModel().select("Soltero");
        
        eCargo.getItems().removeAll(eCargo.getItems());
        eCargo.getItems().addAll("Cliente", "Vendedor","Administrador");
        eCargo.getSelectionModel().select("Vendedor");

    }    

    public void setRoot(Stage root) {
        this.root = root;
    }

    @Override
    public void abrirVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLRegisterEmpleado.fxml"));
            FXMLRegisterEmpleadoController main = loader.getController();
            main.setRoot(nuevaVentana((Parent)loader.load(),"RegistroEmpleado"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarEmpleado(){
        EmpleadoDaoImpl dao = new EmpleadoDaoImpl();
        if(validarCampos()){
            dao.registrar(empleado);
            String pass = Util.codificarPass(ePassword.getText().trim());
            dao.crearUsuario(eCedula.getText().trim(),ePasaporte.getText().trim(),pass,empleado.getRol());
            this.cerrarVentana();
        }
            
    }
    
    private boolean validarCampos(){
        if(!eCedula.getText().trim().equals("") && !eName.getText().trim().equals("") && !eLastName.getText().trim().equals("")&& !eCorreo.getText().trim().equals("")
                && !eCelular.getText().trim().equals("") && !eEstadoCivil.getValue().trim().equals("") && !eCargo.getValue().trim().equals("")){ 
            
            this.empleado = new Empleado(eCedula.getText(),ePasaporte.getText(),eName.getText(),eLastName.getText(),eCorreo.getText(),eCelular.getText(),null,
                                eEstadoCivil.getValue(),eCargo.getValue());
            
            return true;
        }else{
             util.Util.mostrarDialogAlert("Debe llenar todos los campos");
        }
        return false;
    }
    
    
    
}
