/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Rojas
 */
public class DataBase {
    
    private static DataBase dataB = new DataBase();
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet res;
    
    private DataBase(){}
    
    public ResultSet executeQuery(String query) throws SQLException{
        try{
            connection = Conexion.getConex().conectarMySQL();
            preparedStatement = connection.prepareStatement(query);
            res = preparedStatement.executeQuery();
            return res;
        }catch(SQLException e){
            util.Util.mostrarDialogAlert(e.getMessage());
        
        }
        return null;
    }

    public static DataBase getDataB() {
        return dataB;
    }

    
    
}
