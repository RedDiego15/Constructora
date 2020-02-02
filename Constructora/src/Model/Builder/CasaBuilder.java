/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Builder;

import Controller.DataBase;
import Model.Casa;
import Model.Decorator.Decor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GaryBarzola
 */
public abstract class CasaBuilder{
    
    protected ResultSet res;
    
    protected Casa casa;
    
    public Casa getCasa(){
        return casa;
    }
    
    public abstract void definirCasaBase();
    public abstract void definirExtras();
    
    protected void obtenerInfoQuerysCasa(int id){
        try {
            res = DataBase.getDataB().executeQuery("SELECT * FROM Casas where idCasa="+id);
            if (res.next()) {
                 
            casa.setMtsCuadrados(Double.parseDouble(res.getString("Metros_cuadrados")));
            casa.setNumPlantas(Integer.parseInt(res.getString("NumPlantas")));
            System.out.println("lo de esquinera "+res.getString("Esquinera"));
            casa.setEsEsquinera(Boolean.getBoolean(res.getString("Esquinera"))); //aqui un errordeberia ser boolean true
            casa.setNumHabitaciones(Integer.parseInt(res.getString("NumHabitaciones")));
            casa.setNumBanios(Integer.parseInt(res.getString("numBanios")));
            casa.setPrecioBase(Double.parseDouble(res.getString("Precio")));
            casa.setOrientacion(res.getString("Orientacion"));
            casa.setTmnPatio(res.getString("TmnPatio"));
            //falta poner todas las cosas extra en false
            
            casa.setAislanteTérmicoEnTecho(false);
            casa.setGriferíaEstándar(false);
            casa.setGriferíaitaliana(false);
            casa.setIluminaciónTradicional(false);
            casa.setLed(false);
            casa.setPisosPorcelanatoNacional(false);
            casa.setPisosPorcelanatoimportado(false);
            casa.setAislanteTérmicoEnTecho(false);
            } else {
                util.Util.mostrarDialogAlert("Fallo en la conexion para casaCielo");
                
            }
        } catch (SQLException e) {
            util.Util.mostrarDialogAlert(e.getMessage());
        }
    }
    
}
