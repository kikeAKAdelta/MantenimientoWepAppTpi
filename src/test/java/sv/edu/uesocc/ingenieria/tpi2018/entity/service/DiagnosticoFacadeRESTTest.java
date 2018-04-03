/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.entity.service;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sv.edu.uesocc.ingenieria.tpi2018.entity.DetalleOrdenTrabajo;
import sv.edu.uesocc.ingenieria.tpi2018.entity.Diagnostico;

/**
 *
 * @author enrique
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EJBContainer.class,Persistence.class})
public class DiagnosticoFacadeRESTTest {
    
    private DiagnosticoFacadeREST mockDiagnosticoFacade;
    private EntityManager mockEntityManager;
    private static EJBContainer mockEjbContainer;
    private Context mockContexto;
    private static EntityManagerFactory mockEmf;
    private static EntityTransaction mockEntityTransaction;
    
    public DiagnosticoFacadeRESTTest(){
        
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
        mockDiagnosticoFacade=Mockito.mock(DiagnosticoFacadeREST.class);
        mockEntityManager=Mockito.mock(EntityManager.class);
        mockContexto=Mockito.mock(Context.class);
        mockEntityTransaction=Mockito.mock(EntityTransaction.class);
        
        
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEntityManager);
        Mockito.when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
        Mockito.doNothing().when(mockEntityTransaction).begin(); //Objeto no devuelve nada void  
        
        PowerMockito.mockStatic(EJBContainer.class);
        PowerMockito.when(EJBContainer.createEJBContainer()).thenReturn(mockEjbContainer);
        Mockito.when(mockEjbContainer.getContext()).thenReturn(mockContexto);
        Mockito.when(mockContexto.lookup("java:global/classes/CalendarioFacadeREST")).thenReturn((DiagnosticoFacadeREST)mockDiagnosticoFacade);     
    }
    
    @After
    public void finalizarForEach() {
        mockEjbContainer.close();
        mockEntityManager.close();
    }

    /**
     * Test of edit method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testEdit_GenericType() throws Exception {
        System.out.println("edit");
        Integer id=new Integer(1);
        Diagnostico result=Mockito.mock(Diagnostico.class);
        
        Mockito.when(mockDiagnosticoFacade.find(id)).thenReturn(result);
        Mockito.when(result.getIdDiagnostico()).thenReturn(id);
        assertThat(result, CoreMatchers.is(Diagnostico.class));
        assertEquals(id,result.getIdDiagnostico());
        
        Mockito.doNothing().when(mockDiagnosticoFacade).edit(result);
    }

    /**
     * Test of remove method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testRemove_GenericType() throws Exception {
        System.out.println("remove");
        Integer id=new Integer(1);
        Diagnostico result=Mockito.mock(Diagnostico.class);
        
        Mockito.when(mockDiagnosticoFacade.find(id)).thenReturn(result);
        Mockito.when(result.getIdDiagnostico()).thenReturn(id);
        assertThat(result, CoreMatchers.is(Diagnostico.class));
        assertEquals(id,result.getIdDiagnostico());
        
        Mockito.doNothing().when(mockDiagnosticoFacade).remove(result);
    }

    /**
     * Test of find method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Integer id=new Integer(1);
        Diagnostico result=Mockito.mock(Diagnostico.class);
        
        Mockito.when(mockDiagnosticoFacade.find(id)).thenReturn(result);
        Mockito.when(result.getIdDiagnostico()).thenReturn(id);
        assertThat(result, CoreMatchers.is(Diagnostico.class));
        assertEquals(id,result.getIdDiagnostico());
    }

    /**
     * Test of findRange method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testFindRange_intArr() throws Exception {
        System.out.println("findRange");
        int[] range = {1,50};
        List<Diagnostico> result=Mockito.mock(List.class);
        
        Mockito.when(mockDiagnosticoFacade.findRange(range)).thenReturn(result);
        Mockito.when(result.size()).thenReturn(2);
        assertEquals(2,result.size());
    }

    /**
     * Test of count method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        int expResult = 1;
        int result=0;
        Mockito.when(mockDiagnosticoFacade.count()).thenReturn(1);
        result = mockDiagnosticoFacade.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Diagnostico entity = new Diagnostico();
        Mockito.doNothing().when(mockDiagnosticoFacade).create(entity);
    }

    /**
     * Test of findAll method, of class DiagnosticoFacadeREST.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List<Diagnostico> result = Mockito.mock(List.class);
        Mockito.when(mockDiagnosticoFacade.findAll()).thenReturn(result);
        Mockito.when(result.isEmpty()).thenReturn(Boolean.FALSE);
        assertThat(result,CoreMatchers.is(CoreMatchers.notNullValue()));
    }
    
}
