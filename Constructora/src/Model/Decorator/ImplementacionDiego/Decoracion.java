/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Decorator.ImplementacionDiego;


import Model.Builder.CasaDirector;


/**
 *
 * @author Diego Rojas
 */
public class Decoracion implements Decor{
    private String nombre;
    private CasaDirector casa;
    private double precio;
    //private ElementoDecorator decorator;
    
    
    public Decoracion(String nombre,CasaDirector casa){
        this.nombre = nombre;
        this.casa = casa;
        this.precio = casa.getCasa().getPrecioBase();
    }

    @Override
    public String getTipo() {
        return this.nombre;
    }

    @Override
    public double obtenerPresupuesto() {
        //return this.casa.getCasa().getPrecioBase();
        return this.precio;
    }
    /*
    public Decor obtenerElemento(){
        if(nombre.equals("Techo con aislante térmico ")){
            return new TechoAislanteTermico(this);
        }else if(nombre.equals("Piso Porcelanato Nacional")){
            return new PisoPorcelanatoNacional(this);
        }else if(nombre.equals("Piso Porcelanato importado")){
            return new PisoPorcelanatoImportado(this);
        }else if(nombre.equals("grifería estándar")){ 
            return new GrafiteriaEstandar(this);
        }else if(nombre.equals("grifería Italiana")){
            return new GrafiteriaItaliana(this);
        }else if(nombre.equals("iluminación tradicional ")){
            return new IluminacionTradicional(this);
        }else if(nombre.equals("iluminación led ")){
            return new Led(this);       
        }else if(nombre.equals("baños insonorizados")){
            return new BañosInsonorizados(this);
        }else if(nombre.equals("Techo con aislante térmico ")){
            return new TechoAislanteTermico(this);
        
        }
            
        
        return null;
    }*/
    
    
}
