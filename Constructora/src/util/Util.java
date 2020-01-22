/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

//import controller.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.LinkedList;
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Diego Rojas
 */
public class Util {

    public static boolean checkNumeric(String value) {
        for (int j = 0; j < value.length(); j++) {
            if ((int) value.charAt(j) < 48 || (int) value.charAt(j) > 57) {
                return false;
            }
        }
        return true;
    }
    

    public static void mostrarDialog(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }

    public static void mostrarDialogAlert(String texto) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }


    public static String codificarPass(String pass) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("sha1");
            byte[] array = md.digest(pass.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean confirmationDialog(String texto) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirme su elección");
        alert.setContentText(texto);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }
    
    

}
