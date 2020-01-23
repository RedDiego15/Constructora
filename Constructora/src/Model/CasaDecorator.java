/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Decorator.Decorable;

/**
 *
 * @author CltControl
 */
public abstract class CasaDecorator implements Decorable {
    private Casa casa;
    
    public CasaDecorator(Casa casa){
        this.casa = casa;
    }
    
    public Casa getCasa(){
        return this.casa;
    }
    
    public void setCasa(Casa casa){
        this.casa = casa;
    }
    
    public String obtenerTipo(){
        return getCasa().getClass().getName();
    }
    

    public String getDescripcion(){
        return getCasa().getDescripcion();
    }
    

    public double obtenerPresupuesto(){
        return getCasa().obtenerPresupuesto();
    }
    
    public void setMtsCuadrados(int mtsCuadrados) {
        this.casa.mtsCuadrados = mtsCuadrados;
    }

    public void setNumPlantas(int numPlantas) {
        this.casa.numPlantas = numPlantas;
    }

    public void setEsEsquinera(boolean esEsquinera) {
        this.casa.esEsquinera = esEsquinera;
    }

    public void setPatioGrande(boolean PatioGrande) {
        this.casa.PatioGrande = PatioGrande;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.casa.numHabitaciones = numHabitaciones;
    }

    public void setNumBanios(int numBanios) {
        this.casa.numBanios = numBanios;
    }

    public void setPrecioBase(int PrecioBase) {
        this.casa.PrecioBase = PrecioBase;
    }

    public void setName(String name) {
        this.casa.name = name;
    }

    public void setPrecio_base(float precio_base) {
        this.casa.precio_base = precio_base;
    }
}
