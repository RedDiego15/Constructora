/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO.Cliente;

import Controller.Conexion;
import Controller.DataBase;
import Model.Cliente;
import Model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author GaryBarzola
 */
public class ClienteDaoImpl implements ICRUDDao{
    private Connection connect= null;
    private Statement stm= null;
    
    @Override
    public boolean registrar(User c) {
        Cliente cliente = (Cliente)c;
        boolean registrar = false;
        try {
            connect = Conexion.getConex().conectarMySQL();
            CallableStatement sp = connect.prepareCall(" CALL registrarCliente(?,?,?,?,?,?,?,?,?,?)");
            sp.setString(1, cliente.getCedula());
            sp.setString(2, cliente.getIdEmpresa());
            sp.setString(3, cliente.getNombre());
            sp.setString(4, cliente.getApellido());
            sp.setString(5, cliente.getCelular());
            sp.setString(6, cliente.getCorreo());
            sp.setString(7, cliente.getDireccion());
            sp.setString(8, cliente.getEstadoCivil());
            sp.setString(9, cliente.getCargo());
            sp.setString(10, cliente.getNumHijos());
            sp.execute();
            sp.close();
            connect.close();
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método registrar");
                e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        List<Cliente> listaCliente= new LinkedList<>();
        Connection conn;
        PreparedStatement pS;
        ResultSet res;
        try {
            conn = Conexion.getConex().conectarMySQL();
            pS = conn.prepareStatement("call obtenerClientes(?,?,?)");
            res = pS.executeQuery();
            while(res.next()){
                String nombre = res.getString(1);
                String apellido = res.getString(2);
                String cedula = res.getString(3);
                //Cliente cliente = new Cliente();
                
                //listaCliente.add(cliente);
            }
            pS.close();
            conn.close();
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }

        return listaCliente;
    }

    public static void main(String Args[]){
        ClienteDaoImpl d = new ClienteDaoImpl();
        System.out.println(d.obtenerDatosCliente("0987654344"));
    }
    
    @Override
    public boolean actualizar(User cliente) { //Falta actualizar los otros campos
        boolean actualizar=false;
        /*
        String sql="UPDATE Clientes SET Nombre='"+cliente.getNombre()+"', Apellido='"+cliente.getApellido()+"'" +" WHERE Cedula="+cliente.getCedula();
        try {
                connect=Conexion.getConex().conectarMySQL();
                stm=connect.createStatement();
                stm.execute(sql);
                actualizar=true;
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método actualizar");
                e.printStackTrace();
        }*/	
        return actualizar;
    }

    @Override
    public boolean eliminar(User cliente) {
        boolean eliminar=false;
        /*
        String sql="DELETE FROM Clientes WHERE Cedula="+cliente.getCedula();
        try {
                connect=Conexion.getConex().conectarMySQL();
                stm=connect.createStatement();
                stm.execute(sql);
                eliminar=true;
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método eliminar");
                e.printStackTrace();
        }*/	
        return eliminar;
    }

    
    @Override
    public boolean crearUsuario(String cedula, String passport, String pass, String roll){
        boolean registrar = false;
        try {
            connect = Conexion.getConex().conectarMySQL();
            CallableStatement sp = connect.prepareCall(" CALL crearUsuario(?,?,?,?)");
            sp.setString(1, cedula);
            sp.setString(2, passport);
            sp.setString(3, pass);
            sp.setString(4, roll);
            sp.execute();
            sp.close();
            connect.close();
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método crearUsuario, " + e.getMessage());
        }
        return registrar;
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
    
    

}
