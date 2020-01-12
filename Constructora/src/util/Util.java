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
 * @author JONATHAN
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

    public static String FileToBase64(File img) {
        String encodedBase64 = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(img);
            byte[] bytes = new byte[(int) img.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(DatatypeConverter.printBase64Binary(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encodedBase64;
    }

    public static boolean Base64ToFile(String codificado, String ruta) throws IOException {
        byte[] valueDecoded = Base64.getDecoder().decode(codificado);
        OutputStream out = null;
        try {
            out = new FileOutputStream("src/resources/tmp/" + ruta);
            out.write(valueDecoded);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            if (out != null) {
                out.close();
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

    public static boolean verificarPatron(String patron, String cadena) {
        Pattern pattern = Pattern.compile(patron);
        return pattern.matcher(cadena).find();
    }
/*
    public static LinkedList crearListaDepartamentos() {
        LinkedList<String> departamentos = new LinkedList<>();
        Conexion conex;
        Connection con;
        PreparedStatement ps;
        ResultSet res;
        try {
            conex = new Conexion();
            con = conex.conectarMySQL();
            ps = con.prepareStatement("select ID from departamento");
            res = ps.executeQuery();
            while (res.next()) {
                departamentos.add(res.getString("ID"));
            }
        } catch (Exception e) {
            mostrarDialogAlert(e.getMessage());
        }
        return departamentos;
    }
*/
    public static File cargarFoto() {
        File imgFile = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");
        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.jpeg", "*.jpg", "*.png", "*.bmp", "*.gif")
        );
        // Obtener la imagen seleccionada
        imgFile = fileChooser.showOpenDialog(null);
        return imgFile;
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
