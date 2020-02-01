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
public interface IClienteDao {	
    
    public boolean registrarCliente(Cliente cliente);
    public List<Cliente> obtenerClientes();
    public boolean actualizarCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);

}
