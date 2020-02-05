/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO.Cliente;

import Controller.Conexion;
import Controller.DataBase;
import Controller.FXMLRegisterClienteController;
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
public class ClienteDaoImpl{
    private static Connection connect= null;
    
    
    public boolean registrar(FXMLRegisterClienteController cliente) {
        
        boolean registrar = false;
        try {
            connect = Conexion.getConex().conectarMySQL();
            CallableStatement sp = connect.prepareCall(" CALL registrarCliente(?,?,?,?,?,?,?,?,?,?)");
            sp.setString(1, cliente.getfCedula().getText());
            sp.setString(2,cliente.getIdEmpresa());
            sp.setString(3, cliente.getfName().getText());
            sp.setString(4, cliente.getfLastName().getText());
            sp.setString(5, cliente.getfNumCelular().getText());
            sp.setString(6, cliente.getfCorreo().getText());
            sp.setString(7, cliente.getfDireccionCasa().getText());
            sp.setString(8, cliente.getfEstadoCivil().getValue());
            sp.setString(9, cliente.getfCargoEmpresa().getText());
            sp.setString(10, cliente.getfNumHijos().getText());
            sp.execute();
            sp.close();
            connect.close();
        } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método registrar");
                e.printStackTrace();
        }
        return registrar;
    }
    
    
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
