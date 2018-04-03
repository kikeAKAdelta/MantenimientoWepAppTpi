/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.arquillian;

import javax.inject.Inject;
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

/**
 *
 * @author ricky
 */
@RunWith(Arquillian.class)
public class CalendarioTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
        .addPackage(CalendarioFacadeREST.class.getPackage())
        .addAsResource(EmptyAsset.INSTANCE, "beans.xml");
        
    }
    
    @Inject
    CalendarioFacadeREST calendario;
    
    @Test
    public void probar_crear(){
        Calendario c1 = new Calendario();
    }
    
}
