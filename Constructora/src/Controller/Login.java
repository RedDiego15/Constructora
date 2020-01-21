/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Rojas
 */
public class Login {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet res;
    private String cedula;
    private String pass;

    public Login(String cedula,String pass) {
        this.cedula = cedula;
        this.pass = pass;
    }
    
    public boolean accionIngresar() {
        try {
            
            connection = Conexion.getConex().conectarMySQL();
            preparedStatement = connection.prepareStatement("call iniciaSesion(?)");
            preparedStatement.setString(1, cedula);
            res = preparedStatement.executeQuery();
            if (res.next()) {
                return validaPass();
            } else {
                util.Util.mostrarDialogAlert("El usuario no existe.");
                return false;
            }
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        return false;
    }
    
    public boolean validaPass() throws SQLException{
        if(res.getString("contrasenia").equals(util.Util.codificarPass(pass))){
            connection.close();
            return true;
        }else{
            util.Util.mostrarDialogAlert("La contraseña no coincide");
            return false;
        }
    }
    
    
    
}
