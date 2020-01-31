/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Casa;
import Model.Decorator.ImplementacionDiego.Decor;

/**
 *
 * @author GaryBarzola
 */
public class CasaDirector implements Decor{
    
    private CasaBuilder builder;

    public CasaDirector(CasaBuilder builder) {
        this.builder = builder;
    }
    
    public void construirCasa(){
        builder.definirCasaBase();
        builder.definirExtras();
    }
    
    public Casa getCasa(){
        return builder.getCasa();
    }
    
         //@Override
    public String getDescripcion() {
        return this.toString();
    }

    @Override
    public String getTipo() {
        return builder.getCasa().getName();
    }

    @Override
    public double obtenerPresupuesto() {
        return builder.getCasa().getPrecioBase();
    }
    
}
