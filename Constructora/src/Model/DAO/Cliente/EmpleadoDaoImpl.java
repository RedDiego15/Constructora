/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO.Cliente;

import Controller.Conexion;
import Model.Cliente;
import Model.Empleado;
import Model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author GaryBarzola
 */
public class EmpleadoDaoImpl implements ICRUDDao{
    private Connection connect= null;
    private Statement stm= null;
    
    @Override
    public boolean registrar(User emp) {
        Empleado empleado = (Empleado)emp;
        
        boolean registrar = false;
        try {
            connect = Conexion.getConex().conectarMySQL();
            CallableStatement sp = connect.prepareCall(" CALL registrarEmpleado(?,?,?,?,?,?,?,?,?)");
            sp.setString(1, empleado.getCedula());
            sp.setString(2, empleado.getPasaporte());
            sp.setString(3, empleado.getNombre());
            sp.setString(4, empleado.getApellido());
            sp.setString(5, empleado.getCorreo());
            sp.setString(6, empleado.getCelular());
            sp.setString(7, empleado.getTlf_trabajo()); //Telefono trabajo
            sp.setString(8, empleado.getEstadoCivil());
            sp.setString(9, empleado.getCargo());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(User cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(User cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crearUsuario(String cedula, String passport, String pass, String roll) {
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
