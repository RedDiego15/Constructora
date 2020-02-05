/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GaryBarzola
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Cliente.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Cliente expResult = null;
        Cliente result = Cliente.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarDatosCliente method, of class Cliente.
     */
    @Test
    public void testCargarDatosCliente() {
        System.out.println("cargarDatosCliente");
        String cedula = "";
        Cliente.cargarDatosCliente(cedula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaInstanciado method, of class Cliente.
     */
    @Test
    public void testEstaInstanciado() {
        System.out.println("estaInstanciado");
        boolean expResult = false;
        boolean result = Cliente.estaInstanciado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEmpresa method, of class Cliente.
     */
    @Test
    public void testGetIdEmpresa() {
        System.out.println("getIdEmpresa");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getIdEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargo method, of class Cliente.
     */
    @Test
    public void testGetCargo() {
        System.out.println("getCargo");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumHijos method, of class Cliente.
     */
    @Test
    public void testGetNumHijos() {
        System.out.println("getNumHijos");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getNumHijos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEmpresa method, of class Cliente.
     */
    @Test
    public void testSetIdEmpresa() {
        System.out.println("setIdEmpresa");
        String idEmpresa = "";
        Cliente instance = null;
        instance.setIdEmpresa(idEmpresa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargo method, of class Cliente.
     */
    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        String cargo = "";
        Cliente instance = null;
        instance.setCargo(cargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumHijos method, of class Cliente.
     */
    @Test
    public void testSetNumHijos() {
        System.out.println("setNumHijos");
        String NumHijos = "";
        Cliente instance = null;
        instance.setNumHijos(NumHijos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCedula method, of class Cliente.
     */
    @Test
    public void testGetCedula() {
        System.out.println("getCedula");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getCedula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Cliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class Cliente.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCelular method, of class Cliente.
     */
    @Test
    public void testGetCelular() {
        System.out.println("getCelular");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getCelular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCorreo method, of class Cliente.
     */
    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoCivil method, of class Cliente.
     */
    @Test
    public void testGetEstadoCivil() {
        System.out.println("getEstadoCivil");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getEstadoCivil();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasaporte method, of class Cliente.
     */
    @Test
    public void testGetPasaporte() {
        System.out.println("getPasaporte");
        Cliente instance = null;
        String expResult = "";
        String result = instance.getPasaporte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
