/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO.Cliente;

import Model.Cliente;
import Model.User;
import java.util.List;

/**
 *
 * @author GaryBarzola
 */
public interface ICRUDDao {	
    
    public boolean registrar(User cliente);
    public List<Cliente> obtenerClientes();
    public boolean actualizar(User cliente);
    public boolean eliminar(User cliente);
    public boolean crearUsuario(String cedula, String passport, String pass, String roll);

}
