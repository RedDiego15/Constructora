/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator;

/**
 *
 * @author Lenovo comp
 */
public class PisoPorcelanatoImportado  extends ElementoDecorator{

    public PisoPorcelanatoImportado(Decor decorable) {
        super(decorable);
    }
     @Override
    public double obtenerPresupuesto() {
        return getDecorable().obtenerPresupuesto()+150;
    }
}
