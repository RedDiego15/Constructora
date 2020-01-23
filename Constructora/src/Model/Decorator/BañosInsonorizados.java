/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator;

import Model.Casa;

/**
 *
 * @author GaryBarzola
 */
public class BañosInsonorizados extends CasaDecorator{
    
    public BañosInsonorizados(Casa casa){
        super(casa);
    }

    @Override
    public String getTipo(){
        return getCasa().getTipo();
    }
    
    @Override
    public String getDescripcion(){
        getCasa().setBañosInsonorizados(true);
        return getCasa().getDescripcion();
    }

    @Override
    public double obtenerPresupuesto(){
        return getCasa().obtenerPresupuesto()+30;
    }
    
}
