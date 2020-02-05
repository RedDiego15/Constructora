/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
public class LoginTest {
    
    public LoginTest() {
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
     * Test of accionIngresar method, of class Login.
     */
    @Test
    public void testAccionIngresar() {
        System.out.println("accionIngresar");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.accionIngresar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaPass method, of class Login.
     */
    @Test
    public void testValidaPass() throws Exception {
        System.out.println("validaPass");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.validaPass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerRol method, of class Login.
     */
    @Test
    public void testObtenerRol() {
        System.out.println("obtenerRol");
        Login instance = null;
        int expResult = 0;
        int result = instance.obtenerRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerNombreCliente method, of class Login.
     */
    @Test
    public void testObtenerNombreCliente() {
        System.out.println("obtenerNombreCliente");
        Login instance = null;
        String expResult = "";
        String result = instance.obtenerNombreCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
