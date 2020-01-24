/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator.ImplementacionDiego;


import Model.Builder.CasaDirector;


/**
 *
 * @author Lenovo comp
 */
public class Decoracion implements Decor{
    private String nombre;
    private CasaDirector casa;
    //private ElementoDecorator decorator;
    
    
    public Decoracion(String nombre,CasaDirector casa){
        this.nombre = nombre;
        this.casa = casa;
    }

    @Override
    public String getTipo() {
        return this.nombre;
    }

    @Override
    public double obtenerPresupuesto() {
        return this.casa.getCasa().getPrecioBase();
    }
    
    public Decor obtenerElemento(){
        if(nombre.equals("Techo con aislante térmico ")){
            System.out.println("entro a techoAis con espacio");
            return new TechoAislanteTermico(this);
        }else if(nombre.equals("Piso Porcelanato Nacional")){
            System.out.println("falta implementar");
        }
        /*
        faltaria para los demas elementos para cada caso
        */
        return null;
    }
    
    
}
