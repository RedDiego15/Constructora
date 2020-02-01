/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO.Cliente;

import Controller.Conexion;
import Controller.DataBase;
import Model.Cliente;
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
    public boolean registrar(Cliente cliente) {
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
        ResultSet rs=null;
        String sql="SELECT * FROM Clientes ORDER BY Nombre";
        try {			
            rs=DataBase.getDataB().executeQuery(sql);
            while (rs.next()) {
                Cliente c=Cliente.getInstance();                       
                c.setCedula(rs.getString(1));
                c.setNombre(rs.getString(4));
                c.setApellido(rs.getString(5));
                c.setCelular(rs.getString(6));
                c.setCorreo(rs.getString(7));
                c.setDireccion(rs.getString(8));
                c.setEstadoCivil(rs.getString(9));
                c.setCargo(rs.getString(10));
                c.setNumHijos(rs.getString(11));
                listaCliente.add(c);
            }
            rs.close();
            connect.close();
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método obtener");
                e.printStackTrace();
        }

        return listaCliente;
    }

    
    @Override
    public boolean actualizar(Cliente cliente) { //Falta actualizar los otros campos
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
    public boolean eliminar(Cliente cliente) {
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

}
