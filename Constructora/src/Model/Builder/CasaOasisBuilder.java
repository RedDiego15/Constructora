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
        obtenerInfoQuerysCasa(3);
        
        //casa = new Casa(this.getClass().getName());
        //casa.setNumHabitaciones(2);
        //añadir caracterisitcas a nuestra conveniencia
    }


    @Override
    public void definirExtras() {
        //deberia agregarlos el cliente
    }
}
