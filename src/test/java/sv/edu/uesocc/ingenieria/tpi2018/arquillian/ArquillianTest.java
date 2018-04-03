/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.arquillian;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import sv.edu.uesocc.ingenieria.tpi2018.entity.Calendario;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.CalendarioFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.DetalleOrdenTrabajoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.DiagnosticoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.DiagnosticoParteFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.EquipoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.EstadoDetalleOrdenTrabajoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.EstadoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.ExcepcionCalendarioFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.MttoDetalleFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.OrdenTrabajoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.ParteFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.PasosFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.PasosProcedimientoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.PrioridadFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.ProcedimientoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.ResponsableFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.SolicitudFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.SubtipoMttoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.TipomttoFacadeREST;
import sv.edu.uesocc.ingenieria.tpi2018.entity.service.UnidadFacadeREST;

/**
 *
 * @author ricky
 */

@RunWith(Arquillian.class)
public class ArquillianTest {
    @PersistenceContext
    private EntityManager entityManager;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
        .addClasses(CalendarioFacadeREST.class, Calendario.class, DetalleOrdenTrabajoFacadeREST.class, DiagnosticoFacadeREST.class, DiagnosticoParteFacadeREST.class, EquipoFacadeREST.class,
            EstadoDetalleOrdenTrabajoFacadeREST.class, EstadoFacadeREST.class, ExcepcionCalendarioFacadeREST.class, MttoDetalleFacadeREST.class, OrdenTrabajoFacadeREST.class,
            ParteFacadeREST.class, PasosFacadeREST.class, PasosProcedimientoFacadeREST.class, PrioridadFacadeREST.class, ProcedimientoFacadeREST.class, ResponsableFacadeREST.class,
            SolicitudFacadeREST.class, SubtipoMttoFacadeREST.class, TipomttoFacadeREST.class, UnidadFacadeREST.class)
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        
    }
    
    @Inject
    CalendarioFacadeREST calendario;
    
    @Test
    public void probar_create() {
        Calendario c1 = new Calendario();
        c1.setFecha(Date.from(Instant.MIN));
        c1.setDescripcion("Nada");
        calendario.create(c1);
        List<Calendario> todo  = calendario.findAll();
        
        Assert.assertEquals(1, todo.size());
        
    }
    
}
