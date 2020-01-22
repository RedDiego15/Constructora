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
public class Casa implements Decorable{
    
    protected int mtsCuadrados;
    protected int  numPlantas;
    protected boolean esEsquinera;
    protected boolean  PatioGrande;
    protected int numHabitaciones;
    protected int numBanios;
    protected int PrecioBase;
    protected String name;
    protected float precio_base;
    
    public Casa(String tipo){
        this.name=tipo;
    }

    public int getMtsCuadrados() {
        return mtsCuadrados;
    }

    public int getNumPlantas() {
        return numPlantas;
    }

    public boolean isEsEsquinera() {
        return esEsquinera;
    }

    public boolean isPatioGrande() {
        return PatioGrande;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public int getPrecioBase() {
        return PrecioBase;
    }

    public String getName() {
        return name;
    }

    public float getPrecio_base() {
        return precio_base;
    }

    public void setMtsCuadrados(int mtsCuadrados) {
        this.mtsCuadrados = mtsCuadrados;
    }

    public void setNumPlantas(int numPlantas) {
        this.numPlantas = numPlantas;
    }

    public void setEsEsquinera(boolean esEsquinera) {
        this.esEsquinera = esEsquinera;
    }

    public void setPatioGrande(boolean PatioGrande) {
        this.PatioGrande = PatioGrande;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public void setPrecioBase(int PrecioBase) {
        this.PrecioBase = PrecioBase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrecio_base(float precio_base) {
        this.precio_base = precio_base;
    }

    

    @Override
    public String getDescripcion() {
        return this.toString();
    }

    @Override
    public String getTipo() {
        return this.name;
    }

    @Override
    public float obtenerPresupuesto() {
        return this.PrecioBase;
    }
    
    
}
