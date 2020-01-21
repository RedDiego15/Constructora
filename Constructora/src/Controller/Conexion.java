/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Diego Rojas
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static Conexion conex = null;
    
    //com.mysql.jdbc.Driver
    private String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    private String database = "Constructora";

    // Host
    private String hostname = "127.0.0.1";

    // Puerto
    private String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    private String username = "root";

    // Clave de usuario
    private String password = "gnbp30101999";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
     public static Conexion getConex() {
        return conex;
    }

     public static void main(String arg[]){
         Conexion conex = new Conexion();
         conex.conectarMySQL();
     }

}
