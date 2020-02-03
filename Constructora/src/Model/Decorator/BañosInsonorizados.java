/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator;

import Model.Casa;

/**
 *
 * @author  Diego Rojas
 */
public class BañosInsonorizados extends ElementoDecorator{

    public BañosInsonorizados(Decor decorable) {
        super(decorable);
    }
    
    @Override
    public double obtenerPresupuesto() {
       // this.getDecorable().getCasa().setBañosInsonorizados(true);
        return getDecorable().obtenerPresupuesto()+200;
    }

    @Override
    public Casa getCasa() {
        return getDecorable().getCasa();
    }

}
