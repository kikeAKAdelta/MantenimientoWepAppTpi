/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity.service;

import java.util.List;
import javafx.beans.binding.When;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.stream.events.Comment;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sv.edu.uesocc.ingenieria.tpi2018.entity.Calendario;

/**
 *
 * @author enrique
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EJBContainer.class,Persistence.class})
public class CalendarioFacadeRESTTest {
    
    private CalendarioFacadeREST mockCalendarioFacade;
    private EntityManager mockEntityManager;
    private static EJBContainer mockEjbContainer;
    private Context mockContexto;
    private static EntityManagerFactory mockEmf;
    private static EntityTransaction mockEntityTransaction;
    
    
    public CalendarioFacadeRESTTest() {
    }
    
    @BeforeClass
    public static void inicializarForAll() {
        mockEmf=Mockito.mock(EntityManagerFactory.class);
        PowerMockito.mockStatic(Persistence.class);
        PowerMockito.when(Persistence.createEntityManagerFactory("Mantenimiento")).thenReturn(mockEmf);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        mockEmf.close();
    }
    
    @Before
    public void inicializarForEach() throws Exception {
        mockEjbContainer=Mockito.mock(EJBContainer.class);
        mockCalendarioFacade=Mockito.mock(CalendarioFacadeREST.class);
        mockEntityManager=Mockito.mock(EntityManager.class);
        mockContexto=Mockito.mock(Context.class);
        mockEntityTransaction=Mockito.mock(EntityTransaction.class);
        
        
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEntityManager);
        Mockito.when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
        Mockito.doNothing().when(mockEntityTransaction).begin(); //Objeto no devuelve nada void  
        
        PowerMockito.mockStatic(EJBContainer.class);
        PowerMockito.when(EJBContainer.createEJBContainer()).thenReturn(mockEjbContainer);
        Mockito.when(mockEjbContainer.getContext()).thenReturn(mockContexto);
        Mockito.when(mockContexto.lookup("java:global/classes/CalendarioFacadeREST")).thenReturn((CalendarioFacadeREST)mockCalendarioFacade);     
    }
    
    @After
    public void finalizarForEach() {
        mockEjbContainer.close();
        mockEntityManager.close();
    }


    /**
     * Test of find method, of class CalendarioFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Integer id=new Integer(1);
        Calendario result=Mockito.mock(Calendario.class);
        
        Mockito.when(mockCalendarioFacade.find(id)).thenReturn(result);
        Mockito.when(result.getIdCalendario()).thenReturn(id);
        assertThat(result, CoreMatchers.is(Calendario.class));
        assertEquals(id,result.getIdCalendario());
    }

    /**
     * Test of findRange method, of class CalendarioFacadeREST.
     */
    @Test
    public void testFindRange_intArr() throws Exception {
        System.out.println("findRange");
        int[] range = {1,50};
        List<Calendario> result=Mockito.mock(List.class);
        
        Mockito.when(mockCalendarioFacade.findRange(range)).thenReturn(result);
        Mockito.when(result.size()).thenReturn(2);
        assertEquals(2,result.size());
        
    }

    /**
     * Test of count method, of class CalendarioFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        int expResult = 1;
        int result=0;
        Mockito.when(mockCalendarioFacade.count()).thenReturn(1);
        result = mockCalendarioFacade.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class CalendarioFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Calendario entity = new Calendario();
        Mockito.doNothing().when(mockCalendarioFacade).create(entity);
    }

    /**
     * Test of edit method, of class CalendarioFacadeREST.
     */
    @Test
    public void testEdit_Integer() throws Exception {
        System.out.println("edit");
        Integer id=new Integer(1);
        Calendario result=Mockito.mock(Calendario.class);
        
        Mockito.when(mockCalendarioFacade.find(id)).thenReturn(result);
        Mockito.when(result.getIdCalendario()).thenReturn(id);
        assertThat(result, CoreMatchers.is(Calendario.class));
        assertEquals(id,result.getIdCalendario());
        
        Mockito.doNothing().when(mockCalendarioFacade).edit(result);
    }

    /**
     * Test of remove method, of class CalendarioFacadeREST.
     */
    @Test
    public void testRemove_Integer() throws Exception {
        System.out.println("remove");
        Integer id=new Integer(1);
        Calendario result=Mockito.mock(Calendario.class);
        
        Mockito.when(mockCalendarioFacade.find(id)).thenReturn(result);
        Mockito.when(result.getIdCalendario()).thenReturn(id);
        assertThat(result, CoreMatchers.is(Calendario.class));
        assertEquals(id,result.getIdCalendario());
        
        Mockito.doNothing().when(mockCalendarioFacade).remove(result);
    }


    /**
     * Test of findAll method, of class CalendarioFacadeREST.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List<Calendario> result = Mockito.mock(List.class);
        Mockito.when(mockCalendarioFacade.findAll()).thenReturn(result);
        Mockito.when(result.isEmpty()).thenReturn(Boolean.FALSE);
        assertThat(result,CoreMatchers.is(CoreMatchers.notNullValue()));
    }

    
}
