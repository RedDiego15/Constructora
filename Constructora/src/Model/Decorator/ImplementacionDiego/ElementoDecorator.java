/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator.ImplementacionDiego;

import Model.Decorator.ImplementacionDiego.Decor;
import Model.Casa;

/**
 *
 * @author Lenovo comp
 */
public abstract class ElementoDecorator implements Decor {
    private Decor decorable;
    
    public ElementoDecorator(Decor decorable){
        this.decorable = decorable;
    }

    public Decor getDecorable() {
        return decorable;
    }

   
    
    @Override
    public String getTipo() {
        return this.getDecorable().getTipo();
    }

    @Override
    public double obtenerPresupuesto() {
        return getDecorable().obtenerPresupuesto();
    }
    
    
    
    
}
