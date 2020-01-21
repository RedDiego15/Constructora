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

    // Nombre de la base de datos
    private final String database = "Constructora";

    // Host
    private final String hostname = "127.0.0.1";

    // Puerto
    private final String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private final String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    private final String username = "Constructor1"; 

    // Clave de usuario
    private final String password = "constructor2020"; 

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
