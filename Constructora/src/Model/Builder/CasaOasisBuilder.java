/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Controller.DataBase;
import Model.Casa;
import java.sql.SQLException;

/**
 *
 * @author GaryBarzola
 */
public class CasaOasisBuilder extends CasaBuilder{
    
    
    @Override
    public void definirCasaBase(){
        casa = new Casa(this.getClass().getName());
        try {
            res = DataBase.getDataB().executeQuery("SELECT * FROM Casas where idCasa = 3");
            if (res.next()) {
                 
            casa.setMtsCuadrados(Double.parseDouble(res.getString("Metros_cuadrados")));
            casa.setNumPlantas(Integer.parseInt(res.getString("NumPlantas")));
            System.out.println("lo de esquinera "+res.getString("Esquinera"));
            casa.setEsEsquinera(Boolean.getBoolean(res.getString("Esquinera"))); //aqui un errordeberia ser boolean true
            casa.setNumHabitaciones(Integer.parseInt(res.getString("NumHabitaciones")));
            casa.setNumBanios(Integer.parseInt(res.getString("numBanios")));
            casa.setPrecio_base(Double.parseDouble(res.getString("Precio")));
            } else {
                util.Util.mostrarDialogAlert("Fallo en la conexion para casaCielo");
                
            }
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
        
        //casa = new Casa(this.getClass().getName());
        //casa.setNumHabitaciones(2);
        //añadir caracterisitcas a nuestra conveniencia
    }


    @Override
    public void definirExtras() {
        //deberia agregarlos el cliente
    }
}
