/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Model.Casa;

import java.sql.ResultSet;

/**
 *
 * @author GaryBarzola
 */
public abstract class CasaBuilder {
    
    protected ResultSet res;
    
    protected Casa casa;
    
    public Casa getCasa(){
        return casa;
    }
    
    public abstract void definirCasaBase();
    public abstract void definirExtras();
    
}
