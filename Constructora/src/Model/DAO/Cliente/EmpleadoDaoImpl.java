/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO.Cliente;

import Controller.Conexion;
import Controller.FXMLRegisterEmpleadoController;
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
public class EmpleadoDaoImpl{
    private Connection connect= null;
    private Statement stm= null;
    
    
    public boolean registrar(FXMLRegisterEmpleadoController emp) {
        
        boolean registrar = false;
        try {
            connect = Conexion.getConex().conectarMySQL();
            CallableStatement sp = connect.prepareCall(" CALL registrarEmpleado(?,?,?,?,?,?,?,?,?)");
            sp.setString(1, emp.geteCedula().getText());
            sp.setString(2, emp.getePasaporte().getText());
            sp.setString(3, emp.geteName().getText());
            sp.setString(4, emp.geteLastName().getText());
            sp.setString(5, emp.geteCorreo().getText());
            sp.setString(6, emp.geteCelular().getText());
            sp.setString(7, emp.geteCelular().getText()); //Telefono trabajo
            sp.setString(8, emp.geteEstadoCivil().getValue());
            sp.setString(9, emp.geteCargo().getValue());
            sp.execute();
            sp.close();
            connect.close();
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método registrar");
                e.printStackTrace();
        }
        return registrar;
    }
/*
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
*/
    
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
