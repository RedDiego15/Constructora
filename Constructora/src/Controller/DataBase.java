/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

//import static Controller.FXMLMainController.casa;
import static Controller.FXMLMainController.casaCambios;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Rojas
 */
public class DataBase {
    
    private static DataBase dataB = new DataBase();
    
    private Connection connection;
    private PreparedStatement preparedSt;
    private ResultSet res;
    
    private DataBase(){}
    
    public ResultSet executeQuery(String query){
        try{
            connection = Conexion.getConex().conectarMySQL();
            preparedSt = connection.prepareStatement(query);
            res = preparedSt.executeQuery();
            return res;
        }catch(SQLException e){
            util.Util.mostrarDialogAlert(e.getMessage());
        
        }
        return null;
    }

    public static DataBase getDataB() {
        return dataB;
    }
    
    public void executeHouseInsert(String query){
        try {       
            connection = Conexion.getConex().conectarMySQL();
            preparedSt = connection.prepareStatement(query);
            
            preparedSt.setString(1, String.valueOf(casaCambios.getCasa().getMtsCuadrados()));
            preparedSt.setString(2, Cliente.getInstance().getCedula());
            preparedSt.setString(3, String.valueOf(casaCambios.getCasa().getNumPlantas()));
            if(casaCambios.getCasa().isEsEsquinera()){
                preparedSt.setString(4,"1");
            }else{
                preparedSt.setString(4,"0");
            }
            preparedSt.setString(5, casaCambios.getCasa().getOrientacion());
            preparedSt.setString(6, casaCambios.getCasa().getTmnPatio());
            preparedSt.setString(7, String.valueOf(casaCambios.getCasa().getNumHabitaciones()));
            preparedSt.setString(8, String.valueOf(casaCambios.getCasa().getNumBanios()));
            preparedSt.setString(9, String.valueOf(casaCambios.obtenerPresupuesto()));
            
            int r = preparedSt.executeUpdate();
            if(r>0){
                
               this.executeElementsInsertInHouse(this.obtenerIdsCasa("select max(idCasa) from Casas where cliente = '"+Cliente.getInstance().getCedula()+"';"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void executeElementsInsertInHouse(String idCasa){

        if(casaCambios.getCasa().isAislanteTérmicoEnTecho()){
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"12"); 
        }
        if(casaCambios.getCasa().isBañosInsonorizados())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"11");
        
        if(casaCambios.getCasa().isLed())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"10");
        
        if(casaCambios.getCasa().isIluminaciónTradicional())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"9");
        
        if(casaCambios.getCasa().isGriferíaItaliana())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"8");
        
        if(casaCambios.getCasa().isGriferíaEstándar())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"7");
        
        if(casaCambios.getCasa().isPisosPorcelanatoImportado())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"6");
        if(casaCambios.getCasa().isPisosPorcelanatoNacional())
            this.executUnionElementHouse("insert into Elementos_casa (Casa,Elemento) values(?,?);",idCasa,"5");
    }
    private void executUnionElementHouse(String query,String idCasa,String idElemento){
        try {
            connection = Conexion.getConex().conectarMySQL();
            preparedSt = connection.prepareStatement(query);
            preparedSt.setString(1,idCasa);
            preparedSt.setString(2,idElemento);
            preparedSt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String obtenerIdsCasa(String query){
        try {
            res = this.executeQuery(query);

                if(res.next()){
                    return res.getString("max(idCasa)");
                }
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
}
