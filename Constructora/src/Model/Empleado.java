/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Conexion;
import Controller.DataBase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GaryBarzola
 */
public class Empleado extends User{
    private static Connection connect= null;
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
    
    public static void cargarDatosEmpleado(String cedula){
        ResultSet res;
        if(instance == null){
            try {
                res = DataBase.getDataB().executeQuery("select * from Empleados where Cedula ="+cedula+" ;");
                if(res.next()){
                    instance = new Empleado(res.getString("Cedula"),res.getString("Pasaporte"),res.getString("Nombre"),res.getString("Apellido"),res.getString("Correo"),
                                            res.getString("NumCelular"),res.getString("Telefono_Trabajo"),res.getString("Estado_Civil"),res.getString("cargo"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<String> obtenerDatosClientes() {
        List<String> listaCliente= new LinkedList<>();
        Connection conn;
        PreparedStatement pS;
        ResultSet res;
        try {
            conn = Conexion.getConex().conectarMySQL();
            pS = conn.prepareStatement("call obtenerClientes()");
            res = pS.executeQuery();
            while(res.next()){
                String nombre = res.getString(4);
                String apellido = res.getString(5);
                String cedula = res.getString(1);
                listaCliente.add(nombre.toUpperCase()+" "+apellido.toUpperCase()+","+cedula);
            }
            pS.close();
            conn.close();
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return listaCliente;
    }
    
    public static List<String> obtenerDatosCliente(String cedula) {
        List<String> listaCliente= new LinkedList<>();
        ResultSet res;
        try {
            res = DataBase.getDataB().executeQuery("Select * From Clientes c Where c.Cedula="+cedula+" ;");
            while(res.next()){
                listaCliente.add(res.getString(1)+","+res.getString(2)+","+res.getString(3)+","+res.getString(4)+","+res.getString(5)+","+
                                res.getString(6)+","+res.getString(7)+","+res.getString(8)+","+res.getString(9)+","+res.getString(10)+","+res.getString(11));
            }
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return listaCliente;
    }
    
    
    public static boolean actualizarCliente(String ced,String nam,String lnam,String pas,String corr,String cel,String dir,String nHij){
        try {
            connect = Conexion.getConex().conectarMySQL();
            CallableStatement sp = connect.prepareCall(" CALL actualizarCliente(?,?,?,?,?,?,?,?)");
            sp.setString(1, ced);
            sp.setString(2, nam);
            sp.setString(3, lnam);
            sp.setString(4, cel);
            sp.setString(5, pas);
            sp.setString(6, corr);
            sp.setString(7, dir);
            sp.setString(8, nHij);
            sp.execute();
            sp.close();
            connect.close();
            return true;
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return false;
    }
    
    public static List<String> obtenerCasas(String cedula){
        List<String> idCasas = new LinkedList<>();
        Connection conn;
        PreparedStatement pS;
        ResultSet res;
        try {
            conn = Conexion.getConex().conectarMySQL();
            pS = conn.prepareStatement("call obtenerIdCasa(?)");
            pS.setString(1, cedula);
            res = pS.executeQuery();
            while(res.next()){
                String idCasa = res.getString(1);
                idCasas.add(idCasa);
            }
            pS.close();
            conn.close();
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return idCasas;
    }
    
    public static List<String> obtenerDataCasa(String id){
        List<String> dataCasa = new LinkedList<>();
        ResultSet res;
        try {
            res = DataBase.getDataB().executeQuery("Select * From Casas c Where c.idCasa="+id+";");
            if(res.next()){
                dataCasa.add(res.getString(3));
                dataCasa.add(res.getString(4));
                dataCasa.add(res.getString(5));
                dataCasa.add(res.getString(6));
                dataCasa.add(res.getString(7));
                dataCasa.add(res.getString(8));
                dataCasa.add(res.getString(9));
                dataCasa.add(res.getString(10));
            }
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return dataCasa;
    }
    
    public static List<String> obtenerDatosVendedores() {
        List<String> listaVendedores= new LinkedList<>();
        Connection conn;
        PreparedStatement pS;
        ResultSet res;
        try {
            conn = Conexion.getConex().conectarMySQL();
            pS = conn.prepareStatement("call obtenerVendedores()");
            res = pS.executeQuery();
            while(res.next()){
                String cedula = res.getString(1);
                String pasaporte = res.getString(2);
                String nombre = res.getString(3);
                String apellido = res.getString(4);
                String correo = res.getString(5);
                String celular = res.getString(6);
                String tlf = res.getString(7);
                String eCivil = res.getString(8);
                String cargo = res.getString(9);
                
                listaVendedores.add(cedula+","+pasaporte+","+nombre+","+apellido+","+correo+","+celular+","+tlf
                                +","+eCivil+","+cargo);
            }
            pS.close();
            conn.close();
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return listaVendedores;
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
