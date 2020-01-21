/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Diego Rojas
 */
public abstract class User {
    
    protected String cedula;
 //   private String contrasenia;
    protected String rol;
    
    protected String nombre;
    protected String apellido;
    protected String celular;
    protected String correo;
    protected String direccion;
    protected String cargo;
    protected String estadoCivil;

    public User(String cedula, String nombre, String apellido, String celular, String correo, String direccion, String cargo, String estadoCivil, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.cargo = cargo;
        this.estadoCivil = estadoCivil;
        this.rol = rol;
    }
    
    
}
