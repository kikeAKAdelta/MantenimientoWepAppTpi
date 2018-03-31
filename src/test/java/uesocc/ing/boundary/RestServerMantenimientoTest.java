/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.ing.boundary;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import uesocc.ingenieria.pojosMantenimiento.*;


/**
 *
 * @author enrique
 */
@RunWith(PowerMockRunner.class)
public class RestServerMantenimientoTest {
    
    final Response mockResponse = Mockito.mock(Response.class);
    final Response mockResponse1 = Mockito.mock(Response.class);
    
    
    public RestServerMantenimientoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before  
    public void inicializar(){
        Mockito.when(mockResponse.getStatus()).thenReturn(Response.Status.OK.getStatusCode(),Response.Status.CREATED.getStatusCode());
        Mockito.when(mockResponse1.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEntidad method, of class RestServerMantenimiento.
     */
    @Test
    public void testGetEntidad() {
        System.out.println("getEntidad");
        Marca entidad = new Marca(1,"hola");
        RestServerMantenimiento instance = new RestServerMantenimiento();
        int expResult = mockResponse.getStatus();
        int result = instance.getEntidad(entidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of postEntidad method, of class RestServerMantenimiento.
     */
    @Test
    public void testPostEntidad() {
        System.out.println("postEntidad");
        Modelo entidad = new Modelo(1,"hp");
        RestServerMantenimiento instance = new RestServerMantenimiento();
        int expResult = mockResponse1.getStatus();
        int result = instance.postEntidad(entidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of putEntidad method, of class RestServerMantenimiento.
     */
    @Test
    public void testPutEntidad() {
        System.out.println("putEntidad");
        Marca entidad = new Marca(3,"five");
        RestServerMantenimiento instance = new RestServerMantenimiento();
        int expResult = mockResponse1.getStatus();
        int result = instance.putEntidad(entidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEntidad method, of class RestServerMantenimiento.
     */
    @Test
    public void testDeleteEntidad() {
        System.out.println("deleteEntidad");
        Marca entidad =new Marca(4,"alv") ;
        RestServerMantenimiento instance = new RestServerMantenimiento();
        int expResult = mockResponse.getStatus();
        int result = instance.deleteEntidad(entidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
