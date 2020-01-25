/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator.ImplementacionDiego;

import Model.Decorator.ImplementacionDiego.ElementoDecorator;
import Model.Decorator.ImplementacionDiego.Decor;
import Model.Casa;

/**
 *
 * @author Lenovo comp
 */
public class TechoAislanteTermico extends ElementoDecorator{

    public TechoAislanteTermico(Decor decorable) {
        super(decorable);
    }
    
    
    
    @Override
    public double obtenerPresupuesto() {
        return getDecorable().obtenerPresupuesto()+500;
    }
    
}
