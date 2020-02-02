/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator;

import Model.Casa;

/**
 *
 * @author Lenovo comp
 */
public class GrafiteriaEstandar extends ElementoDecorator{

    public GrafiteriaEstandar(Decor decorable) {
        super(decorable);
    }    
    @Override
    public double obtenerPresupuesto() {
        return getDecorable().obtenerPresupuesto()+50;
    }

    @Override
    public Casa getCasa() {
        return getDecorable().getCasa();
    }
   

}
