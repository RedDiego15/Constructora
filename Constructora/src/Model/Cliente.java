/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo comp
 */
public class Cliente extends User{
    
    public static Cliente instance;
    private ResultSet res;
    private String idEmpresa;
    private String cargo;
    
    private Cliente(String cedula, String nombre, String apellido, String celular, String correo, String direccion, String estadoCivil,
                    String idEmpresa,String cargo){
        super(cedula, nombre, apellido, celular, correo, direccion, estadoCivil);
        this.idEmpresa = idEmpresa;
        this.cargo = cargo;
    }
    

    public static Cliente getInstance() {
        return instance;
    }
    
    public void cargarDatosCliente(String cedula){
        if(instance == null){
            try {
                res = DataBase.getDataB().executeQuery("select * from Clientes where Cedula ="+cedula+" ;");
                if(res.next()){
                    instance = new Cliente(res.getString("cedula"),res.getString("nombre"),res.getString("apellido"),res.getString("NumCelular"),
                                           res.getString("correo"),res.getString("direccion"),res.getString("estadoCivil"),
                                           res.getString("idEmpresa"),res.getString("cargoEmpresa"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public String getCargo() {
        return cargo;
    }
    
    
}
