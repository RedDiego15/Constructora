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
public class Empleado extends User{
    
    private String cargo;
    private String tlf_trabajo;

    public Empleado(String cedula, String pasaporte, String nombre, String apellido, String correo, String numCelular, String tlf, String estadoCivil, String cargo){        
        super(cedula,pasaporte,nombre,apellido,numCelular,correo,null,estadoCivil);  
        this.tlf_trabajo = tlf;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTlf_trabajo() {
        return tlf_trabajo;
    }

    public void setTlf_trabajo(String tlf_trabajo) {
        this.tlf_trabajo = tlf_trabajo;
    }
    
    public String getRol(){
        String rol="0";
        switch(cargo){
            case "Cliente":
                rol="0";
                break;
            case "Vendedor":
                rol="1";
                break;
            case "Administrador":
                rol="2";
                break;
        }
        return rol;
    }
    
    
    
            
}
