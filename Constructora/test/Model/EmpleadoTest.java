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
public class EmpleadoTest {
    
    public EmpleadoTest() {
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
     * Test of getInstance method, of class Empleado.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Empleado expResult = null;
        Empleado result = Empleado.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarDatosEmpleado method, of class Empleado.
     */
    @Test
    public void testCargarDatosEmpleado() {
        System.out.println("cargarDatosEmpleado");
        String cedula = "";
        Empleado.cargarDatosEmpleado(cedula);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCargo method, of class Empleado.
     */
    @Test
    public void testGetCargo() {
        System.out.println("getCargo");
        Empleado instance = null;
        String expResult = "";
        String result = instance.getCargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCargo method, of class Empleado.
     */
    @Test
    public void testSetCargo() {
        System.out.println("setCargo");
        String cargo = "";
        Empleado instance = null;
        instance.setCargo(cargo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTlf_trabajo method, of class Empleado.
     */
    @Test
    public void testGetTlf_trabajo() {
        System.out.println("getTlf_trabajo");
        Empleado instance = null;
        String expResult = "";
        String result = instance.getTlf_trabajo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTlf_trabajo method, of class Empleado.
     */
    @Test
    public void testSetTlf_trabajo() {
        System.out.println("setTlf_trabajo");
        String tlf_trabajo = "";
        Empleado instance = null;
        instance.setTlf_trabajo(tlf_trabajo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRol method, of class Empleado.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Empleado instance = null;
        String expResult = "";
        String result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
