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
public class Casa {
    
    protected int mtsCuadrados;
    protected int  numPlantas;
    protected boolean esEsquinera;
    protected boolean  PatioGrande;
    protected int numHabitaciones;
    protected int numBanios;
    protected int PrecioBase;
    
    public Casa(){
        
    }

    public int getMtsCuadrados() {
        return mtsCuadrados;
    }

    public void setMtsCuadrados(int mtsCuadrados) {
        this.mtsCuadrados = mtsCuadrados;
    }

    public int getNumPlantas() {
        return numPlantas;
    }

    public void setNumPlantas(int numPlantas) {
        this.numPlantas = numPlantas;
    }

    public boolean isEsEsquinera() {
        return esEsquinera;
    }

    public void setEsEsquinera(boolean esEsquinera) {
        this.esEsquinera = esEsquinera;
    }

    public boolean isPatioGrande() {
        return PatioGrande;
    }

    public void setPatioGrande(boolean PatioGrande) {
        this.PatioGrande = PatioGrande;
    }

    public int isNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public int getPrecioBase() {
        return PrecioBase;
    }

    public void setPrecioBase(int PrecioBase) {
        this.PrecioBase = PrecioBase;
    }
    
    
}
