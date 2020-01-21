/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author GaryBarzola
 */
public class CasaDirector {
    
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
}
