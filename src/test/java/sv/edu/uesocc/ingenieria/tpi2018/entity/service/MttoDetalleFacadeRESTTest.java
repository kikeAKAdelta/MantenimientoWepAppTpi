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
import sv.edu.uesocc.ingenieria.tpi2018.entity.ExcepcionCalendario;
import sv.edu.uesocc.ingenieria.tpi2018.entity.MttoDetalle;

/**
 *
 * @author enrique
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EJBContainer.class,Persistence.class})
public class MttoDetalleFacadeRESTTest {
    
    public MttoDetalleFacadeRESTTest() {
    }
    
    private MttoDetalleFacadeREST mockMttoDetalleFacadeREST;
    private EntityManager mockEntityManager;
    private static EJBContainer mockEjbContainer;
    private Context mockContexto;
    private static EntityManagerFactory mockEmf;
    private static EntityTransaction mockEntityTransaction;
    
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
        mockMttoDetalleFacadeREST=Mockito.mock(MttoDetalleFacadeREST.class);
        mockEntityManager=Mockito.mock(EntityManager.class);
        mockContexto=Mockito.mock(Context.class);
        mockEntityTransaction=Mockito.mock(EntityTransaction.class);
        
        
        Mockito.when(mockEmf.createEntityManager()).thenReturn(mockEntityManager);
        Mockito.when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
        Mockito.doNothing().when(mockEntityTransaction).begin(); //Objeto no devuelve nada void  
        
        PowerMockito.mockStatic(EJBContainer.class);
        PowerMockito.when(EJBContainer.createEJBContainer()).thenReturn(mockEjbContainer);
        Mockito.when(mockEjbContainer.getContext()).thenReturn(mockContexto);
        Mockito.when(mockContexto.lookup("java:global/classes/CalendarioFacadeREST")).thenReturn((MttoDetalleFacadeREST)mockMttoDetalleFacadeREST);     
    }
    
    @After
    public void finalizarForEach() {
        mockEjbContainer.close();
        mockEntityManager.close();
    }

    /**
     * Test of edit method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testEdit_GenericType() throws Exception {
        System.out.println("edit");
        Integer id=new Integer(1);
        MttoDetalle result=Mockito.mock(MttoDetalle.class);
        
        Mockito.when(mockMttoDetalleFacadeREST.find(id)).thenReturn(result);
        Mockito.when(result.getIdMttoDetalle()).thenReturn(id);
        assertThat(result, CoreMatchers.is(MttoDetalle.class));
        assertEquals(id,result.getIdMttoDetalle());
        
        Mockito.doNothing().when(mockMttoDetalleFacadeREST).edit(result);
    }

    /**
     * Test of remove method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testRemove_GenericType() throws Exception {
        System.out.println("remove");
        Integer id=new Integer(1);
        MttoDetalle result=Mockito.mock(MttoDetalle.class);
        
        Mockito.when(mockMttoDetalleFacadeREST.find(id)).thenReturn(result);
        Mockito.when(result.getIdMttoDetalle()).thenReturn(id);
        assertThat(result, CoreMatchers.is(MttoDetalle.class));
        assertEquals(id,result.getIdMttoDetalle());
        
        Mockito.doNothing().when(mockMttoDetalleFacadeREST).remove(result);
    }

    /**
     * Test of find method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testFind_Object() throws Exception {
        System.out.println("find");
        Integer id=new Integer(1);
        MttoDetalle result=Mockito.mock(MttoDetalle.class);
        
        Mockito.when(mockMttoDetalleFacadeREST.find(id)).thenReturn(result);
        Mockito.when(result.getIdMttoDetalle()).thenReturn(id);
        assertThat(result, CoreMatchers.is(MttoDetalle.class));
        assertEquals(id,result.getIdMttoDetalle());
    }

    /**
     * Test of findRange method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testFindRange_intArr() throws Exception {
        System.out.println("findRange");
        int[] range = {1,50};
        List<MttoDetalle> result=Mockito.mock(List.class);
        
        Mockito.when(mockMttoDetalleFacadeREST.findRange(range)).thenReturn(result);
        Mockito.when(result.size()).thenReturn(2);
        assertEquals(2,result.size());
    }

    /**
     * Test of count method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        int expResult = 1;
        int result=0;
        Mockito.when(mockMttoDetalleFacadeREST.count()).thenReturn(1);
        result = mockMttoDetalleFacadeREST.count();
        assertEquals(expResult, result);
    }

    /**
     * Test of create method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        MttoDetalle entity = new MttoDetalle();
        Mockito.doNothing().when(mockMttoDetalleFacadeREST).create(entity);
    }


    /**
     * Test of findAll method, of class MttoDetalleFacadeREST.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        List<MttoDetalle> result = Mockito.mock(List.class);
        Mockito.when(mockMttoDetalleFacadeREST.findAll()).thenReturn(result);
        Mockito.when(result.isEmpty()).thenReturn(Boolean.FALSE);
        assertThat(result,CoreMatchers.is(CoreMatchers.notNullValue()));
    }
    
}
