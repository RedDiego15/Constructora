/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import java.util.List;

/**
 *
 * @author GaryBarzola
 */
public interface ICRUDDao {	
    
    public boolean registrar(Cliente cliente);
    public List<Cliente> obtenerClientes();
    public boolean actualizar(Cliente cliente);
    public boolean eliminar(Cliente cliente);

}
