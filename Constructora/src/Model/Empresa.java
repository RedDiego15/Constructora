/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GaryBarzola
 */
public class Empresa {
    private String nombre;
    private String direccion;
    private String telefono;
    private String cedulaCliente;

    public Empresa(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    
    public static String obtenerIdEmpresa(String nombreEmpresa){
            Connection conn;
            String id=null;
        try {
            conn = Conexion.getConex().conectarMySQL();
            CallableStatement sp = conn.prepareCall(" CALL obtenerEmpresa(?,?)");
            sp.setString(1, nombreEmpresa);
            sp.registerOutParameter("id", Types.VARCHAR);
            sp.execute();
            id = sp.getString("id");
            sp.close();
            conn.close();
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return id;
    }

    public static List<String> obtenerNombreEmpresas(){
        List<String> empresas = new ArrayList<>();
        Connection conn;
        PreparedStatement pS;
        ResultSet res;
        try {
            conn = Conexion.getConex().conectarMySQL();
            pS = conn.prepareStatement("call obtenerNombreEmpresas()");
            res = pS.executeQuery();
            while(res.next())
                empresas.add(res.getString(1).toLowerCase());
            pS.close();
            conn.close();
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return empresas;
    }
    
    public void registrar(){
        Connection conn;
        try {
            conn = Conexion.getConex().conectarMySQL();
            CallableStatement sp = conn.prepareCall(" CALL registrarEmpresa(?,?,?,?)");
            sp.setString(1, this.getNombre());
            sp.setString(2, this.getDireccion());
            sp.setString(3, this.getTelefono());
            sp.setString(4, this.getCedulaCliente());
            sp.execute();
            sp.close();
            conn.close();
        }catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }
    
    
    
    
}
