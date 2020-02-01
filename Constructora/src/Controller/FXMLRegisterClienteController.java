/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.DAO.ClienteDaoImpl;
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
import Model.DAO.ICRUDDao;

/**
 * FXML Controller class
 *
 * @author 
 */
public class FXMLRegisterClienteController extends Ventana  implements Initializable {
    
    private Stage root;
    private Cliente cliente;
    @FXML
    private JFXTextField fLastName;
    @FXML
    private JFXTextField fCorreo;
    @FXML
    private JFXTextField fDireccionCasa;
    @FXML
    private JFXTextField fCedula;
    @FXML
    private JFXTextField fNumCelular;
    @FXML
    private JFXTextField fNumHijos;
    @FXML
    private JFXTextField fPasaporte;
    @FXML
    private JFXTextField fNameEmpresa;
    @FXML
    private JFXTextField fDireccionEmpresa;
    @FXML
    private JFXTextField fNumEmpresa;
    @FXML
    private JFXTextField fCargoEmpresa;
    @FXML
    private JFXTextField fName;
    @FXML
    private JFXPasswordField fPass;
    @FXML
    private JFXComboBox<String> fEstadoCivil;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fEstadoCivil.getItems().removeAll(fEstadoCivil.getItems());
        fEstadoCivil.getItems().addAll("Soltero", "Casado");
        fEstadoCivil.getSelectionModel().select("Soltero");
    }    

    public void setRoot(Stage root) {
        this.root = root;
    }

    @Override
    public void abrirVentana() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLRegisterCliente.fxml"));
            Parent root = loader.load();
            FXMLRegisterClienteController main = loader.getController();
            main.setRoot(nuevaVentana(root,"Registro"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarCliente(){
        ICRUDDao dao = new ClienteDaoImpl();
        if(validarCampos())
            dao.registrar(cliente);
            
    }
    
    private boolean validarCampos(){
        if(!fCedula.getText().equals("") && !fLastName.getText().equals("") && !fName.getText().equals("") && !fNumCelular.getText().equals("")&& !fCorreo.getText().equals("")
                && !fDireccionCasa.getText().equals("") && !fEstadoCivil.getValue().equals("") && !fCargoEmpresa.getText().equals("") && !fNumHijos.getText().equals("") ){ 
            
            this.cliente = new Cliente(fCedula.getText(),fName.getText(),fLastName.getText(),fNumCelular.getText(),fCorreo.getText(),fDireccionCasa.getText(),
                                fEstadoCivil.getValue(),null,fCargoEmpresa.getText(),fNumHijos.getText());
            return true;
        }else{
             util.Util.mostrarDialogAlert("Debe llenar todos los campos");
        }
        return false;
    }

    private int obtenerIDEmpresa(){
        //Me busca la empresa en la daba si existe returna su id, caso contrario la crea y me retorna el nuevo id
        //Pasarla como parametro en la creacion de un cliente.
        return -1;
    }
    
}
