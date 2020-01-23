/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Casa;

import Controller.DataBase;
import java.sql.SQLException;

/**
 *
 * @author GaryBarzola
 */
public class CasaCieloBuilder extends CasaBuilder{
    
    

    @Override
    public void definirCasaBase(){
        casa = new Casa(this.getClass().getName());
        obtenerInfoQuerysCasa(1);
        
        
       /* 
        casa = new Casa(this.getClass().getName());
        casa.setNumHabitaciones(4);*/
        //añadir caracterisitcas a nuestra conveniencia
    }


    @Override
    public void definirExtras() {
         //deberia agregarlos el cliente
    }
}
