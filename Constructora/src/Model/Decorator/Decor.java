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
public interface Decor {
    
    public String getTipo();
    
    public double obtenerPresupuesto();
    
    public Casa getCasa();
       
}
