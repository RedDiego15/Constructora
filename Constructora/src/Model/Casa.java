/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Model.Decorator.Decor;

/**
 *
 * @author GaryBarzola
 */
public class Casa{
    

    protected double mtsCuadrados;

    protected String name;    
    protected int  numPlantas;
    protected int numHabitaciones;
    protected int numBanios;
    protected double PrecioBase; //precio final despues de anadirle mas cosas
    protected boolean esEsquinera;
    protected boolean  PatioGrande;
    protected String orientacion;
    protected String tmnPatio;
    
    protected boolean pisosPorcelanatoNacional;
    protected boolean pisosPorcelanatoImportado;
    protected boolean griferíaEstándar;
    protected boolean griferíaItaliana;
    protected boolean iluminaciónTradicional;
    protected boolean led; 
    protected boolean bañosInsonorizados; 
    protected boolean aislanteTérmicoEnTecho;
    
    public Casa(String tipo){
        this.name=tipo;
    }

    public double getMtsCuadrados() {
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


    public double getPrecioBase() {
        return PrecioBase;
    }

    public String getName() {
        return name;
    }


    public void setMtsCuadrados(double mtsCuadrados) {
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
    public void setPrecioBase(double PrecioBase) {
        this.PrecioBase = PrecioBase;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPisosPorcelanatoNacional(boolean pisosPorcelanatoNacional) {
        this.pisosPorcelanatoNacional = pisosPorcelanatoNacional;
    }

    public void setPisosPorcelanatoimportado(boolean pisosPorcelanatoimportado) {
        this.pisosPorcelanatoImportado = pisosPorcelanatoimportado;
    }

    public void setGriferíaEstándar(boolean griferíaEstándar) {
        this.griferíaEstándar = griferíaEstándar;
    }

    public void setGriferíaitaliana(boolean griferíaitaliana) {
        this.griferíaItaliana = griferíaitaliana;
    }

    public void setIluminaciónTradicional(boolean iluminaciónTradicional) {
        this.iluminaciónTradicional = iluminaciónTradicional;
    }

    public void setLed(boolean led) {
        this.led = led;
    }

    public void setBañosInsonorizados(boolean bañosInsonorizados) {
        this.bañosInsonorizados = bañosInsonorizados;
    }

    public void setAislanteTérmicoEnTecho(boolean aislanteTérmicoEnTecho) {
        this.aislanteTérmicoEnTecho = aislanteTérmicoEnTecho;
    }
    public boolean isPisosPorcelanatoNacional() {
        return pisosPorcelanatoNacional;
    }

    public boolean isPisosPorcelanatoImportado() {
        return pisosPorcelanatoImportado;
    }

    public boolean isGriferíaEstándar() {
        return griferíaEstándar;
    }

    public boolean isGriferíaItaliana() {
        return griferíaItaliana;
    }

    public boolean isIluminaciónTradicional() {
        return iluminaciónTradicional;
    }

    public boolean isLed() {
        return led;
    }

    public boolean isBañosInsonorizados() {
        return bañosInsonorizados;
    }

    public boolean isAislanteTérmicoEnTecho() {
        return aislanteTérmicoEnTecho;
    }
      public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getTmnPatio() {
        return tmnPatio;
    }

    public void setTmnPatio(String tmnPatio) {
        this.tmnPatio = tmnPatio;
    }
    
    
}
