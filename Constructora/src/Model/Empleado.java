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
 * @author GaryBarzola
 */
public class Empleado extends User{
    
    private String cargo;
    private String tlf_trabajo;
    private static Empleado instance;

    private Empleado(String cedula, String pasaporte, String nombre, String apellido, String correo, String numCelular,
                    String tlf, String estadoCivil, String cargo){        
        super(cedula,pasaporte,nombre,apellido,numCelular,correo,null,estadoCivil);  
        this.tlf_trabajo = tlf;
        this.cargo = cargo;
    }
       public static Empleado getInstance() {
        return instance;
    }
    
    public static  void cargarDatosEmpleado(String cedula){
        ResultSet res;
        if(instance == null){
            try {
                res = DataBase.getDataB().executeQuery("select * from Clientes where Cedula ="+cedula+" ;");
                if(res.next()){
                    instance = new Empleado(res.getString("Cedula"),res.getString("Pasaporte"),res.getString("Nombre"),res.getString("Apellido"),res.getString("Correo"),
                                            res.getString("NumCelular"),res.getString("Telefono_Trabajo"),res.getString("Estado_Civil"),res.getString("cargo"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 
    
    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTlf_trabajo() {
        return tlf_trabajo;
    }

    public void setTlf_trabajo(String tlf_trabajo) {
        this.tlf_trabajo = tlf_trabajo;
    }
    
    public String getRol(){
        String rol="0";
        switch(cargo){
            case "Cliente":
                rol="0";
                break;
            case "Vendedor":
                rol="1";
                break;
            case "Administrador":
                rol="2";
                break;
        }
        return rol;
    }
    
    
    
            
}
