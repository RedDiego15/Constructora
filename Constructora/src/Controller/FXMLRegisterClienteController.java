/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.DAO.Cliente.ClienteDaoImpl;
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
import Model.DAO.Cliente.ICRUDDao;
import Model.Empresa;
import util.Util;

/**
 * FXML Controller class
 *
 * @author 
 */
public class FXMLRegisterClienteController extends Ventana  implements Initializable {
    private FXMLRegisterClienteController main;
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
    
    private String idEmpresa="";
    
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
            main = loader.getController();
            main.setRoot(nuevaVentana(root,"Registro"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void registrarCliente(){
        ClienteDaoImpl dao = new ClienteDaoImpl();
        if(validarCampos()){
            dao.registrar(this);
            String pass = Util.codificarPass(fPass.getText().trim());
            dao.crearUsuario(fCedula.getText().trim(),fPasaporte.getText().trim(),pass,"0");
            this.cerrarVentana();
        }
            
    }
    
    private boolean validarCampos(){
        if(idEmpresa.equals(""))
            obtenerEmpresa();
        if(!fCedula.getText().trim().equals("") && !fLastName.getText().trim().equals("") && !fName.getText().trim().equals("") && !fNumCelular.getText().trim().equals("")&& !fCorreo.getText().trim().equals("")
                && !fDireccionCasa.getText().trim().equals("") && !fEstadoCivil.getValue().trim().equals("") && !fCargoEmpresa.getText().trim().equals("") && !fNumHijos.getText().trim().equals("") ){ 
            
            this.cliente = new Cliente(fCedula.getText(),fPasaporte.getText(),fName.getText(),fLastName.getText(),fNumCelular.getText(),fCorreo.getText(),fDireccionCasa.getText(),
                                fEstadoCivil.getValue(),idEmpresa,fCargoEmpresa.getText(),fNumHijos.getText());
            
            return true;
        }else{
             util.Util.mostrarDialogAlert("Debe llenar todos los campos");
        }
        return false;
    }

    private void obtenerEmpresa(){
        if(Empresa.obtenerNombreEmpresas().contains(fNameEmpresa.getText().trim().toLowerCase()))
            idEmpresa = Empresa.obtenerIdEmpresa(fNameEmpresa.getText().trim().toLowerCase());
        else{
            Empresa emp = new Empresa(fNameEmpresa.getText().trim(),fDireccionEmpresa.getText().trim(),fNumEmpresa.getText().trim());
            emp.setCedulaCliente(fCedula.getText().trim());
            emp.registrar();
            idEmpresa = Empresa.obtenerIdEmpresa(fNameEmpresa.getText().trim().toLowerCase());
        }
    }

    public JFXTextField getfLastName() {
        return fLastName;
    }

    public void setfLastName(JFXTextField fLastName) {
        this.fLastName = fLastName;
    }

    public JFXTextField getfCorreo() {
        return fCorreo;
    }

    public void setfCorreo(JFXTextField fCorreo) {
        this.fCorreo = fCorreo;
    }

    public JFXTextField getfDireccionCasa() {
        return fDireccionCasa;
    }

    public void setfDireccionCasa(JFXTextField fDireccionCasa) {
        this.fDireccionCasa = fDireccionCasa;
    }

    public JFXTextField getfCedula() {
        return fCedula;
    }

    public void setfCedula(JFXTextField fCedula) {
        this.fCedula = fCedula;
    }

    public JFXTextField getfNumCelular() {
        return fNumCelular;
    }

    public void setfNumCelular(JFXTextField fNumCelular) {
        this.fNumCelular = fNumCelular;
    }

    public JFXTextField getfNumHijos() {
        return fNumHijos;
    }

    public void setfNumHijos(JFXTextField fNumHijos) {
        this.fNumHijos = fNumHijos;
    }

    public JFXTextField getfPasaporte() {
        return fPasaporte;
    }

    public void setfPasaporte(JFXTextField fPasaporte) {
        this.fPasaporte = fPasaporte;
    }

    public JFXTextField getfNameEmpresa() {
        return fNameEmpresa;
    }

    public void setfNameEmpresa(JFXTextField fNameEmpresa) {
        this.fNameEmpresa = fNameEmpresa;
    }

    public JFXTextField getfDireccionEmpresa() {
        return fDireccionEmpresa;
    }

    public void setfDireccionEmpresa(JFXTextField fDireccionEmpresa) {
        this.fDireccionEmpresa = fDireccionEmpresa;
    }

    public JFXTextField getfNumEmpresa() {
        return fNumEmpresa;
    }

    public void setfNumEmpresa(JFXTextField fNumEmpresa) {
        this.fNumEmpresa = fNumEmpresa;
    }

    public JFXTextField getfCargoEmpresa() {
        return fCargoEmpresa;
    }

    public void setfCargoEmpresa(JFXTextField fCargoEmpresa) {
        this.fCargoEmpresa = fCargoEmpresa;
    }

    public JFXTextField getfName() {
        return fName;
    }

    public void setfName(JFXTextField fName) {
        this.fName = fName;
    }

    public JFXPasswordField getfPass() {
        return fPass;
    }

    public void setfPass(JFXPasswordField fPass) {
        this.fPass = fPass;
    }

    public JFXComboBox<String> getfEstadoCivil() {
        return fEstadoCivil;
    }

    public void setfEstadoCivil(JFXComboBox<String> fEstadoCivil) {
        this.fEstadoCivil = fEstadoCivil;
    }
    
    
}
