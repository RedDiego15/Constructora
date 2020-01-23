/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Casa;

/**
 *
 * @author GaryBarzola
 */
public class CasaParaisoBuilder extends CasaBuilder{
    
    @Override
    public void definirCasaBase(){
        casa = new Casa(this.getClass().getName());
        obtenerInfoQuerysCasa(2);
        
        //casa = new Casa(this.getClass().getName());
        //casa.setNumHabitaciones(3);
        //añadir caracterisitcas a nuestra conveniencia
    }


    @Override
    public void definirExtras() {
         //deberia agregarlos el cliente
    }
}
